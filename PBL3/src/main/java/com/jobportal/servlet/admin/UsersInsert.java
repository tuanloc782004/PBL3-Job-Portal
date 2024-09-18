package com.jobportal.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.UsersDAO;
import com.jobportal.model.Users;

@WebServlet(urlPatterns = { "/admin-user-insert" })
public class UsersInsert extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsersDAO usersDAO;

	public UsersInsert() {
		this.usersDAO = new UsersDAO();
	}

	public void init() {
		usersDAO = new UsersDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String uname = request.getParameter("uname");
			String upwd = request.getParameter("upwd");
			String uemail = request.getParameter("uemail");
			String umobile = request.getParameter("umobile");
			Users newUser = new Users(uname, upwd, uemail, umobile);
			usersDAO.insertUser(newUser);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/user.jsp");
//			dispatcher.forward(request, response);
			response.sendRedirect(request.getContextPath() + "/admin-user");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
