<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Admin - Dashboard</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link
	href="${pageContext.request.contextPath}/dashboard/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/dashboard/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/dashboard/css/ruang-admin.min.css"
	rel="stylesheet">
</head>
<body id="page-top">
	<div id="wrapper">
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<hr>
				<div class="container-fluid" id="container-wrapper">
					<h3 class="text-center">Dashboard</h3>
					<hr>
					<div class="row mb-3">
						<!-- Job Count Card -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card h-100">
								<div class="card-body">
									<div class="row align-items-center">
										<div class="col mr-2">
											<div class="text-xs font-weight-bold text-uppercase mb-1">Job</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">${numOfJob}</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-calendar fa-2x text-primary"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- User Count Card -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card h-100">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div class="text-xs font-weight-bold text-uppercase mb-1">User</div>
											<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">${numOfUser}</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-users fa-2x text-info"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Recruiter Count Card -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card h-100">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div class="text-xs font-weight-bold text-uppercase mb-1">Recruiter</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">${numOfRecruiter}</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-shopping-cart fa-2x text-success"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Chart -->
						<div class="container-fluid" id="container-wrapper">
							<div
								class="d-sm-flex align-items-center justify-content-between mb-4">
								<h1 class="h3 mb-0 text-gray-800">Chart</h1>
								<form method="get"
									action="${pageContext.request.contextPath}/admin-dashboard">
									<div class="row">
										<div class="select-job-items2">
											<select name="yearS">
												<c:forEach var="year" items="${years}">
													<option value="${year}"
														<c:if test="${year == yearS}">selected</c:if>>${year}</option>
												</c:forEach>
											</select>
										</div>
										<button type="submit" class="btn btn-primary mb-2 ml-2"
											style="height: 35px; padding: 0 15px;">Year</button>
									</div>
								</form>
							</div>
							<div class="row">
								<div class="col-lg-12">
									<div class="card mb-4">
										<div
											class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
											<h6 class="m-0 font-weight-bold text-primary">Posted Job</h6>
										</div>
										<div class="card-body">
											<div class="chart-area">
												<canvas id="jobCountChart" height="400"></canvas>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="${pageContext.request.contextPath}/dashboard/vendor/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/dashboard/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/dashboard/vendor/jquery-easing/jquery.easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/dashboard/js/ruang-admin.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/dashboard/vendor/chart.js/Chart.min.js"></script>
	<script>
		// Set new default font family and font color to mimic Bootstrap's default styling
				Chart.defaults.global.defaultFontFamily = 'Nunito',
				'-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
		Chart.defaults.global.defaultFontColor = '#858796';

		// Function to format numbers
		function number_format(number, decimals, dec_point, thousands_sep) {
			number = (number + '').replace(',', '').replace(' ', '');
			var n = !isFinite(+number) ? 0 : +number, prec = !isFinite(+decimals) ? 0
					: Math.abs(decimals), sep = (typeof thousands_sep === 'undefined') ? ','
					: thousands_sep, dec = (typeof dec_point === 'undefined') ? '.'
					: dec_point, s = '', toFixedFix = function(n, prec) {
				var k = Math.pow(10, prec);
				return '' + Math.round(n * k) / k;
			};
			s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
			if (s[0].length > 3) {
				s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
			}
			if ((s[1] || '').length < prec) {
				s[1] = s[1] || '';
				s[1] += new Array(prec - s[1].length + 1).join('0');
			}
			return s.join(dec);
		}

		// Get job count data from server
		var jobCountByMonth = JSON.parse('${jobCountByMonth}');

		// Area Chart Example
		var ctx = document.getElementById("jobCountChart");
		var myLineChart = new Chart(
				ctx,
				{
					type : 'line',
					data : {
						labels : [ "Jan", "Feb", "Mar", "Apr", "May", "Jun",
								"Jul", "Aug", "Sep", "Oct", "Nov", "Dec" ],
						datasets : [ {
							label : "Jobs",
							lineTension : 0.3,
							backgroundColor : "rgba(78, 115, 223, 0.5)",
							borderColor : "rgba(78, 115, 223, 1)",
							pointRadius : 3,
							pointBackgroundColor : "rgba(78, 115, 223, 1)",
							pointBorderColor : "rgba(78, 115, 223, 1)",
							pointHoverRadius : 3,
							pointHoverBackgroundColor : "rgba(78, 115, 223, 1)",
							pointHoverBorderColor : "rgba(78, 115, 223, 1)",
							pointHitRadius : 10,
							pointBorderWidth : 2,
							data : [ jobCountByMonth['1'] || 0,
									jobCountByMonth['2'] || 0,
									jobCountByMonth['3'] || 0,
									jobCountByMonth['4'] || 0,
									jobCountByMonth['5'] || 0,
									jobCountByMonth['6'] || 0,
									jobCountByMonth['7'] || 0,
									jobCountByMonth['8'] || 0,
									jobCountByMonth['9'] || 0,
									jobCountByMonth['10'] || 0,
									jobCountByMonth['11'] || 0,
									jobCountByMonth['12'] || 0 ],
						} ],
					},
					options : {
						maintainAspectRatio : false,
						layout : {
							padding : {
								left : 10,
								right : 25,
								top : 25,
								bottom : 0
							}
						},
						scales : {
							xAxes : [ {
								time : {
									unit : 'date'
								},
								gridLines : {
									display : false,
									drawBorder : false
								},
								ticks : {
									maxTicksLimit : 7
								}
							} ],
							yAxes : [ {
								ticks : {
									maxTicksLimit : 5,
									padding : 10,
									callback : function(value, index, values) {
										return number_format(value);
									}
								},
								gridLines : {
									color : "rgb(234, 236, 244)",
									zeroLineColor : "rgb(234, 236, 244)",
									drawBorder : false,
									borderDash : [ 2 ],
									zeroLineBorderDash : [ 2 ]
								}
							} ],
						},
						legend : {
							display : false
						},
						tooltips : {
							backgroundColor : "rgb(255,255,255)",
							bodyFontColor : "#858796",
							titleMarginBottom : 10,
							titleFontColor : '#6e707e',
							titleFontSize : 14,
							borderColor : '#dddfeb',
							borderWidth : 1,
							xPadding : 15,
							yPadding : 15,
							displayColors : false,
							intersect : false,
							mode : 'index',
							caretPadding : 10,
							callbacks : {
								label : function(tooltipItem, chart) {
									var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label
											|| '';
									return datasetLabel + ': '
											+ number_format(tooltipItem.yLabel);
								}
							}
						}
					}
				});
	</script>
</body>
</html>
