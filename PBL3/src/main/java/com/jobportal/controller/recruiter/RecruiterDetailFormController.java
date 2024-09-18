package com.jobportal.controller.recruiter;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.CountriesDAO;
import com.jobportal.model.Countries;

@WebServlet(urlPatterns = { "/recruiter-detail-form" })
public class RecruiterDetailFormController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CountriesDAO cDAO;
	
	public RecruiterDetailFormController() {
		this.cDAO = new CountriesDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Countries> c = cDAO.getAll();
		
		request.setAttribute("countries", c);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/recruiter/recruiterDetailForm.jsp");
		rd.forward(request, response);
	}

}
