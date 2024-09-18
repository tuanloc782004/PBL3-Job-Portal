package com.jobportal.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.CountriesDAO;
import com.jobportal.DAO.RecruitersDAO;
import com.jobportal.DAO.RecruitersDetailDAO;
import com.jobportal.model.Countries;
import com.jobportal.model.Recruiters;
import com.jobportal.model.RecruitersDetail;

@WebServlet(urlPatterns = { "/guest-recruiter-resume", "/user-recruiter-resume" })
public class RecruitersDetailController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private RecruitersDetailDAO uDAO;
	private CountriesDAO countriesDAO;
	private RecruitersDAO rDAO;

	public RecruitersDetailController() {
		this.uDAO = new RecruitersDetailDAO();
		this.countriesDAO = new CountriesDAO();
		this.rDAO = new RecruitersDAO();
	}

	public void init() {
		uDAO = new RecruitersDetailDAO();
		countriesDAO = new CountriesDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			int id = Integer.parseInt(request.getParameter("idRecruiter"));

			RecruitersDetail u = uDAO.selectRecruiterDetail(id);

			request.setAttribute("recruiterDetail", u);

			Countries co = countriesDAO.selectDataById(u.getIdCountry());
			request.setAttribute("country", co);
			
			Recruiters re = rDAO.selectRecruiter(id);
			request.setAttribute("recruiter", re);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/recruiterResume.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			
			e.printStackTrace();
		
		}

	}

}
