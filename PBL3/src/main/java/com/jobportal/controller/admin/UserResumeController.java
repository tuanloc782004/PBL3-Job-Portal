package com.jobportal.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.CategoriesDAO;
import com.jobportal.DAO.LocationsDAO;
import com.jobportal.DAO.UsersDAO;
import com.jobportal.DAO.UsersDetailDAO;
import com.jobportal.model.Categories;
import com.jobportal.model.Locations;
import com.jobportal.model.Users;
import com.jobportal.model.UsersDetail;

@WebServlet(urlPatterns = { "/admin-user-resume", "/recruiter-user-resume" })
public class UserResumeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UsersDAO uDAO;
	private UsersDetailDAO udDAO;
	private LocationsDAO lDAO;
	private CategoriesDAO cDAO;
	
	public UserResumeController() {
		this.uDAO = new UsersDAO();
		this.udDAO = new UsersDetailDAO();
		this.lDAO = new LocationsDAO();
		this.cDAO = new CategoriesDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Users u = uDAO.selectUser(id);
			UsersDetail ud = udDAO.selectUserDetail(id);
			
			Locations l = lDAO.selectDataById(ud.getIdLocation());
			Categories c = cDAO.selectDataById(ud.getIdCategory());
			
			request.setAttribute("user", u);
			request.setAttribute("userDetail", ud);
			request.setAttribute("location", l);
			request.setAttribute("category", c);
			
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/userResume.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("/PBL3/admin-user");
		}
	}

}
