package com.jobportal.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.DAO.ApplicationsDAO;
import com.jobportal.DAO.CategoriesDAO;
import com.jobportal.DAO.JobsDAO;
import com.jobportal.DAO.LocationsDAO;
import com.jobportal.DAO.RecruitersDAO;
import com.jobportal.DAO.RecruitersDetailDAO;
import com.jobportal.DAO.TypesDAO;
import com.jobportal.model.Applications;
import com.jobportal.model.Categories;
import com.jobportal.model.Jobs;
import com.jobportal.model.Locations;
import com.jobportal.model.Recruiters;
import com.jobportal.model.RecruitersDetail;
import com.jobportal.model.Types;
import com.jobportal.model.Users;

@WebServlet(urlPatterns = { "/job-details", "/admin-job-details", "/user-job-details", "/recruiter-job-details" })
public class JobDetailsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private JobsDAO jDAO;
	private RecruitersDAO rDAO;
	private CategoriesDAO cDAO;
	private LocationsDAO lDAO;
	private TypesDAO tDAO;
	private RecruitersDetailDAO rdDAO;
	private ApplicationsDAO aDAO;

	public JobDetailsController() {
		this.jDAO = new JobsDAO();
		this.rDAO = new RecruitersDAO();
		this.cDAO = new CategoriesDAO();
		this.lDAO = new LocationsDAO();
		this.tDAO = new TypesDAO();
		this.rdDAO = new RecruitersDetailDAO();
		this.aDAO = new ApplicationsDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));

			HttpSession session = request.getSession();
			Users usLogin = (Users) session.getAttribute("user");

			if (usLogin != null) {

				int idUsLogin = usLogin.getId();

				Applications a = aDAO.selectData(id, idUsLogin);

				request.setAttribute("application", a);
			}

			Jobs job = jDAO.getDataById(id);

			Recruiters r = rDAO.selectRecruiter(job.getIdRecruiter());
			Categories c = cDAO.selectDataById(job.getIdCategory());
			Locations l = lDAO.selectDataById(job.getIdLocation());
			Types t = tDAO.selectDataById(job.getIdLocation());
			RecruitersDetail rd = rdDAO.selectRecruiterDetail(job.getIdRecruiter());

			job.setRecruiter(r);
			job.setCategory(c);
			job.setLocation(l);
			job.setType(t);
			job.setRecruiterDetail(rd);

			request.setAttribute("job", job);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/jobdetails.jsp");
			dispatcher.forward(request, response);
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}

}
