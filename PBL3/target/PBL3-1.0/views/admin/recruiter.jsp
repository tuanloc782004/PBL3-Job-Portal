<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - All Recruiters</title>
</head>
<body>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Recruiters</h3>
			<hr>
			<div class="container text-left">


				<a href="<%=request.getContextPath()%>/admin-recruiter-form"
					class="btn btn-success">Add New Recruiter</a>
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
					<c:forEach var="recruiter" items="${listRecruiter}">

						<tr>
							<td><c:out value="${recruiter.id}" /></td>
							<td><c:out value="${recruiter.uname}" /></td>
							<td><c:out value="${recruiter.upwd}" /></td>
							<td><c:out value="${recruiter.uemail}" /></td>
							<td><c:out value="${recruiter.umobile}" /></td>
							 
							<td><a
								href="/PBL3/admin-recruiter-edit?id=<c:out value='${recruiter.id}' />"><p>Edit</p></a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="/PBL3/admin-recruiter-delete?id=<c:out value='${recruiter.id}' />"><p>Delete</p></a>
							</td>							
							
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>