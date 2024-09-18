<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - Recruiter Form</title>
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

				<c:if test="${recruiter != null}">
					<form action="/PBL3/admin-recruiter-update" method="post">
				</c:if>
				<c:if test="${recruiter == null}">
					<form action="/PBL3/admin-recruiter-insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${recruiter != null}">
            			Edit Recruiter
            		</c:if>
						<c:if test="${recruiter == null}">
            			Add New Recruiter
            		</c:if>
					</h2>
				</caption>

				<c:if test="${recruiter != null}">
					<input type="hidden" name="id"
						value="<c:out value='${recruiter.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Recruiter Name</label> <input type="text"
						value="<c:out value='${recruiter.uname}' />" class="form-control"
						name="uname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Recruiter Email</label> <input type="text"
						value="<c:out value='${recruiter.uemail}' />" class="form-control"
						name="uemail">
				</fieldset>

				<fieldset class="form-group">
					<label>Recruiter Password</label> <input type="password"
						value="<c:out value='${recruiter.upwd}' />" class="form-control"
						name="upwd">
				</fieldset>

				<fieldset class="form-group">
					<label>Recruiter Mobile</label> <input type="number"
						value="<c:out value='${recruiter.umobile}' />"
						class="form-control" name="umobile">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>