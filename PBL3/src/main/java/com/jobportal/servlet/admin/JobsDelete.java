package com.jobportal.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.JobsDAO;

@WebServlet(urlPatterns = { "/admin-job-delete"})
public class JobsDelete extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private JobsDAO jDAO;

	public JobsDelete() {
		this.jDAO = new JobsDAO();
	}

	public void init() {
		jDAO = new JobsDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			jDAO.updateDisplay(id);
			response.sendRedirect(request.getContextPath() + "/admin-job");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
