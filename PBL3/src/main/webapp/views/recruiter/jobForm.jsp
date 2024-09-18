<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recruiter - Job</title>
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,700,900&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value = '/text_form_template/fonts/icomoon/style.css'/>">
</head>
<body>
	<div class="content" style="height: 920px;">
		<c:if test="${job != null}">
			<form action="/PBL3/recruiter-job-update" method="post">
		</c:if>
		<c:if test="${job == null}">
			<form action="/PBL3/recruiter-job-insert" method="post">
		</c:if>
		<div class="container">
			<div class="card">
				<div class="card-body">
					<div class="row justify-content-center">
						<div class="col-md-5">
							<div class="box">
								<h3 class="heading text-center">
									<c:if test="${job != null}">
            			Edit Job
            			</c:if>
									<c:if test="${job == null}">
            			Post New Job
            			</c:if>
								</h3>
								<c:if test="${job != null}">
									<input type="hidden" name="id" value="${job.id}" />
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
												<label for="email" class="col-form-label">Salary</label>
											</div>
											<div class="row">
												<input type="text" class="form-control" name="salary"
													id="email" placeholder="Example: 5000$ - 6000$"
													value="<c:out value='${job.salary}' />">
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
													id="message" cols="30" rows="4"
													placeholder="Enter Description"><c:out
														value='${job.description}' /></textarea>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<div class="row">
												<label for="message" class="col-form-label">Requirement</label>
											</div>
											<div class="row">
												<textarea class="form-control" name="requirement"
													id="message" cols="30" rows="4"
													placeholder="Enter Requirement"><c:out
														value='${job.requirement}' /></textarea>
											</div>
										</div>
									</div>
									<div class="row mb-3">
										<div class="col-md-6 form-group">
											<div class="row">
												<label for="budget" class="col-form-label">Job Type</label>
											</div>
											<div class="row">
												<div class="select-job-items2">
													<select name="typeS">
														<option value="">Choose</option>
														<c:forEach var="type" items="${types}">
															<option value="${type.name}"
																<c:if test="${type.name == typeS.name}">selected</c:if>>${type.name}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
										<div class="col-md-6 form-group">
											<div class="row">
												<label for="message" class="col-form-label">Vacancy</label>
											</div>
											<div class="row">
												<input type="text" class="form-control" name="vacancy"
													id="date" placeholder="Example: 1"
													value="<c:out value='${job.vacancy}' />">
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