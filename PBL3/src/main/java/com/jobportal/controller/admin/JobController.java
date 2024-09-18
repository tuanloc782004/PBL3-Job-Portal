package com.jobportal.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.CategoriesDAO;
import com.jobportal.DAO.JobsDAO;
import com.jobportal.DAO.LocationsDAO;
import com.jobportal.DAO.RecruitersDAO;
import com.jobportal.DAO.RecruitersDetailDAO;
import com.jobportal.DAO.TypesDAO;
import com.jobportal.model.Categories;
import com.jobportal.model.Jobs;
import com.jobportal.model.Locations;
import com.jobportal.model.Recruiters;
import com.jobportal.model.RecruitersDetail;
import com.jobportal.model.Types;

@WebServlet(urlPatterns = { "/admin-job" })
public class JobController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private JobsDAO jDAO;
	private RecruitersDAO rDAO;
	private CategoriesDAO cDAO;
	private LocationsDAO lDAO;
	private TypesDAO tDAO;
	private RecruitersDetailDAO rdDAO;

	public JobController() {
		this.jDAO = new JobsDAO();
		this.rDAO = new RecruitersDAO();
		this.cDAO = new CategoriesDAO();
		this.lDAO = new LocationsDAO();
		this.tDAO = new TypesDAO();
		this.rdDAO = new RecruitersDetailDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
			jobs = jDAO.getAllAdmin(limit, page);
			totalRecord = jDAO.countAllAdmin();
			request.setAttribute("totalRecord", totalRecord);
		} else if (categoryS != -1 && locationS == -1 && typeS == -1) {
			jobs = jDAO.getAllByCAdmin(categoryS, limit, page);
			totalRecord = jDAO.countAllByCAdmin(categoryS);
			request.setAttribute("totalRecord", totalRecord);
		} else if (categoryS == -1 && locationS != -1 && typeS == -1) {
			jobs = jDAO.getAllByLAdmin(locationS, limit, page);
			totalRecord = jDAO.countAllByLAdmin(locationS);
			request.setAttribute("totalRecord", totalRecord);
		} else if (categoryS == -1 && locationS == -1 && typeS != -1) {
			jobs = jDAO.getAllByTAdmin(typeS, limit, page);
			totalRecord = jDAO.countAllByTAdmin(typeS);
			request.setAttribute("totalRecord", totalRecord);
		} else if (categoryS != -1 && locationS != -1 && typeS == -1) {
			jobs = jDAO.getAllByCLAdmin(categoryS, locationS, limit, page);
			totalRecord = jDAO.countAllByCLAdmin(categoryS, locationS);
			request.setAttribute("totalRecord", totalRecord);
		} else if (categoryS != -1 && locationS == -1 && typeS != -1) {
			jobs = jDAO.getAllByCTAdmin(categoryS, typeS, limit, page);
			totalRecord = jDAO.countAllByCTAdmin(categoryS, typeS);
			request.setAttribute("totalRecord", totalRecord);
		} else if (categoryS == -1 && locationS != -1 && typeS != -1) {
			jobs = jDAO.getAllByLTAdmin(locationS, typeS, limit, page);
			totalRecord = jDAO.countAllByLTAdmin(locationS, typeS);
			request.setAttribute("totalRecord", totalRecord);
		} else {
			jobs = jDAO.getAllByCLTAdmin(categoryS, locationS, typeS, limit, page);
			totalRecord = jDAO.countAllByCLTAdmin(categoryS, locationS, typeS);
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/job.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
