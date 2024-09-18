<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>User - Resume</title>
</head>
<body>
	<div class="main-body">
		<div class="row justify-content-center">
			<h3 class="text-center">Resume</h3>
		</div>
		<div class="row justify-content-center">
			<div class="row gutters-sm" witdh="100%">
				<div class="col-md4 mb-3">
					<div class="card">
						<div class="card-body">
							<div class="d-flex flex-column align-items-center text-center">
								<img
									src="${pageContext.request.contextPath}<c:out value="${userDetail.img}" />"
									alt="UserPic" class="rounded-square" width="150" />
								<div class="mt-3">
									<p class="text-secondary mb-1">
										<c:out value="${sessionScope.user.uname}" />
									</p>
									<p class="text-muted font-size-sm text-capitalize">
										<i class=""fasfa-map-marker-alt"></i><c:out value="${userDetail.country}" />
									</p>
									<a href="<%=request.getContextPath()%>/user-detail-form"
										class="btn btn-success">Edit</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<div class="card mb-3">
					<div class="card-body">
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Category</h6>
							</div>
							<div class="col-sm-9 text-secondary text-capitalize"><c:out value="${userDetail.category}" /></div>
						</div>
						<hr />
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Work experience</h6>
							</div>
							<div class="col-sm-9 text-secondary text-capitalize"><c:out value="${userDetail.workExperience}" /></div>
						</div>
						<hr />
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Education</h6>
							</div>
							<div class="col-sm-9 text-secondary text-capitalize"><c:out value="${userDetail.education}" /></div>
						</div>
						<hr />
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Professional Skills</h6>
							</div>
							<div class="col-sm-9 text-secondary text-capitalize"><c:out value="${userDetail.professionalSkills}" /></div>
						</div>
						<hr />
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Contact</h6>
							</div>
							<div class="col-sm-9 text-secondary text-capitalize">
								<p>
									<c:out value="${sessionScope.user.uemail}" />
								</p>
								<p>
									<c:out value="${sessionScope.user.umobile}" />
								</p>
							</div>
						</div>
						<hr />
					</div>
				</div>
			</div>
		</div>
		<br>
	</div>
</body>
</html>