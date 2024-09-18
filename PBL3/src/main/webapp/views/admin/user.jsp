<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - All Users</title>
</head>
<body>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="row">
				<div class="col-md-8">
					<form class="form-inline" action="/PBL3/admin-user"
						method="get">
						<div class="form-group mb-2">
							<input type="text" class="form-control" id="autoSizingInput"
								name="key" placeholder="Enter Keyword" value="${param.key}">
						</div>
						<button type="submit" class="btn btn-primary mb-2 ml-2"
							style="height: 35px; padding: 0 15px;">Search</button>
					</form>
				</div>
				<div class="col-md-4 text-right">
					<a href="<%=request.getContextPath()%>/admin-user-form"
						class="btn btn-success">Add New User</a>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-lg-12">
					<div class="count-job mb-35">
						<span><c:out value="${totalRecord}" /> users found</span>
					</div>
				</div>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Password</th>
						<th>Email</th>
						<th>Mobile</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.uname}" /></td>
							<td><c:out value="${user.upwd}" /></td>
							<td><c:out value="${user.uemail}" /></td>
							<td><c:out value="${user.umobile}" /></td>

							<td><a
								href="/PBL3/admin-user-edit?id=<c:out value='${user.id}' />"><p>Edit</p></a>
								<a
								href="/PBL3/admin-user-delete?id=<c:out value='${user.id}' />"><p>Delete</p></a>
								<a
								href="/PBL3/admin-user-resume?id=<c:out value='${user.id}' />"><p>View</p></a>
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
										href="/PBL3/admin-user?key=${param.key}&page=${page - 1}">Previous</a>
									</li>
								</c:if>
								<c:forEach var="temp" begin="1" end="${totalPage}">
									<c:choose>
										<c:when test="${temp == page}">
											<li class="page-item active"><a class="page-link"
												href="/PBL3/admin-user?key=${param.key}&page=${temp}">${temp}</a>
											</li>
										</c:when>
										<c:otherwise>
											<li class="page-item"><a class="page-link"
												href="/PBL3/admin-user?key=${param.key}&page=${temp}">${temp}</a>
											</li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:if test="${page < totalPage}">
									<li class="page-item"><a class="page-link"
										href="/PBL3/admin-user?key=${param.key}&page=${page + 1}">Next</a>
									</li>
								</c:if>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>