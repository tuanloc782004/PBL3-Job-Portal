package com.jobportal.servlet.admin;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.RecruitersDAO;
import com.jobportal.model.Recruiters;

@WebServlet(urlPatterns = { "/admin-recruiter" })
public class RecruitersServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RecruitersDAO rDAO;

	public RecruitersServlet() {
		this.rDAO = new RecruitersDAO();
	}

	public void init() {
		rDAO = new RecruitersDAO();
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
			
			List<Recruiters> r = null;
			
			int totalRecord = 1;
			
			if (key == null || key == "" || key.isEmpty()) {
				r = rDAO.getDataAdmin(limit, page);
				totalRecord = rDAO.countDataAdmin();
				request.setAttribute("totalRecord", totalRecord);
			} else {
				r = rDAO.getDataByKeyAdmin(key, limit, page);
				totalRecord = rDAO.countDataByKeyAdmin(key);
				request.setAttribute("totalRecord", totalRecord);
			}
			
			request.setAttribute("listRecruiter", r);
			
			int totalPage = (int) Math.ceil((float) totalRecord / (float) limit);
			request.setAttribute("totalPage", totalPage);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/recruiter.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
