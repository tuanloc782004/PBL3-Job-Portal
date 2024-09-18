package com.jobportal.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.RecruitersDAO;
import com.jobportal.model.Recruiters;

@WebServlet(urlPatterns = { "/admin-recruiter-edit" })
public class RecruitersEdit extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RecruitersDAO recruitersDAO;

	public RecruitersEdit() {
		this.recruitersDAO = new RecruitersDAO();
	}

	public void init() {
		recruitersDAO = new RecruitersDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Recruiters existingUser = recruitersDAO.selectRecruiter(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/recruiterForm.jsp");
			request.setAttribute("recruiter", existingUser);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
