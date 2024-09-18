package com.jobportal.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.UsersDAO;

@WebServlet(urlPatterns = { "/admin-user-delete" })
public class UsersDelete extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsersDAO usersDAO;

	public UsersDelete() {
		this.usersDAO = new UsersDAO();
	}

	public void init() {
		usersDAO = new UsersDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			usersDAO.deleteUser(id);
			response.sendRedirect(request.getContextPath() + "/admin-user");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
