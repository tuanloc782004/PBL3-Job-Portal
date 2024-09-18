package com.jobportal.controller.admin;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.jobportal.DAO.JobsDAO;
import com.jobportal.DAO.RecruitersDAO;
import com.jobportal.DAO.UsersDAO;

@WebServlet(urlPatterns = { "/admin-dashboard" })
public class DashboardController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	JobsDAO jDAO;
	UsersDAO uDAO;
	RecruitersDAO rDAO;
	
	public DashboardController() {
		this.jDAO = new JobsDAO();
		this.uDAO = new UsersDAO();
		this.rDAO = new RecruitersDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int numOfJob = jDAO.count();
		int numOfUser = uDAO.count();
		int numOfRecruiter = rDAO.count();
		
		request.setAttribute("numOfJob", numOfJob);
		request.setAttribute("numOfUser", numOfUser);
		request.setAttribute("numOfRecruiter", numOfRecruiter);
		
		List<Integer> yearList = jDAO.getDistinctYears();
		request.setAttribute("years", yearList);
		
		Calendar calendar = Calendar.getInstance();
        int ys = calendar.get(Calendar.YEAR);
		
		String ysParam = request.getParameter("yearS");
		if (ysParam != null)
			ys = Integer.parseInt(ysParam);
		
		request.setAttribute("yearS", ys);
		
		Map<String, Integer> jobCountByMonth = jDAO.getJobCountByMonth(ys);
		request.setAttribute("jobCountByMonth", new Gson().toJson(jobCountByMonth));
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/dashboard.jsp");
		rd.forward(request, response);
		
	}

}
