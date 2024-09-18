<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Job Portal</title>
</head>
<body>
	<main> <!-- job post company Start -->
	<div class="job-post-company pt-120 pb-120">
		<div class="container">
			<div class="row justify-content-between">
				<!-- Left Content -->
				<div class="col-xl-7 col-lg-8">
					<!-- job single -->
					<div class="single-job-items mb-50">
						<div class="job-items">
							<input type="hidden" name="id"
								value="<c:out value='${job.id}' />" />
							<div class="company-img company-img-details">
								<img
									src="${pageContext.request.contextPath}<c:out value="${job.recruiterDetail.img}"/>"
									alt="" style="width: 70px; height: 70px;">
							</div>
							<div class="job-tittle">
								<h4>
									<c:out value="${job.category.name}" />
								</h4>
								<ul>
									<li><c:out value="${job.recruiter.uname}" /></li>
									<li><i class="fas fa-map-marker-alt"></i> <c:out
											value="${job.location.name}" /></li>
									<li><c:out value="${job.salary}" /></li>
								</ul>
							</div>
						</div>
					</div>
					<!-- job single End -->

					<div class="job-post-details">
						<div class="post-details1 mb-50">
							<!-- Small Section Tittle -->
							<div class="small-section-tittle">
								<h4>Job Description</h4>
							</div>
							<p>
								<c:out value="${job.description}" />
							</p>
						</div>
						<div class="post-details2  mb-50">
							<!-- Small Section Tittle -->
							<div class="small-section-tittle">
								<h4>Required Knowledge, Skills, and Abilities</h4>
							</div>
							<p>
								<c:out value="${job.requirement}" />
							</p>
						</div>
					</div>

				</div>
				<!-- Right Content -->
				<div class="col-xl-4 col-lg-4">
					<div class="post-details3  mb-50">
						<!-- Small Section Tittle -->
						<div class="small-section-tittle">
							<h4>Job Overview</h4>
						</div>
						<ul>
							<li>Posted date : <span><p>
										<c:out value="${job.postDate}" />
									</p></span></li>
							<li>Location : <span><p>
										<c:out value="${job.location.name}" />
									</p></span></li>
							<li>Vacancy : <span><p>
										<c:out value="${job.vacancy}" />
									</p></span></li>
							<li>Job nature : <span><p>
										<c:out value="${job.type.name}" />
									</p></span></li>
							<li>Salary : <span><p>
										<c:out value="${job.salary}" />
									</p></span></li>
						</ul>
						<c:if
							test="${sessionScope.user == null && sessionScope.recruiter == null && application == null}">
							<div class="apply-btn2">
								<a href="/PBL3/login?id=${job.id }" class="btn">Login To
									Apply</a>
							</div>
						</c:if>
						<c:if
							test="${sessionScope.user != null && sessionScope.user.uemail != 'admin@gmail.com' && application == null}">
							<div class="apply-btn2">
								<a href="#" class="btn" onclick="submitForm('${job.id}')">Apply</a>
							</div>
						</c:if>
					</div>
					<div class="post-details4  mb-50">
						<!-- Small Section Tittle -->
						<div class="small-section-tittle">
							<h4>Company Information</h4>
						</div>
						<ul>
							<li>Name: <span><c:out value="${job.recruiter.uname}" /></span></li>
							<li>Web : <span><c:out
										value="${job.recruiterDetail.web}" /></span></li>
							<li>Email: <span><c:out
										value="${job.recruiter.uemail}" /></span></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- job post company End --> </main>
	<script>
		function submitForm(jobId) {
			const form = document.createElement('form');
			form.method = 'POST';
			form.action = '/PBL3/user-apply';

			const hiddenField = document.createElement('input');
			hiddenField.type = 'hidden';
			hiddenField.name = 'id';
			hiddenField.value = jobId;

			form.appendChild(hiddenField);
			document.body.appendChild(form);
			form.submit();
		}
	</script>
</body>
</html>