<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Detail Form</title>
<!-- user form -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="content">
		<c:if test="${userDetail != null}">
			<form action="/PBL3/user-detail-update" method="post">
		</c:if>
		<c:if test="${userDetail == null}">
			<form action="/PBL3/user-detail-insert" method="post">
		</c:if>
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div class="row justify-content-center">
						<div class="col-md-5">
							<div class="box">
								<h3 class="heading text-center">
									<c:if test="${userDetail != null}">
            			Edit Resume
            			</c:if>
									<c:if test="${userDetail == null}">
            			Build Resume
            			</c:if>
								</h3>
								<c:if test="${userDetail != null}">
									<input type="hidden" name="id"
										value="<c:out value='${userDetail.idUser}' />" />
								</c:if>
								<hr>
								<form method="post" id="contactForm" name="contactForm">
									<div class="row">
										<div class="col-md-6 form-group">
											<div class="row">
												<label for="budget" class="col-form-label">Category</label>
											</div>
											<div class="row">
												<div class="select-job-items2">
													<select name="categoryS">
														<option value="">Choose</option>
														<c:forEach var="category" items="${categories}">
															<option value="${category.name}"
																<c:if test="${category.name == categoryS.name}">selected</c:if>>${category.name}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
										<div class="col-md-6 form-group">
											<div class="row">
												<label for="budget" class="col-form-label">Location</label>
											</div>
											<div class="row">
												<div class="select-job-items2">
													<select name="locationS">
														<option value="">Choose</option>
														<c:forEach var="location" items="${locations}">
															<option value="${location.name}"
																<c:if test="${location.name == locationS.name}">selected</c:if>>${location.name}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<div class="row">
												<label for="email" class="col-form-label">Education</label>
											</div>
											<div class="row">
												<input type="text" class="form-control" name="education"
													id="email" placeholder="Enter Education"
													value="<c:out value='${userDetail.education}' />">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-md-12 form-group">
											<div class="row">
												<label for="message" class="col-form-label">Work
													Experience</label>
											</div>
											<div class="row">
												<textarea class="form-control" name="workExperience"
													id="message" cols="30" rows="3	"
													placeholder="Enter Work Experience"><c:out
														value='${userDetail.workExperience}' /></textarea>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<div class="row">
												<label for="message" class="col-form-label">Professional
													Skills</label>
											</div>
											<div class="row">
												<textarea class="form-control" name="professionalSkills"
													id="message" cols="30" rows="4"
													placeholder="Enter Professional Skills"><c:out
														value='${userDetail.professionalSkills}' /></textarea>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<div class="row">
												<label for="email" class="col-form-label">Link Image</label>
											</div>
											<div class="row">
												<input type="text" class="form-control" name="img"
													id="email" placeholder="Enter Link Image"
													value="<c:out value='${userDetail.img}' />">
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="col-12 d-flex justify-content-center">
							<button type="submit" class="btn btn-success">Save</button>
						</div>
					</div>
					</form>
				</div>
			</div>
		</div>

		<script
			src="<c:url value = 'text_form_template/js/jquery-3.3.1.min.js'/>"></script>
		<script src="<c:url value = 'text_form_template/js/popper.min.js'/>"></script>
		<script
			src="<c:url value = 'text_form_template/js/bootstrap.min.js'/>"></script>
		<script
			src="<c:url value = 'text_form_template/js/jquery.validate.min.js'/>"></script>
		<script src="<c:url value = 'text_form_template/js/main.js'/>"></script>
</body>
</html>