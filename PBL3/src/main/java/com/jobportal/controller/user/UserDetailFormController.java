package com.jobportal.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.CategoriesDAO;
import com.jobportal.DAO.LocationsDAO;
import com.jobportal.model.Categories;
import com.jobportal.model.Locations;

@WebServlet(urlPatterns = { "/user-detail-form" })
public class UserDetailFormController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private LocationsDAO lDAO;
	private CategoriesDAO cDAO;
	
	public UserDetailFormController() {
		lDAO = new LocationsDAO();
		cDAO = new CategoriesDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Locations> l = lDAO.getAll();
		List<Categories> c = cDAO.getAll();
		
		request.setAttribute("locations", l);
		request.setAttribute("categories", c);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/user/userDetailForm.jsp");
		rd.forward(request, response);
	}

}
