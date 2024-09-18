package com.jobportal.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.DAO.CategoriesDAO;
import com.jobportal.DAO.LocationsDAO;
import com.jobportal.DAO.UsersDetailDAO;
import com.jobportal.model.Categories;
import com.jobportal.model.Locations;
import com.jobportal.model.Users;
import com.jobportal.model.UsersDetail;

@WebServlet(urlPatterns = { "/user-resume" })
public class UsersDetailServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UsersDetailDAO uDAO;
	private LocationsDAO lDAO;
	private CategoriesDAO cDAO;

	public UsersDetailServlet() {
		this.uDAO = new UsersDetailDAO();
		this.lDAO = new LocationsDAO();
		this.cDAO = new CategoriesDAO();
	}

	public void init() {
		uDAO = new UsersDetailDAO();
		lDAO = new LocationsDAO();
		cDAO = new CategoriesDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			Users user = (Users) session.getAttribute("user");
			int id = user.getId();
			
			UsersDetail u = uDAO.selectUserDetail(id);
			
			if (u == null) {
				response.sendRedirect("/PBL3/user-detail-form");
				return;
			}

			else {
				request.setAttribute("userDetail", u);
				
				Locations l = lDAO.selectDataById(u.getIdLocation());
				request.setAttribute("location", l);
				
				Categories c = cDAO.selectDataById(u.getIdCategory());
				request.setAttribute("category", c);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/resume.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
