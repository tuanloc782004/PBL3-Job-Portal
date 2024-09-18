package com.jobportal.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.RecruitersDAO;
import com.jobportal.model.Recruiters;

@WebServlet(urlPatterns = { "/admin-recruiter-insert" })
public class RecruitersInsert extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RecruitersDAO recruitersDAO;

	public RecruitersInsert() {
		this.recruitersDAO = new RecruitersDAO();
	}

	public void init() {
		recruitersDAO = new RecruitersDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String uname = request.getParameter("uname");
			String upwd = request.getParameter("upwd");
			String uemail = request.getParameter("uemail");
			String umobile = request.getParameter("umobile");
			Recruiters newRecruiter = new Recruiters(uname, upwd, uemail, umobile);
			recruitersDAO.insertRecruiter(newRecruiter);
			response.sendRedirect(request.getContextPath() + "/admin-recruiter");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
