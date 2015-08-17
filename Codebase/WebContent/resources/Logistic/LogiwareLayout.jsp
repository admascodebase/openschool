<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<title>Logistic Management</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/Logistic/assets/img/favicon.ico">

<link
	href="${pageContext.request.contextPath}/resources/Logistic/assets/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/Logistic/assets/css/new.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/Logistic/assets/css/charts-graphs.css"
	rel="stylesheet">
<!-- Datepicker CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/Logistic/assets/css/datepicker.css">

<link
	href="${pageContext.request.contextPath}/resources/Logistic/assets/fonts/font-awesome.min.css"
	rel="stylesheet">

<script
	src="${pageContext.request.contextPath}/resources/Logistic/assets/js/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/Logistic/assets/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/Logistic/assets/js/jquery.scrollUp.js"></script>

<!-- jQuery UI JS -->
<script
	src="${pageContext.request.contextPath}/resources/Logistic/assets/js/jquery-ui-v1.10.3.js"></script>

<!-- Just Gage -->
<script
	src="${pageContext.request.contextPath}/resources/Logistic/assets/js/justgage/justgage.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/Logistic/assets/js/justgage/raphael.2.1.0.min.js"></script>

<%--  <!-- Flot Charts -->
    <script src="${pageContext.request.contextPath}/resources/Logistic/assets/js/flot/jquery.flot.js"></script>
    <script src="${pageContext.request.contextPath}/resources/Logistic/assets/js/flot/jquery.flot.orderBar.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/Logistic/assets/js/flot/jquery.flot.stack.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/Logistic/assets/js/flot/jquery.flot.pie.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/Logistic/assets/js/flot/jquery.flot.tooltip.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/Logistic/assets/js/flot/jquery.flot.resize.min.js"></script> --%>

<!-- Custom JS -->
<script
	src="${pageContext.request.contextPath}/resources/Logistic/assets/js/menu.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/Logistic/assets/js/custom-index2.js"></script>

<!-- HTML5 shiv and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<!-- Header Start -->
	<header>
       <a href="index.html" class="logo">
        <img src="${pageContext.request.contextPath}/resources/Logistic/assets/img/logo.png" alt="Logo"/>
      </a>
      <div class="pull-right">
        <ul id="mini-nav" class="clearfix">
          <li class="list-box hidden-xs">
           
            <!-- Modal -->
            <div class="modal fade" id="modalMd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel5" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title text-danger" id="myModalLabel5">Coding Style </h4>
                  </div>
                  <div class="modal-body">
                    <img src="${pageContext.request.contextPath}/resources/Logistic/assets/img/documentation.png" alt="Esquare Admin">
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                  </div>
                </div>
              </div>
            </div>
          </li>
          <li class="list-box dropdown">
            <a id="drop5" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-film"></i>
            </a>
            <span class="info-label info-bg">9+</span>
            <ul class="dropdown-menu stats-widget clearfix">
              <li>
                <h5 class="text-success">$37895</h5>
                <p>Revenue <span class="text-success">+2%</span></p>
                <div class="progress progress-mini">
                  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                    <span class="sr-only">40% Complete (success)</span>
                  </div>
                </div>
              </li>
              <li>
                <h5 class="text-warning">47,892</h5>
                <p>Downloads <span class="text-warning">+39%</span></p>
                <div class="progress progress-mini">
                  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                    <span class="sr-only">40% Complete (warning)</span>
                  </div>
                </div>
              </li>
              <li>
                <h5 class="text-danger">28214</h5>
                <p>Uploads <span class="text-danger">-7%</span></p>
                <div class="progress progress-mini">
                  <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                    <span class="sr-only">40% Complete (danger)</span>
                  </div>
                </div>
              </li>
            </ul>
          </li>
          <li class="list-box dropdown">
            <a id="drop5" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-calendar"></i>
            </a>
            <span class="info-label success-bg">6</span>
            <ul class="dropdown-menu server-activity">
              <li>
                <p><i class="fa fa-flag text-info"></i> Pending request<span class="time">3 hrs</span></p>
              </li>
              <li>
                <p><i class="fa fa-fire text-warning"></i> Server Crashed<span class="time">3mins</span></p>
              </li>
              <li>
                <p><i class="fa fa-user text-success"></i> 3 New users<span class="time">1 min</span></p>
              </li>
              <li>
                <p><i class="fa fa-bell text-danger"></i>9 pending requests<span class="time">5 min</span></p>
              </li>
              <li>
                <p><i class="fa fa-plane text-info"></i> Performance<span class="time">25 min</span></p>
              </li>
              <li>
                <p><i class="fa fa-envelope text-warning"></i>12 new emails<span class="time">25 min</span></p>
              </li>
              <li>
                <p><i class="fa fa-cog icon-spin text-success"></i> Location settings<span class="time">4 hrs</span></p>
              </li>
            </ul>
          </li>
          <li class="list-box user-profile">
            <a id="drop7" href="#" role="button" class="dropdown-toggle user-avtar" data-toggle="dropdown">
              <img src="${pageContext.request.contextPath}/resources/Logistic/assets/img/user5.png" alt="Bluemoon User">
            </a>
            <ul class="dropdown-menu server-activity">
              <li>
                <p><i class="fa fa-cog text-info"></i> Account Settings</p>
              </li>
              <li>
                <p><i class="fa fa-fire text-warning"></i> Payment Details</p>
              </li>
              <li>
                <div class="demo-btn-group clearfix">
                  <a href="#" data-original-title="" title="">
                    <i class="fa fa-facebook fa-lg icon-rounded info-bg"></i>
                  </a>
                  <a href="#" data-original-title="" title="">
                    <i class="fa fa-twitter fa-lg icon-rounded twitter-bg"></i>
                  </a>
                  <a href="#" data-original-title="" title="">
                    <i class="fa fa-linkedin fa-lg icon-rounded linkedin-bg"></i>
                  </a>
                  <a href="#" data-original-title="" title="">
                    <i class="fa fa-pinterest fa-lg icon-rounded danger-bg"></i>
                  </a>
                  <a href="#" data-original-title="" title="">
                    <i class="fa fa-google-plus fa-lg icon-rounded success-bg"></i>
                  </a>
                </div>
              </li>
              <li>
                <div class="demo-btn-group clearfix">
                  <button href="#" class="btn btn-danger">
                    Logout
                  </button>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </header> 
	<!-- Header End -->

	<!-- Main Container start -->
	<div class="dashboard-container">

		<div class="container">
			<!-- Top Nav Start -->
			<tiles:insertAttribute name="menu" />
			<!-- Top Nav End -->
			

			<!-- Dashboard Wrapper Start -->
			<div class="dashboard-wrapper-lg">
				<tiles:insertAttribute name="body" />

			</div>
			<!-- Dashboard Wrapper End -->

			<tiles:insertAttribute name="footer" />

		</div>
	</div>
	<!-- Main Container end -->



	<script type="text/javascript">
		//ScrollUp
		$(function() {
			$.scrollUp({
				scrollName : 'scrollUp', // Element ID
				topDistance : '300', // Distance from top before showing element (px)
				topSpeed : 300, // Speed back to top (ms)
				animation : 'fade', // Fade, slide, none
				animationInSpeed : 400, // Animation in speed (ms)
				animationOutSpeed : 400, // Animation out speed (ms)
				scrollText : 'Top', // Text for element
				activeOverlay : false, // Set CSS color to display scrollUp active point, e.g '#00FFFF'
			});
		});
	</script>

</body>

</html>