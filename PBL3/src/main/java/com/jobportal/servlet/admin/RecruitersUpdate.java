package com.jobportal.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.DAO.RecruitersDAO;
import com.jobportal.model.Recruiters;

@WebServlet(urlPatterns = { "/admin-recruiter-update" })
public class RecruitersUpdate extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RecruitersDAO recruitersDAO;

	public RecruitersUpdate() {
		this.recruitersDAO = new RecruitersDAO();
	}

	public void init() {
		recruitersDAO = new RecruitersDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String uname = request.getParameter("uname");
			String upwd = request.getParameter("upwd");
			String uemail = request.getParameter("uemail");
			String umobile = request.getParameter("umobile");
			Recruiters newr = new Recruiters(id, uname, upwd, uemail, umobile);
			recruitersDAO.updateRecruiter(newr);

			response.sendRedirect(request.getContextPath() + "/admin-recruiter");

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
			Recruiters newr = new Recruiters(id, uname, upwd, uemail, umobile);
			recruitersDAO.updateRecruiter(newr);

			HttpSession session = request.getSession();
			session.setAttribute("recruiter", newr);
			response.sendRedirect("/PBL3/recruiter-home");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
