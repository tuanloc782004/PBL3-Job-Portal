<%@page import="com.jobportal.model.Countries"%>
<%@page import="com.jobportal.model.RecruitersDetail"%>
<%@page import="com.jobportal.model.UsersDetail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Recruiter - Introduce</title>
</head>
<body>
	<div class="main-body">
		<div class="row justify-content-center">
			<h3 class="text-center">Introduce</h3>
		</div>
		<div class="row justify-content-center">
			<div class="row gutters-sm" witdh="100%">
				<div class="col-md4 mb-3">
					<div class="card">
						<div class="card-body">
							<div class="d-flex flex-column align-items-center text-center">
								<img
									src="${pageContext.request.contextPath}<c:out value="${recruiterDetail.img}" />"
									alt="UserPic" class="rounded-square" width="150" />
								<div class="mt-3">
									<p class="text-secondary mb-1">
										<c:out value="${sessionScope.recruiter.uname}" />
									</p>
									<p class="text-muted font-size-sm text-capitalize">
										<i class=""fasfa-map-marker-alt"></i>
										<c:out value="${country.name}" />
									</p>
									<a id="editButton"
										href="
										<%=request.getContextPath()%>/recruiter-detail-form"
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
								<h6 class="mb-0">Description</h6>
							</div>
							<div class="col-sm-9 text-secondary text-capitalize">
								<c:out value="${recruiterDetail.description}" />
							</div>
						</div>
						<hr />
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Link web</h6>
							</div>
							<div class="col-sm-9 text-secondary text-capitalize">
								<a href="<c:out value="${recruiterDetail.web}" />"><p><c:out value="${recruiterDetail.web}" /></p></a>
							</div>
						</div>


						<hr />
						<div class="row">
							<div class="col-sm-3">
								<h6 class="mb-0">Contact</h6>
							</div>
							<div class="col-sm-9 text-secondary text-capitalize">
								<p>
									<c:out value="${sessionScope.recruiter.uemail}" />
								</p>
								<p>
									<c:out value="${sessionScope.recruiter.umobile}" />
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

	<%
		// Giả sử recruiterDetail là một đối tượng được truyền từ phía back-end
		RecruitersDetail recruiterDetail = (RecruitersDetail) request.getAttribute("recruiterDetail");
		Countries country = (Countries) request.getAttribute("country");
	%>

	<script>
		var recruiterDetailExists =
	<%=recruiterDetail != null ? "true" : "false"%>
		;

		var countryExists =
	<%=country != null ? "true" : "false"%>
		;

		// Nếu userDetail tồn tại, thêm sự kiện click vào nút Edit
		if (recruiterDetailExists && countryExists) {
			document
					.getElementById('editButton')
					.setAttribute("href",
							"/PBL3/recruiter-detail-edit?id=<c:out value='${recruiter.id}' />");
		}
	</script>

</body>
</html>