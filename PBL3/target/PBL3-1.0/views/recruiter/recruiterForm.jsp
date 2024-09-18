<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recruiter Form</title>
<!-- user form -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
		<br>
		<div class="container col-md-5">
			<div class="card">
				<div class="card-body">

					<form action="/PBL3/admin-recruiter-update" method="get">

						<caption>
							<h2>Edit</h2>
						</caption>

						<input type="hidden" name="id"
							value="<c:out value='${sessionScope.recruiter.id}' />" />

						<fieldset class="form-group">
							<label>Recruiter Name</label> <input type="text"
								value="<c:out value='${sessionScope.recruiter.uname}' />"
								class="form-control" name="uname" required="required">
						</fieldset>

						<fieldset class="form-group">
							<label>Recruiter Email</label> <input type="text"
								value="<c:out value='${sessionScope.recruiter.uemail}' />"
								class="form-control" name="uemail">
						</fieldset>

						<fieldset class="form-group">
							<label>Recruiter Password</label> <input type="password"
								value="<c:out value='${sessionScope.recruiter.upwd}' />"
								class="form-control" name="upwd">
						</fieldset>

						<fieldset class="form-group">
							<label>Recruiter Mobile</label> <input type="number"
								value="<c:out value='${sessionScope.recruiter.umobile}' />"
								class="form-control" name="umobile">
						</fieldset>

						<button type="submit" class="btn btn-success">Save</button>
					</form>
				</div>
			</div>
		</div>
</body>
</html>