package com.jobportal.servlet.recruiter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.DAO.CategoriesDAO;
import com.jobportal.DAO.JobsDAO;
import com.jobportal.DAO.LocationsDAO;
import com.jobportal.DAO.TypesDAO;
import com.jobportal.model.Categories;
import com.jobportal.model.Jobs;
import com.jobportal.model.Locations;
import com.jobportal.model.Recruiters;
import com.jobportal.model.Types;

@WebServlet(urlPatterns = { "/recruiter-job-update" })
public class JobsUpdate extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private JobsDAO jDAO;
	private CategoriesDAO cDAO;
	private LocationsDAO lDAO;
	private TypesDAO tDAO;

	public JobsUpdate() {
		this.jDAO = new JobsDAO();
		this.cDAO = new CategoriesDAO();
		this.lDAO = new LocationsDAO();
		this.tDAO = new TypesDAO();
	}

	public void init() {
		jDAO = new JobsDAO();
		cDAO = new CategoriesDAO();
		lDAO = new LocationsDAO();
		tDAO = new TypesDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			String c = request.getParameter("categoryS");
			String l = request.getParameter("locationS");
			String t = request.getParameter("typeS");
			
			Categories category = cDAO.selectDataByName(c);
			Locations location = lDAO.selectDataByName(l);
			Types type = tDAO.selectDataByName(t);
			
			int idCategory = category.getId();
			int idLocation = location.getId();
			int idType = type.getId();
			String salary = request.getParameter("salary");
			String description = request.getParameter("description");
			String requirement = request.getParameter("requirement");
			int vacancy = Integer.parseInt(request.getParameter("vacancy"));
			
			HttpSession session = request.getSession();
			Recruiters recruiter = (Recruiters) session.getAttribute("recruiter");
			int idRecruiter =recruiter.getId();
			
			Jobs job = new Jobs(id, idRecruiter, idCategory, idLocation, idType, salary, description, requirement, vacancy);
			
			jDAO.updateData(job);
			
			response.sendRedirect(request.getContextPath() + "/recruiter-job");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}
