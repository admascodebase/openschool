<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.5
Version: 4.1.0
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->

<!-- Mirrored from www.keenthemes.com/preview/metronic/theme/templates/admin3/table_managed.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Aug 2015 18:08:03 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
<head>
<meta charset="utf-8"/>
<title>Metronic | Managed Datatables</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&amp;subset=all" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN PAGE LEVEL PLUGIN STYLES DSHBORD-->
<link href="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/morris/morris.css" rel="stylesheet" type="text/css">
<!-- END PAGE LEVEL PLUGIN STYLES DSHBORD-->

<!-- BEGIN PAGE LEVEL STYLES FOR DATA-TABLE -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>
<!-- END PAGE LEVEL STYLES FOR DATA-TABLE -->
<link href="${pageContext.request.contextPath}/resources/Logistic/assets/admin/pages/css/tasks.css" rel="stylesheet" type="text/css"/>
<!-- BEGIN THEME STYLES -->

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css"/>

<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jquery-validation/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jquery-validation/js/additional-methods.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/bootstrap-wysihtml5/wysihtml5-0.3.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/bootstrap-markdown/lib/markdown.js"></script>
<!-- END PAGE LEVEL PLUGINS -->

<link href="${pageContext.request.contextPath}/resources/Logistic/assets/global/css/components-rounded.css" id="style_components" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/Logistic/assets/global/css/plugins.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/Logistic/assets/admin/layout3/css/layout.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/Logistic/assets/admin/layout3/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color">
<link href="${pageContext.request.contextPath}/resources/Logistic/assets/admin/layout3/css/custom.css" rel="stylesheet" type="text/css">

<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<!-- DOC: Apply "page-header-menu-fixed" class to set the mega menu fixed  -->
<!-- DOC: Apply "page-header-top-fixed" class to set the top menu fixed  -->
<body>
<!-- BEGIN HEADER -->
<div class="page-header">
	<!-- BEGIN HEADER TOP -->
	<div class="page-header-top">
		<div class="container">
			<!-- BEGIN LOGO -->
			<div class="page-logo">
				<a href="index-2.html"><img src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/layout3/img/logo-default.png" alt="logo" class="logo-default"></a>
			</div>
			<!-- END LOGO -->
			<!-- BEGIN RESPONSIVE MENU TOGGLER -->
			<a href="javascript:;" class="menu-toggler"></a>
			<!-- END RESPONSIVE MENU TOGGLER -->
			<!-- BEGIN TOP NAVIGATION MENU -->
			<div class="top-menu">
				<ul class="nav navbar-nav pull-right">
					<!-- BEGIN NOTIFICATION DROPDOWN -->
					<li class="dropdown dropdown-extended dropdown-dark dropdown-notification" id="header_notification_bar">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<i class="icon-bell"></i>
						<span class="badge badge-default">7</span>
						</a>
						<ul class="dropdown-menu">
							<li class="external">
								<h3>You have <strong>12 pending</strong> tasks</h3>
								<a href="javascript:;">view all</a>
							</li>
							<li>
								<ul class="dropdown-menu-list scroller" style="height: 250px;" data-handle-color="#637283">
									<li>
										<a href="javascript:;">
										<span class="time">just now</span>
										<span class="details">
										<span class="label label-sm label-icon label-success">
										<i class="fa fa-plus"></i>
										</span>
										New user registered. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">3 mins</span>
										<span class="details">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
										Server #12 overloaded. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">10 mins</span>
										<span class="details">
										<span class="label label-sm label-icon label-warning">
										<i class="fa fa-bell-o"></i>
										</span>
										Server #2 not responding. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">14 hrs</span>
										<span class="details">
										<span class="label label-sm label-icon label-info">
										<i class="fa fa-bullhorn"></i>
										</span>
										Application error. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">2 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
										Database overloaded 68%. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">3 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
										A user IP blocked. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">4 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-warning">
										<i class="fa fa-bell-o"></i>
										</span>
										Storage Server #4 not responding dfdfdfd. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">5 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-info">
										<i class="fa fa-bullhorn"></i>
										</span>
										System Error. </span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="time">9 days</span>
										<span class="details">
										<span class="label label-sm label-icon label-danger">
										<i class="fa fa-bolt"></i>
										</span>
										Storage server failed. </span>
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>
					<!-- END NOTIFICATION DROPDOWN -->
					<!-- BEGIN TODO DROPDOWN -->
					<li class="dropdown dropdown-extended dropdown-dark dropdown-tasks" id="header_task_bar">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<i class="icon-calendar"></i>
						<span class="badge badge-default">3</span>
						</a>
						<ul class="dropdown-menu extended tasks">
							<li class="external">
								<h3>You have <strong>12 pending</strong> tasks</h3>
								<a href="javascript:;">view all</a>
							</li>
							<li>
								<ul class="dropdown-menu-list scroller" style="height: 275px;" data-handle-color="#637283">
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">New release v1.2 </span>
										<span class="percent">30%</span>
										</span>
										<span class="progress">
										<span style="width: 40%;" class="progress-bar progress-bar-success" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">40% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">Application deployment</span>
										<span class="percent">65%</span>
										</span>
										<span class="progress">
										<span style="width: 65%;" class="progress-bar progress-bar-danger" aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">65% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">Mobile app release</span>
										<span class="percent">98%</span>
										</span>
										<span class="progress">
										<span style="width: 98%;" class="progress-bar progress-bar-success" aria-valuenow="98" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">98% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">Database migration</span>
										<span class="percent">10%</span>
										</span>
										<span class="progress">
										<span style="width: 10%;" class="progress-bar progress-bar-warning" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">10% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">Web server upgrade</span>
										<span class="percent">58%</span>
										</span>
										<span class="progress">
										<span style="width: 58%;" class="progress-bar progress-bar-info" aria-valuenow="58" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">58% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">Mobile development</span>
										<span class="percent">85%</span>
										</span>
										<span class="progress">
										<span style="width: 85%;" class="progress-bar progress-bar-success" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">85% Complete</span></span>
										</span>
										</a>
									</li>
									<li>
										<a href="javascript:;">
										<span class="task">
										<span class="desc">New UI release</span>
										<span class="percent">38%</span>
										</span>
										<span class="progress progress-striped">
										<span style="width: 38%;" class="progress-bar progress-bar-important" aria-valuenow="18" aria-valuemin="0" aria-valuemax="100"><span class="sr-only">38% Complete</span></span>
										</span>
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>
					<!-- END TODO DROPDOWN -->
					<li class="droddown dropdown-separator">
						<span class="separator"></span>
					</li>
					<!-- BEGIN INBOX DROPDOWN -->
					<li class="dropdown dropdown-extended dropdown-dark dropdown-inbox" id="header_inbox_bar">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<span class="circle">3</span>
						<span class="corner"></span>
						</a>
						<ul class="dropdown-menu">
							<li class="external">
								<h3>You have <strong>7 New</strong> Messages</h3>
								<a href="javascript:;">view all</a>
							</li>
							<li>
								<ul class="dropdown-menu-list scroller" style="height: 275px;" data-handle-color="#637283">
									<li>
										<a href="inbox14c8.html?a=view">
										<span class="photo">
										<img src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/layout3/img/avatar2.jpg" class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Lisa Wong </span>
										<span class="time">Just Now </span>
										</span>
										<span class="message">
										Vivamus sed auctor nibh congue nibh. auctor nibh auctor nibh... </span>
										</a>
									</li>
									<li>
										<a href="inbox14c8.html?a=view">
										<span class="photo">
										<img src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/layout3/img/avatar3.jpg" class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Richard Doe </span>
										<span class="time">16 mins </span>
										</span>
										<span class="message">
										Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>
										</a>
									</li>
									<li>
										<a href="inbox14c8.html?a=view">
										<span class="photo">
										<img src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/layout3/img/avatar1.jpg" class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Bob Nilson </span>
										<span class="time">2 hrs </span>
										</span>
										<span class="message">
										Vivamus sed nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>
										</a>
									</li>
									<li>
										<a href="inbox14c8.html?a=view">
										<span class="photo">
										<img src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/layout3/img/avatar2.jpg" class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Lisa Wong </span>
										<span class="time">40 mins </span>
										</span>
										<span class="message">
										Vivamus sed auctor 40% nibh congue nibh... </span>
										</a>
									</li>
									<li>
										<a href="inbox14c8.html?a=view">
										<span class="photo">
										<img src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/layout3/img/avatar3.jpg" class="img-circle" alt="">
										</span>
										<span class="subject">
										<span class="from">
										Richard Doe </span>
										<span class="time">46 mins </span>
										</span>
										<span class="message">
										Vivamus sed congue nibh auctor nibh congue nibh. auctor nibh auctor nibh... </span>
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>
					<!-- END INBOX DROPDOWN -->
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<li class="dropdown dropdown-user dropdown-dark">
						<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
						<img alt="" class="img-circle" src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/layout3/img/avatar9.jpg">
						<span class="username username-hide-mobile">Nick</span>
						</a>
						<ul class="dropdown-menu dropdown-menu-default">
							<li>
								<a href="extra_profile.html">
								<i class="icon-user"></i> My Profile </a>
							</li>
							<li>
								<a href="page_calendar.html">
								<i class="icon-calendar"></i> My Calendar </a>
							</li>
							<li>
								<a href="inbox.html">
								<i class="icon-envelope-open"></i> My Inbox <span class="badge badge-danger">
								3 </span>
								</a>
							</li>
							<li>
								<a href="javascript:;">
								<i class="icon-rocket"></i> My Tasks <span class="badge badge-success">
								7 </span>
								</a>
							</li>
							<li class="divider">
							</li>
							<li>
								<a href="extra_lock.html">
								<i class="icon-lock"></i> Lock Screen </a>
							</li>
							<li>
								<a href="login.html">
								<i class="icon-key"></i> Log Out </a>
							</li>
						</ul>
					</li>
					<!-- END USER LOGIN DROPDOWN -->
				</ul>
			</div>
			<!-- END TOP NAVIGATION MENU -->
		</div>
	</div>
	<!-- END HEADER TOP -->
	<!-- BEGIN HEADER MENU -->
	<div class="page-header-menu">
		<div class="container">
			<!-- BEGIN HEADER SEARCH BOX -->
			<form class="search-form" action="http://www.keenthemes.com/preview/metronic/theme/templates/admin3/extra_search.html" method="GET">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search" name="query">
					<span class="input-group-btn">
					<a href="javascript:;" class="btn submit"><i class="icon-magnifier"></i></a>
					</span>
				</div>
			</form>
			<!-- END HEADER SEARCH BOX -->
			<!-- BEGIN MEGA MENU -->
			<!-- DOC: Apply "hor-menu-light" class after the "hor-menu" class below to have a horizontal menu with white background -->
			<!-- DOC: Remove data-hover="dropdown" and data-close-others="true" attributes below to disable the dropdown opening on mouse hover -->
			<div class="hor-menu ">
				
				<tiles:insertAttribute name="menu" />
				
			</div>
			<!-- END MEGA MENU -->
		</div>
	</div>
	<!-- END HEADER MENU -->
</div>
<!-- END HEADER -->

<!-- BEGIN PAGE CONTAINER -->

	<tiles:insertAttribute name="body" />

<!-- END PAGE CONTAINER -->
<!-- BEGIN PRE-FOOTER -->
<tiles:insertAttribute name="footer" />
<!-- END FOOTER -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/respond.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jqvmap/jqvmap/jquery.vmap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.russia.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.world.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.europe.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.germany.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jqvmap/jqvmap/maps/jquery.vmap.usa.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jqvmap/jqvmap/data/jquery.vmap.sampledata.js" type="text/javascript"></script>
<!-- IMPORTANT! fullcalendar depends on jquery-ui.min.js for drag & drop support -->

<!-- IMPORTANT! fullcalendar depends on jquery-ui.min.js for drag & drop support -->
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/morris/morris.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/morris/raphael-min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
<!-- END PAGE LEVEL PLUGINS -->


<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/layout3/scripts/layout.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/layout2/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/layout3/scripts/demo.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/pages/scripts/table-managed.js"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/pages/scripts/index3.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/pages/scripts/tasks.js" type="text/javascript"></script>

<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/layout3/scripts/layout.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/layout3/scripts/demo.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/pages/scripts/form-samples.js"></script>
<script src="${pageContext.request.contextPath}/resources/Logistic/assets/admin/pages/scripts/form-validation.js"></script>

<!-- END PAGE LEVEL SCRIPTS -->
<script>
jQuery(document).ready(function() {       
 Metronic.init(); // init metronic core components
Layout.init(); // init current layout
 TableManaged.init();
 QuickSidebar.init(); // init quick sidebar
   Index.init(); // init index page
   Tasks.initDashboardWidget(); // init tash dashboard widget
   FormSamples.init();
   FormValidation.init();
  
});
</script>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','../../../../../../www.google-analytics.com/analytics.js','ga');
  ga('create', 'UA-37564768-1', 'keenthemes.com');
  ga('send', 'pageview');
</script>
</body>

<!-- END BODY -->

<!-- Mirrored from www.keenthemes.com/preview/metronic/theme/templates/admin3/table_managed.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Aug 2015 18:08:04 GMT -->
</html>