package com.jobportal.controller.admin;

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

@WebServlet(urlPatterns = { "/admin-recruiter-resume"})
public class RecruiterResumeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private RecruitersDAO rDAO;
	private RecruitersDetailDAO rdDAO;
	private CountriesDAO cDAO;
	
	public RecruiterResumeController() {
		this.rDAO = new RecruitersDAO();
		this.rdDAO = new RecruitersDetailDAO();
		this.cDAO = new CountriesDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Recruiters r = rDAO.selectRecruiter(id);
			RecruitersDetail rd = rdDAO.selectRecruiterDetail(id);
			Countries c = cDAO.selectDataById(rd.getIdCountry());
			
			request.setAttribute("recruiter", r);
			request.setAttribute("recruiterDetail", rd);
			request.setAttribute("country", c);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/recruiterResume.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("/PBL3/admin-recruiter");
		}
	}

}
