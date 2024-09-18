package com.jobportal.controller.recruiter;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.ApplicationsDAO;
import com.jobportal.DAO.ConfirmationsDAO;
import com.jobportal.DAO.JobsDAO;
import com.jobportal.DAO.UsersDAO;
import com.jobportal.model.Applications;
import com.jobportal.model.Confirmations;
import com.jobportal.model.Jobs;
import com.jobportal.model.Users;

@WebServlet(urlPatterns = { "/recruiter-job-applicant" })
public class ApplicantController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private UsersDAO uDAO;
	private ApplicationsDAO aDAO;
	private ConfirmationsDAO cDAO;
	private JobsDAO jDAO;
	
	public ApplicantController() {
		this.uDAO = new UsersDAO();
		this.aDAO = new ApplicationsDAO();
		this.cDAO = new ConfirmationsDAO();
		this.jDAO = new JobsDAO(); 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String key = request.getParameter("key");
		String pageParam = request.getParameter("page");
		int idJob = Integer.parseInt(request.getParameter("id"));
		
		List<Confirmations> confirmations = cDAO.getAll();
		request.setAttribute("confirmations", confirmations);
		
		Jobs job = jDAO.getDataById(idJob);
		
		request.setAttribute("job", job);
		
		int page = 1;
		int limit = 6;
		if (pageParam != null) {
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
			users = uDAO.getData(idJob, limit, page);
			totalRecord = uDAO.countData(idJob);
			request.setAttribute("totalRecord", totalRecord);
		} else {
			users = uDAO.getDataByKey(key, idJob, limit, page);
			totalRecord = uDAO.countDataByKey(key, idJob);
			request.setAttribute("totalRecord", totalRecord);
		}
		
		request.setAttribute("users", users);
		
		if (users != null) {
			for (Users user : users) {
				
				Applications application = aDAO.selectData(idJob, user.getId());
				Confirmations confirmation = cDAO.selectDataById(application.getIdConfirmation()); 
				user.setConfirmation(confirmation);
				user.setApplication(application);
				
			}
		}
		
		int totalPage = (int) Math.ceil((float) totalRecord / (float) limit);
		request.setAttribute("totalPage", totalPage);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/recruiter/applicant.jsp");
		rd.forward(request, response);
	}

}
