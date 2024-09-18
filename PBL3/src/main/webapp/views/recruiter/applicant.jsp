<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recruiter - Applicant</title>
</head>
<body>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Applicant</h3>
			<hr>
			<form class="row gy-2 gx-2 align-items-center"
				action="/PBL3/recruiter-job-applicant?key=<%=request.getParameter("key")%>"
				method="get">
				<input type="hidden" name="id" value="${job.id}">
				<div class="col-auto">
					<input type="text" class="form-control" id="autoSizingInput"
						name="key" placeholder="Enter Keyword" value="${param.key}">
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-primary"
						style="height: 35px; padding: 0 15px;">Search</button>
				</div>
			</form>
			<hr>
			<div class="row">
				<div class="col-lg-12">
					<div class="count-job mb-35">
						<span><c:out value="${totalRecord}" /> applicants found</span>
					</div>
				</div>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th style="width: 25%;">Status</th>
						<th style="width: 30%;">Name</th>
						<th style="width: 30%;">Email</th>
						<th style="width: 10%;">Mobile</th>
						<th style="width: 10%;">Resume</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${users}">

						<tr data-iduser=${user.id}>
							<td><c:if
									test="${user.confirmation.id == 2}">
									<div class="text-center" style="background-color: rgb(0, 250, 0);">
										<c:out value="${user.confirmation.name }" />
									</div>
								</c:if>
								<c:if
									test="${user.confirmation.id == 3}">
									<div class="text-center" style="background-color: rgb(255, 192, 203);">
										<c:out value="${user.confirmation.name }" />
									</div>
								</c:if> <c:if test="${user.confirmation.id == 1}">
									<div class="col-auto">
										<select name="cofirmationS" class="confirmationSelect">
											<c:forEach var="confirmation" items="${confirmations}">
												<option value="${confirmation.id}">${confirmation.name}</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-auto">
										<button class="btn btn-primary"
											style="height: 35px; padding: 0 15px;"
											onclick="navigateWithConfirmation(this)">Done</button>
									</div>
								</c:if></td>
							<td><c:out value="${user.uname}" /></td>
							<td><c:out value="${user.uemail}" /></td>
							<td><c:out value="${user.umobile}" /></td>

							<td><a
								href="/PBL3/recruiter-user-resume?id=<c:out value='${user.id}' />"><p>View</p></a>
							</td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
	<div class="pagination-area pb-115 text-center">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="single-wrap d-flex justify-content-center">
						<nav aria-label="...">
							<ul class="pagination">
								<c:if test="${page > 1}">
									<li class="page-item"><a class="page-link"
										href="/PBL3/recruiter-job-applicant?id=${job.id}&key=${param.key}&page=${page - 1}">Previous</a>
									</li>
								</c:if>
								<c:forEach var="temp" begin="1" end="${totalPage}">
									<c:choose>
										<c:when test="${temp == page}">
											<li class="page-item active"><a class="page-link"
												href="/PBL3/recruiter-job-applicant?id=${job.id}&key=${param.key}&page=${temp}">${temp}</a>
											</li>
										</c:when>
										<c:otherwise>
											<li class="page-item"><a class="page-link"
												href="/PBL3/recruiter-job-applicant?id=${job.id}&key=${param.key}&page=${temp}">${temp}</a>
											</li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:if test="${page < totalPage}">
									<li class="page-item"><a class="page-link"
										href="/PBL3/recruiter-job-applicant?id=${job.id}&key=${param.key}&page=${page + 1}">Next</a>
									</li>
								</c:if>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		function navigateWithConfirmation(button) {
			// Lấy phần tử tr của nút được nhấn
			var tableRow = button.closest('tr');

			// Lấy giá trị của thẻ select trong cùng một hàng
			var confirmationSelect = tableRow
					.querySelector('.confirmationSelect');
			var confirmationValue = confirmationSelect.value;

			// Lấy giá trị của id ứng viên từ thuộc tính data-idapplication
			var idUser = tableRow.dataset.iduser;

			// Tạo URL với cả ba giá trị: id của công việc, id của ứng viên và giá trị xác nhận
			var url = "/PBL3/recruiter-confirmation?idJob=${job.id}&idUser="
					+ idUser + "&idConfirmation=" + confirmationValue;

			// Chuyển hướng đến URL mới
			window.location.replace(url);
		}
	</script>
</body>
</html>