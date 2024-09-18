package com.jobportal.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jobportal.DAO.ApplicationsDAO;
import com.jobportal.DAO.CategoriesDAO;
import com.jobportal.DAO.ConfirmationsDAO;
import com.jobportal.DAO.JobsDAO;
import com.jobportal.DAO.LocationsDAO;
import com.jobportal.DAO.RecruitersDAO;
import com.jobportal.DAO.RecruitersDetailDAO;
import com.jobportal.DAO.TypesDAO;
import com.jobportal.model.Applications;
import com.jobportal.model.Categories;
import com.jobportal.model.Confirmations;
import com.jobportal.model.Jobs;
import com.jobportal.model.Locations;
import com.jobportal.model.Recruiters;
import com.jobportal.model.RecruitersDetail;
import com.jobportal.model.Types;
import com.jobportal.model.Users;

@WebServlet(urlPatterns = { "/user-applied-job" })
public class AppliedJobsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private JobsDAO jDAO;
	private RecruitersDAO rDAO;
	private CategoriesDAO cDAO;
	private LocationsDAO lDAO;
	private TypesDAO tDAO;
	private RecruitersDetailDAO rdDAO;
	private ApplicationsDAO aDAO;
	private ConfirmationsDAO cfDAO;

	public AppliedJobsController() {
		this.jDAO = new JobsDAO();
		this.rDAO = new RecruitersDAO();
		this.cDAO = new CategoriesDAO();
		this.lDAO = new LocationsDAO();
		this.tDAO = new TypesDAO();
		this.rdDAO = new RecruitersDetailDAO();
		this.aDAO = new ApplicationsDAO();
		this.cfDAO = new ConfirmationsDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Users usLogin = (Users) session.getAttribute("user");
		int idUsLogin = usLogin.getId();


		String categorySParam = request.getParameter("categoryS");
		int categoryS = categorySParam != null && !categorySParam.isEmpty() ? Integer.parseInt(categorySParam) : -1;

		String locationSParam = request.getParameter("locationS");
		int locationS = locationSParam != null && !locationSParam.isEmpty() ? Integer.parseInt(locationSParam) : -1;

		String typeSParam = request.getParameter("typeS");
		int typeS = typeSParam != null && !typeSParam.isEmpty() ? Integer.parseInt(typeSParam) : -1;

		String pageParam = request.getParameter("page");

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

		List<Jobs> jobs = null;
		
		int totalRecord = 1;

		if (categoryS == -1 && locationS == -1 && typeS == -1) {
			jobs = jDAO.getUs(limit, page, idUsLogin);
			totalRecord = jDAO.countUs(idUsLogin);
			request.setAttribute("totalRecord", totalRecord);
		} else if (categoryS != -1 && locationS == -1 && typeS == -1) {
			jobs = jDAO.getUsByC(categoryS, limit, page,idUsLogin);
			totalRecord = jDAO.countUsByC(categoryS, idUsLogin);
			request.setAttribute("totalRecord", totalRecord);
		} else if (categoryS == -1 && locationS != -1 && typeS == -1) {
			jobs = jDAO.getUsByL(locationS, limit, page, idUsLogin);
			totalRecord = jDAO.countUsByL(locationS, idUsLogin);
			request.setAttribute("totalRecord", totalRecord);
		} else if (categoryS == -1 && locationS == -1 && typeS != -1) {
			jobs = jDAO.getUsByT(typeS, limit, page, idUsLogin);
			totalRecord = jDAO.countUsByT(typeS, idUsLogin);
			request.setAttribute("totalRecord", totalRecord);
		} else if (categoryS != -1 && locationS != -1 && typeS == -1) {
			jobs = jDAO.getUsByCL(categoryS, locationS, limit, page, idUsLogin);
			totalRecord = jDAO.countUsByCL(categoryS, locationS, idUsLogin);
			request.setAttribute("totalRecord", totalRecord);
		} else if (categoryS != -1 && locationS == -1 && typeS != -1) {
			jobs = jDAO.getUsByCT(categoryS, typeS, limit, page, idUsLogin);
			totalRecord = jDAO.countUsByCT(categoryS, typeS, idUsLogin);
			request.setAttribute("totalRecord", totalRecord);
		} else if (categoryS == -1 && locationS != -1 && typeS != -1) {
			jobs = jDAO.getUsByLT(locationS, typeS, limit, page, idUsLogin);
			totalRecord = jDAO.countUsByLT(locationS, typeS, idUsLogin);
			request.setAttribute("totalRecord", totalRecord);
		} else {
			jobs = jDAO.getUsByCLT(categoryS, locationS, typeS, limit, page, idUsLogin);
			totalRecord = jDAO.countUsByCLT(categoryS, locationS, typeS, idUsLogin);
			request.setAttribute("totalRecord", totalRecord);
		}

		request.setAttribute("jobs", jobs);

		if (jobs != null) {
			for (Jobs job : jobs) {
				Recruiters recruiter = rDAO.selectRecruiter(job.getIdRecruiter());
				job.setRecruiter(recruiter);

				Categories category = cDAO.selectDataById(job.getIdCategory());
				job.setCategory(category);

				Locations location = lDAO.selectDataById(job.getIdLocation());
				job.setLocation(location);

				Types type = tDAO.selectDataById(job.getIdType());
				job.setType(type);

				RecruitersDetail recruiterDetail = rdDAO.selectRecruiterDetail(job.getIdRecruiter());
				job.setRecruiterDetail(recruiterDetail);
				
				Applications application = aDAO.selectData(job.getId(), idUsLogin);
				Confirmations confirmation = cfDAO.selectDataById(application.getIdConfirmation());
				job.setConfirmation(confirmation);
			}
		}

		int totalPage = (int) Math.ceil((float) totalRecord / (float) limit);
		request.setAttribute("totalPage", totalPage);

		List<Categories> c = cDAO.getAll();
		List<Types> t = tDAO.getAll();
		List<Locations> l = lDAO.getAll();

		request.setAttribute("categories", c);
		request.setAttribute("types", t);
		request.setAttribute("locations", l);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/appliedJob.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
