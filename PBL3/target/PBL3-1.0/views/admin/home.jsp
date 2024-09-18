<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Admin - Home</title>
<style>
.background-image {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	object-fit: cover;
	text-align: center
}

.centered-text {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
	color: white;
	font-size: 36px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<img src="${pageContext.request.contextPath}/all_component/Home.jpg"
				alt="Background Image" class="background-image">
		</div>
		<div class="row justify-content-center">
			<div class="centered-text">
				<h1>WELCOME ADMIN</h1>
			</div>
		</div>
	</div>
</body>
</html>