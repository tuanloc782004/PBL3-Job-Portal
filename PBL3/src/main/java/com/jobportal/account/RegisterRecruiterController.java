package com.jobportal.account;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/register-recruiter" })
public class RegisterRecruiterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/login/registrationRecruiter.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("pass");
		String reupwd = request.getParameter("re_pass");
		String umobile = request.getParameter("contact");
		RequestDispatcher dispatcher = null;
		Connection con = null;
		if (uname == null || uname.equals("") || uemail == null || uemail.equals("") || upwd == null || upwd.equals("")
				|| !upwd.equals(reupwd) || umobile == null || umobile.equals("") || umobile.length() > 10 ||  umobile.length() < 10) {
			if (uname == null || uname.equals("")) {
				request.setAttribute("status", "invalidName");
				dispatcher = request.getRequestDispatcher("/views/login/registrationRecruiter.jsp");
				dispatcher.forward(request, response);
			}
			if (uemail == null || uemail.equals("")) {
				request.setAttribute("status", "invalidEmail");
				dispatcher = request.getRequestDispatcher("/views/login/registrationRecruiter.jsp");
				dispatcher.forward(request, response);
			}
			if (upwd == null || upwd.equals("")) {
				request.setAttribute("status", "invalidUpwd");
				dispatcher = request.getRequestDispatcher("/views/login/registrationRecruiter.jsp");
				dispatcher.forward(request, response);
			} else if (!upwd.equals(reupwd)) {
				request.setAttribute("status", "invalidConfirmUpwd");
				dispatcher = request.getRequestDispatcher("/views/login/registrationRecruiter.jsp");
				dispatcher.forward(request, response);
			}
			if (umobile == null || umobile.equals("")) {
				request.setAttribute("status", "invalidUmobile");
				dispatcher = request.getRequestDispatcher("/views/login/registrationRecruiter.jsp");
				dispatcher.forward(request, response);
			} else if (umobile.length() > 10 || umobile.length() < 10) {
				request.setAttribute("status", "invalidUmobileLength");
				dispatcher = request.getRequestDispatcher("/views/login/registrationRecruiter.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal?useSSL=false", "root",
						"782004tuanloc");
				PreparedStatement pst = con
						.prepareStatement("insert into recruiters(uname, upwd, uemail, umobile) values(?,?,?,?)");
				pst.setString(1, uname);
				pst.setString(2, upwd);
				pst.setString(3, uemail);
				pst.setString(4, umobile);

				int rowCount = pst.executeUpdate();
				dispatcher = request.getRequestDispatcher("/views/login/registrationRecruiter.jsp");
				if (rowCount > 0) {
					request.setAttribute("status", "success");
				} else {
					request.setAttribute("status", "failed");
				}
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
