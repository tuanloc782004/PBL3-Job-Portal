package com.jobportal.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.RecruitersDAO;

@WebServlet(urlPatterns = { "/admin-recruiter-delete" })
public class RecruitersDelete extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RecruitersDAO recruitersDAO;

	public RecruitersDelete() {
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
			recruitersDAO.deleteRecruiter(id);
			response.sendRedirect(request.getContextPath() + "/admin-recruiter");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
