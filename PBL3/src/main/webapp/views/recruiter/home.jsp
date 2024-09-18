<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Recruiter - Home</title>
</head>
<body>
	<div class="main-body">
		<div class="row justify-content-center">
			<h3 class="text-center">Account Information</h3>
		</div>
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card mb-3">
					<div class="card-body">
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Company Name</h6>
							</div>
							<div class="col-sm-9 text-secondary text-capitalize">
								<c:out value="${sessionScope.recruiter.uname}" />
							</div>
						</div>
						<hr />
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Email</h6>
							</div>
							<div class="col-sm-9 text-secondary text-capitalize">
								<c:out value="${sessionScope.recruiter.uemail}" />
							</div>
						</div>
						<hr />
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Password</h6>
							</div>
							<div class="col-sm-9 text-secondary text-capitalize">
								<c:out value="${sessionScope.recruiter.upwd}" />
							</div>
						</div>
						<hr />
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Mobile</h6>
							</div>
							<div class="col-sm-9 text-secondary text-capitalize">
								<c:out value="${sessionScope.recruiter.umobile}" />
							</div>
						</div>
						<hr />
					</div>
				</div>
			</div>
		</div>
		<div class="row justify-content-center">
			<a href="<%=request.getContextPath()%>/recruiter-form"
				class="btn btn-success">Edit</a>
		</div>
	</div>
</body>
</html>