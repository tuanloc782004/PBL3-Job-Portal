<header>
	<!-- Header Start -->
	<div class="header-area header-transparrent">
		<div class="headder-top header-sticky">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-lg-3 col-md-2">
						<!-- Logo -->
						<div class="logo">
							<a href="/PBL3/trang-chu"><img
								src="<c:url value = '/assets/img/logo/logo.png'/>" alt="" /></a>
						</div>
					</div>
					<div class="col-lg-9 col-md-9">
						<div class="menu-wrapper">
							<!-- Main-menu -->
							<div class="main-menu">
								<nav class="d-none d-lg-block">
									<ul id="navigation">
										<li><a href="${pageContext.request.contextPath}/user-job">Find
												a Jobs</a></li>
										<li><a
											href="${pageContext.request.contextPath}/user-applied-jobs">Applied
												Jobs</a></li>
										<li><a
											href="${pageContext.request.contextPath}/user-resume">Resume</a></li>
										<li><a
											href="${pageContext.request.contextPath}/user-change-password">Change
												Password</a></li>
									</ul>
								</nav>
							</div>
							<!-- Header-btn -->
							<div class="header-btn d-none f-right d-lg-block">
								<a href="${pageContext.request.contextPath}/user-home"
									class="btn head-btn1">User</a> <a
									href="${pageContext.request.contextPath}/logout"
									class="btn head-btn2">Logout</a>
							</div>
						</div>
					</div>
					<!-- Mobile Menu -->
					<div class="col-12">
						<div class="mobile_menu d-block d-lg-none"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Header End -->
</header>