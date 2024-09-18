<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recruiter Detail Form</title>
<!-- user form -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="content">
		<c:if test="${recruiterDetail != null}">
			<form action="/PBL3/recruiter-detail-update" method="post">
		</c:if>
		<c:if test="${recruiterDetail == null}">
			<form action="/PBL3/recruiter-detail-insert" method="post">
		</c:if>
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div class="row justify-content-center">
						<div class="col-md-5">
							<div class="box">
								<h3 class="heading text-center">
									<c:if test="${recruiterDetail != null}">
            			Edit Resume
            			</c:if>
									<c:if test="${recruiterDetail == null}">
            			Build Resume
            			</c:if>
								</h3>
								<c:if test="${recruiterDetail != null}">
									<input type="hidden" name="id"
										value="<c:out value='${recruiterDetail.idRecruiter}' />" />
								</c:if>
								<hr>
								<form method="post" id="contactForm" name="contactForm">
									<div class="row">
										<div class="col-md-6 form-group">
											<div class="row">
												<label for="budget" class="col-form-label">Country</label>
											</div>
											<div class="row">
												<div class="select-job-items2">
													<select name="countryS">
														<option value="">Choose</option>
														<c:forEach var="country" items="${countries}">
															<option value="${country.name}"
																<c:if test="${country.name == countryS.name}">selected</c:if>>${country.name}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<div class="row">
												<label for="message" class="col-form-label">Description</label>
											</div>
											<div class="row">
												<textarea class="form-control" name="description"
													id="message" cols="30" rows="7"
													placeholder="Enter Description"><c:out
														value='${recruiterDetail.description}' /></textarea>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<div class="row">
												<label for="email" class="col-form-label">Link web</label>
											</div>
											<div class="row">
												<input type="text" class="form-control" name="web"
													id="email" placeholder="Enter Link Web"
													value="<c:out value='${recruiterDetail.web}' />">
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
													value="<c:out value='${recruiterDetail.img}' />">
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