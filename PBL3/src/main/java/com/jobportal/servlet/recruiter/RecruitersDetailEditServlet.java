package com.jobportal.servlet.recruiter;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.CountriesDAO;
import com.jobportal.DAO.RecruitersDetailDAO;
import com.jobportal.model.Countries;
import com.jobportal.model.RecruitersDetail;

@WebServlet(urlPatterns = { "/recruiter-detail-edit" })
public class RecruitersDetailEditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private RecruitersDetailDAO recruitersDetailDAO;
	private CountriesDAO countriesDAO;

	public void init() {
		recruitersDetailDAO = new RecruitersDetailDAO();
		countriesDAO = new CountriesDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			List<Countries> c = countriesDAO.getAll();
			request.setAttribute("countries", c);
			
			int id = Integer.parseInt(request.getParameter("id"));
			RecruitersDetail existingUser = recruitersDetailDAO.selectRecruiterDetail(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/recruiter/recruiterDetailForm.jsp");
			request.setAttribute("recruiterDetail", existingUser);
			
			Countries co = countriesDAO.selectDataById(existingUser.getIdCountry());
			request.setAttribute("countryS", co);
			
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
