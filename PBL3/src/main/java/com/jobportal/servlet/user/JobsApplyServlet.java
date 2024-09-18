package com.jobportal.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.DAO.ApplicationsDAO;
import com.jobportal.model.Applications;
import com.jobportal.model.Users;

@WebServlet(urlPatterns = { "/user-apply" })
public class JobsApplyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ApplicationsDAO aDAO;
	
	public JobsApplyServlet() {
		this.aDAO = new ApplicationsDAO();
	}

	public void init() {
		aDAO = new ApplicationsDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			int idJob = Integer.parseInt(request.getParameter("id"));
			int idConfirmation = 1;
			
			HttpSession session = request.getSession();
			Users user = (Users) session.getAttribute("user");
			int idUser = user.getId();
			
			Applications a = new Applications(idJob, idUser, idConfirmation);
			
			aDAO.insertData(a);
			
			response.sendRedirect(request.getContextPath() + "/user-applied-job");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
