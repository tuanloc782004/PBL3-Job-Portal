<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html14/loose.dtd">
<html class="no-js" lang="zxx">
<head>
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title><dec:title default="Job Portal" /></title>

<link rel="manifest" href="site.webmanifest">
<link rel="shortcut icon" type="image/x-icon"
	href="<c:url value = '/assets/img/favicon.ico'/>" />

<!-- css -->
<link rel="stylesheet"
	href="<c:url value = '/assets/css/bootstrap.min.css'/>">
<link rel="stylesheet"
	href="<c:url value = '/assets/css/owl.carousel.min.css'/>" />
<link rel="stylesheet"
	href="<c:url value = '/assets/css/flaticon.css'/>" />
<link rel="stylesheet"
	href="<c:url value = '/assets/css/price_rangs.css'/>" />
<link rel="stylesheet"
	href="<c:url value = '/assets/css/slicknav.css'/>" />
<link rel="stylesheet"
	href="<c:url value = '/assets/css/animate.min.css'/>" />
<link rel="stylesheet"
	href="<c:url value = '/assets/css/magnific-popup.css'/>" />
<link rel="stylesheet"
	href="<c:url value = '/assets/css/fontawesome-all.min.css'/>" />
<link rel="stylesheet"
	href="<c:url value = '/assets/css/themify-icons.css'/>" />
<link rel="stylesheet" href="<c:url value = '/assets/css/slick.css'/>" />
<link rel="stylesheet"
	href="<c:url value = '/assets/css/nice-select.css'/>" />
<link rel="stylesheet" href="<c:url value = '/assets/css/style.css'/>" />

</head>
<body>
	<!-- Preloader Start -->
	<div id="preloader-active">
		<div
			class="preloader d-flex align-items-center justify-content-center">
			<div class="preloader-inner position-relative">
				<div class="preloader-circle"></div>
				<div class="preloader-img pere-text">
					<img src="<c:url value = '/assets/img/logo/logo.png'/>" alt="" />
				</div>
			</div>
		</div>
	</div>
	<!-- Preloader Start -->

	<!-- header -->
	<%@ include file="/common/user/header.jsp"%>

	<div class="container">
		<dec:body />
	</div>

	<!-- All JS Custom Plugins Link Here here -->
	<script
		src="<c:url value = '/assets/js/vendor/modernizr-3.5.0.min.js'/>" /></script>
	<!-- Jquery, Popper, Bootstrap -->
	<script src="<c:url value = '/assets/js/vendor/jquery-1.12.4.min.js'/>" /></script>
	<script src="<c:url value = '/assets/js/popper.min.js'/>" /></script>
	<script src="<c:url value = '/assets/js/bootstrap.min.js'/>" /></script>
	<!-- Jquery Mobile Menu -->
	<script src="<c:url value = '/assets/js/jquery.slicknav.min.js'/>" /></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="<c:url value = '/assets/js/owl.carousel.min.js'/>" /></script>
	<script src="<c:url value = '/assets/js/slick.min.js'/>" /></script>
	<script src="<c:url value = '/assets/js/price_rangs.js'/>" /></script>

	<!-- One Page, Animated-HeadLin -->
	<script src="<c:url value = '/assets/js/wow.min.js'/>" /></script>
	<script src="<c:url value = '/assets/js/animated.headline.js'/>" /></script>
	<script src="<c:url value = '/assets/js/jquery.magnific-popup.js'/>" /></script>

	<!-- Scrollup, nice-select, sticky -->
	<script src="<c:url value = '/assets/js/jquery.scrollUp.min.js'/>" /></script>
	<script src="<c:url value = '/assets/js/jquery.nice-select.min.js'/>" /></script>
	<script src="<c:url value = '/assets/js/jquery.sticky.js'/>" /></script>

	<!-- contact js -->
	<script src="<c:url value = '/assets/js/contact.js'/>" /></script>
	<script src="<c:url value = '/assets/js/jquery.form.js'/>" /></script>
	<script src="<c:url value = '/assets/js/jquery.validate.min.js'/>" /></script>
	<script src="<c:url value = '/assets/js/mail-script.js'/>" /></script>
	<script src="<c:url value = '/assets/js/jquery.ajaxchimp.min.js'/>" /></script>

	<!-- Jquery Plugins, main Jquery -->
	<script src="<c:url value = '/assets/js/plugins.js'/>" /></script>
	<script src="<c:url value = '/assets/js/main.js'/>" /></script>

</body>
</html>