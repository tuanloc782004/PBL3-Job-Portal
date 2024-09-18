package com.jobportal.servlet.user;

import java.io.IOException;

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

@WebServlet(urlPatterns = { "/user-detail-insert" })
public class UsersDetailInsertServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UsersDetailDAO userDetailDAO;
	private LocationsDAO lDAO;
	private CategoriesDAO cDAO;
	
	public UsersDetailInsertServlet() {
		this.userDetailDAO = new UsersDetailDAO();
		this.lDAO = new LocationsDAO();
		this.cDAO = new CategoriesDAO();
	}

	public void init() {
		userDetailDAO = new UsersDetailDAO();
		lDAO = new LocationsDAO();
		cDAO = new CategoriesDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String category = request.getParameter("categoryS");
			String location = request.getParameter("locationS");
			String workExperience = request.getParameter("workExperience");
			String education = request.getParameter("education");
			String professionalSkills = request.getParameter("professionalSkills");
			String img = request.getParameter("img");
			
			Locations l = lDAO.selectDataByName(location);
			int idLocation = l.getId();
			
			Categories c = cDAO.selectDataByName(category);
			int idCategory = c.getId();
			
			HttpSession session = request.getSession();
			Users user = (Users) session.getAttribute("user");
			int id =user.getId();
			
			UsersDetail newU = new UsersDetail(id, idCategory, idLocation, workExperience, education, professionalSkills, img);
			userDetailDAO.insertUser(newU);

			response.sendRedirect(request.getContextPath() + "/user-resume");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
