<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin - All Jobs</title>
</head>
<body>
	<form
		action="/PBL3/admin-job?locationS=<%=request.getParameter("locationS")%>&typeS=<%=request.getParameter("typeS")%>&categoryS=<%=request.getParameter("categoryS")%>"
		method="get">
		<main> <!-- Hero Area Start--> <!-- Hero Area End --> <!-- Job List Area Start -->
		<div class="job-listing-area pt-120 pb-120">
			<div class="container">
				<h3 class="text-center">List of Jobs</h3>
				<hr>
				<div class="row">
					<!-- Left content -->
					<div class="col-xl-3 col-lg-3 col-md-4">
						<div class="row">
							<div class="col-12">
								<div class="small-section-tittle2 mb-45">
									<div class="ion">
										<svg xmlns="http://www.w3.org/2000/svg"
											xmlns:xlink="http://www.w3.org/1999/xlink" width="20px"
											height="12px">
                                    <path fill-rule="evenodd"
												fill="rgb(27, 207, 107)"
												d="M7.778,12.000 L12.222,12.000 L12.222,10.000 L7.778,10.000 L7.778,12.000 ZM-0.000,-0.000 L-0.000,2.000 L20.000,2.000 L20.000,-0.000 L-0.000,-0.000 ZM3.333,7.000 L16.667,7.000 L16.667,5.000 L3.333,5.000 L3.333,7.000 Z" />
                                    </svg>
									</div>
									<h4>Filter Jobs</h4>
								</div>
							</div>
						</div>
						<!-- Job Category Listing start -->
						<div class="job-category-listing mb-50">
							<!-- single one -->
							<div class="single-listing">
								<div class="small-section-tittle2">
									<h4>Job Category</h4>
								</div>
								<!-- Select job items start -->
								<div class="select-job-items2">
									<select name="categoryS">
										<option value="">All Category</option>
										<c:forEach var="category" items="${categories}">
											<option value="${category.id}"
												<c:if test="${category.id == param.categoryS}">selected</c:if>>${category.name}</option>
										</c:forEach>
									</select>
								</div>
								<!--  Select job items End-->
							</div>
							<div class="single-listing">
								<h4>&nbsp</h4>
							</div>
							<!-- single two -->
							<div class="single-listing">
								<div class="small-section-tittle2">
									<h4>Job Location</h4>
								</div>
								<!-- Select job items start -->
								<div class="select-job-items2">
									<select name="locationS">
										<option value="">Anywhere</option>
										<c:forEach var="location" items="${locations}">
											<option value="${location.id}"
												<c:if test="${location.id == param.locationS}">selected</c:if>>${location.name}</option>
										</c:forEach>
									</select>
								</div>
								<!--  Select job items End-->
							</div>
							<div class="single-listing">
								<h4>&nbsp</h4>
							</div>
							<!-- single three -->
							<div class="single-listing">
								<div class="small-section-tittle2">
									<h4>Job Type</h4>
								</div>
								<!-- Select job items start -->
								<div class="select-job-items2">
									<select name="typeS">
										<option value="">All Type</option>
										<c:forEach var="type" items="${types}">
											<option value="${type.id}"
												<c:if test="${type.id == param.typeS}">selected</c:if>>${type.name}</option>
										</c:forEach>
									</select>
								</div>
								<!--  Select job items End-->
							</div>
							<div class="single-listing">
								<h4>&nbsp</h4>
							</div>
							<!-- single 4 -->
							<div class="single-listing">
								<div class="single-wrap d-flex justify-content-center">
									<button type="submit" class="btn btn-success">Search</button>
								</div>
							</div>

						</div>
						<!-- Job Category Listing End -->
					</div>
					<!-- Right content -->
					<div class="col-xl-9 col-lg-9 col-md-8">
						<!-- Featured_job_start -->
						<section class="featured-job-area">
							<div class="container">
								<!-- Count of Job list Start -->
								<div class="row">
									<div class="col-lg-12">
										<div class="count-job mb-35">
											<span><c:out value="${totalRecord}" /> Jobs found</span>
										</div>
									</div>
								</div>
								<!-- Count of Job list End -->
								<!-- single-job-content -->
								<c:forEach var="job" items="${jobs}">
									<!-- single-job-content start -->
									<div class="single-job-items mb-30">
										<div class="job-items">
											<div class="company-img">
												<a href="/PBL3/admin-recruiter-resume?id=${job.idRecruiter}"><img
													src="${pageContext.request.contextPath}<c:out value="${job.recruiterDetail.img}" />"
													alt="" style="width: 100px; height: 100px;"></a>
											</div>
											<div class="job-tittle job-tittle2">
												<h4>
													<c:out value="${job.category.name}" />
												</h4>
												<div>
													<c:out value="${job.recruiter.uname}" />
												</div>
												<!-- Job Location and Salary on the next line -->
												<div>
													<i class="fas fa-map-marker-alt"></i>
													<c:out value="${job.location.name}" />
													<span> | </span>
													<c:out value="${job.salary}" />
												</div>
												<div class="row">
													<div class="col-md-4">
														<div class="items-link items-link2 f-left">
															<a href="/PBL3/admin-job-repudiate?id=${job.id}"
																style="background-color: rgb(255, 192, 203);">Repudiate</a>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="items-link items-link2 f-right">
											<a href="/PBL3/admin-job-details?id=${job.id}" />
											<c:out value="${job.type.name}" />
											</a>
											<div class="col-md-4">
												<div class="items-link items-link2 f-left">
													<a href="/PBL3/admin-job-delete?id=${job.id}"
														style="background-color: rgb(0, 250, 0);">Authenticate</a>
												</div>
											</div>
											<span><c:out value="${job.postDate}" /></span>
										</div>
									</div>
									<!-- single-job-content end-->
								</c:forEach>
							</div>
						</section>
						<!-- Featured_job_end -->
					</div>
				</div>
			</div>
		</div>
		<!-- Job List Area End --> <!--Pagination Start  -->
		<div class="pagination-area pb-115 text-center">
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="single-wrap d-flex justify-content-center">
							<nav aria-label="...">
								<ul class="pagination">
									<c:if test="${page > 1}">
										<li class="page-item"><a class="page-link"
											href="/PBL3/admin-job?locationS=${param.locationS}&typeS=${param.typeS}&categoryS=${param.categoryS}&page=${page - 1}">Previous</a>
										</li>
									</c:if>
									<c:forEach var="temp" begin="1" end="${totalPage}">
										<c:choose>
											<c:when test="${temp == page}">
												<li class="page-item active"><a class="page-link"
													href="/PBL3/admin-job?locationS=${param.locationS}&typeS=${param.typeS}&categoryS=${param.categoryS}&page=${temp}">${temp}</a>
												</li>
											</c:when>
											<c:otherwise>
												<li class="page-item"><a class="page-link"
													href="/PBL3/admin-job?locationS=${param.locationS}&typeS=${param.typeS}&categoryS=${param.categoryS}&page=${temp}">${temp}</a>
												</li>
											</c:otherwise>
										</c:choose>
									</c:forEach>
									<c:if test="${page < totalPage}">
										<li class="page-item"><a class="page-link"
											href="/PBL3/admin-job?locationS=${param.locationS}&typeS=${param.typeS}&categoryS=${param.categoryS}&page=${page + 1}">Next</a>
										</li>
									</c:if>
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--Pagination End  --> </main>
	</form>
</body>
</html>