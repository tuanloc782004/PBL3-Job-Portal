package com.jobportal.controller.recruiter;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.CategoriesDAO;
import com.jobportal.DAO.LocationsDAO;
import com.jobportal.DAO.TypesDAO;
import com.jobportal.model.Categories;
import com.jobportal.model.Locations;
import com.jobportal.model.Types;

@WebServlet(urlPatterns = { "/recruiter-job-new" })
public class JobFormController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CategoriesDAO cDAO;
	private LocationsDAO lDAO;
	private TypesDAO tDAO;
	
	public JobFormController() {
		this.cDAO = new CategoriesDAO();
		this.lDAO = new LocationsDAO();
		this.tDAO = new TypesDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Categories> c = cDAO.getAll();
		List<Locations> l = lDAO.getAll();
		List<Types> t = tDAO.getAll();
		
		request.setAttribute("categories", c);
		request.setAttribute("locations", l);
		request.setAttribute("types", t);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/recruiter/jobForm.jsp");
		rd.forward(request, response);
	}

}
