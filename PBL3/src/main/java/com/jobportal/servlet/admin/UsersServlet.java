package com.jobportal.servlet.admin;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.UsersDAO;
import com.jobportal.model.Users;

@WebServlet(urlPatterns = { "/admin-user" })
public class UsersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UsersDAO uDAO;

	public UsersServlet() {
		this.uDAO = new UsersDAO();
	}

	public void init() {
		uDAO = new UsersDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String key = request.getParameter("key");
			String pageParam = request.getParameter("page");
			
			int page = 1;
			int limit = 6;
			if (pageParam != null && !pageParam.isEmpty()) {
				try {
					page = Integer.parseInt(pageParam);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			request.setAttribute("page", page);
			
			List<Users> users = null;
			
			int totalRecord = 1;
			
			if (key == null || key == "" || key.isEmpty()) {
				users = uDAO.getDataAdmin(limit, page);
				totalRecord = uDAO.countDataAdmin();
				request.setAttribute("totalRecord", totalRecord);
			} else {
				users = uDAO.getDataByKeyAdmin(key, limit, page);
				totalRecord = uDAO.countDataByKeyAdmin(key);
				request.setAttribute("totalRecord", totalRecord);
			}
			
			request.setAttribute("listUser", users);
			
			int totalPage = (int) Math.ceil((float) totalRecord / (float) limit);
			request.setAttribute("totalPage", totalPage);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/user.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
