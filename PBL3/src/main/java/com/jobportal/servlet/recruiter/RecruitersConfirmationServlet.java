package com.jobportal.servlet.recruiter;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jobportal.DAO.ApplicationsDAO;
import com.jobportal.DAO.JobsDAO;
import com.jobportal.DAO.RecruitersDAO;
import com.jobportal.DAO.UsersDAO;
import com.jobportal.model.Jobs;
import com.jobportal.model.Recruiters;
import com.jobportal.model.Users;

@WebServlet(urlPatterns = { "/recruiter-confirmation" })
public class RecruitersConfirmationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ApplicationsDAO aDAO;
	private UsersDAO uDAO;
	private JobsDAO jDAO;
	private RecruitersDAO rDAO;

	public RecruitersConfirmationServlet() {
		this.aDAO = new ApplicationsDAO();
		this.uDAO = new UsersDAO();
		this.jDAO = new JobsDAO();
		this.rDAO = new RecruitersDAO();

	}

	public void init() {
		aDAO = new ApplicationsDAO();
		uDAO = new UsersDAO();
		jDAO = new JobsDAO();
		rDAO = new RecruitersDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			int idJob = Integer.parseInt(request.getParameter("idJob"));
			int idUser = Integer.parseInt(request.getParameter("idUser"));
			int idConfirmation = Integer.parseInt(request.getParameter("idConfirmation"));

			Jobs job = jDAO.getDataById(idJob);

			if (idConfirmation == 1) {
				response.sendRedirect("/PBL3/recruiter-job-applicant?id=" + idJob);
			} else {

				aDAO.updateData(idConfirmation, idJob, idUser);

				Users user = uDAO.selectUser(idUser);

				Recruiters recruiter = rDAO.selectRecruiter(job.getIdRecruiter());

				String to = user.getUemail();

				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.socketFactory.port", "465");
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "465");
				Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("cuem782004@gmail.com", "xrfpkhmkdmhsxkky");
					}
				});

				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress("cuem782004@gmail.com"));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
					if (idConfirmation == 2) {
						message.setSubject("Congratulations");
						message.setText("Congratulations " + user.getUname()
								+ ", you have passed the resume screening stage to proceed to the interview round. Please contact "
								+ recruiter.getUname() + " for further information exchange.");
					} else {
						message.setSubject("Sorry");
						message.setText("Sorry " + user.getUname()
								+ ", you have not pass the resume screening stage to proceed to the interview round. Please contact "
								+ recruiter.getUname() + " for further information exchange.");
					}
					Transport.send(message);
					System.out.println("message sent successfully");
				}

				catch (MessagingException e) {
					throw new RuntimeException(e);
				}

				response.sendRedirect("/PBL3/recruiter-job-applicant?id=" + idJob);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
