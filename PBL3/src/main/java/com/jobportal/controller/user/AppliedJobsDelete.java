package com.jobportal.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.DAO.ApplicationsDAO;
import com.jobportal.model.Users;

@WebServlet(urlPatterns = { "/user-applied-job-delete" })
public class AppliedJobsDelete extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ApplicationsDAO aDAO;
	
	public AppliedJobsDelete () {
		this.aDAO = new ApplicationsDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		
		HttpSession session = request.getSession();
		Users usLogin = (Users) session.getAttribute("user");
		int idUsLogin = usLogin.getId();
		
		int idJob = Integer.parseInt(request.getParameter("id"));
		
		aDAO.deleteData(idJob, idUsLogin);
		
		response.sendRedirect(request.getContextPath() + "/user-applied-job");
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}
