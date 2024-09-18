package com.jobportal.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.DAO.UsersDAO;
import com.jobportal.model.Users;

@WebServlet(urlPatterns = { "/admin-user-update" })
public class UsersUpdate extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsersDAO usersDAO;

	public UsersUpdate() {
		this.usersDAO = new UsersDAO();
	}

	public void init() {
		usersDAO = new UsersDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String uname = request.getParameter("uname");
			String upwd = request.getParameter("upwd");
			String uemail = request.getParameter("uemail");
			String umobile = request.getParameter("umobile");
			Users newUser = new Users(id, uname, upwd, uemail, umobile);
			usersDAO.updateUser(newUser);

			response.sendRedirect(request.getContextPath() + "/admin-user");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String uname = request.getParameter("uname");
			String upwd = request.getParameter("upwd");
			String uemail = request.getParameter("uemail");
			String umobile = request.getParameter("umobile");
			Users newUser = new Users(id, uname, upwd, uemail, umobile);
			usersDAO.updateUser(newUser);

			HttpSession session = request.getSession();
			session.setAttribute("user", newUser);
			response.sendRedirect("/PBL3/user-home");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
