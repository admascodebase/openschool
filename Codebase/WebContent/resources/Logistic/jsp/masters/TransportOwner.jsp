
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="page-container">
	<!-- BEGIN PAGE HEAD -->
	<div class="page-head">
		<div class="container">
			<!-- BEGIN PAGE TITLE -->
			<div class="page-title">
				<h1>
					Master Details <small>Master Data</small>
				</h1>
			</div>
			<!-- END PAGE TITLE -->
			<!-- BEGIN PAGE TOOLBAR -->
			
			<!-- END PAGE TOOLBAR -->
		</div>
	</div>
	<!-- END PAGE HEAD -->
	<!-- BEGIN PAGE CONTENT -->
	<div class="page-content">
		<div class="container">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div class="modal fade" id="portlet-config" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE BREADCRUMB -->
			<ul class="page-breadcrumb breadcrumb">
				<li><a href="#">Home</a><i class="fa fa-circle"></i></li>
				<li><a href="table_managed.html">Masters</a> <i
					class="fa fa-circle"></i></li>
				<li><a href="table_managed.html">Transport Owner Details</a> <i
					class="fa fa-circle"></i></li>
				<li class="active">Transport Owner Details</li>
			</ul>

			<!-- END PAGE BREADCRUMB -->
			<!-- BEGIN PAGE CONTENT INNER -->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet light">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs font-green-sharp"></i> <span
									class="caption-subject font-green-sharp bold uppercase">Transport Owner 
									Details</span>
							</div>

							<div class="tools">
								<a href="javascript:;" class="collapse"> </a> <a
									href="#portlet-config" data-toggle="modal" class="config">
								</a> <a href="javascript:;" class="reload"> </a> <a
									href="javascript:;" class="remove"> </a>
							</div>
						</div>
						<c:if test="${errorCode ne null}">
							<div class="alert alert-danger">
								<button class="close" data-close="alert"></button>
								<span><spring:message code="${errorCode}"></spring:message>
								</span>
							</div>
						</c:if>

						<c:if test="${sucessMessage ne null}">
							<div class="alert alert-success">
								<button class="close" data-close="alert"></button>
								<spring:message code="${sucessMessage}"></spring:message>
							</div>
						</c:if>

						<div class="portlet-body">
							<div class="table-toolbar">
								<div class="row">
									<div class="col-md-6">
										<div class="btn-group">
											<a href="showAddTransportOwner.htm"><button
													class="btn btn-circle btn-primary">Add New</button></a>
										</div>
									</div>
									<div class="col-md-6">
										<!-- <div class="btn-group pull-right">
											<button class="btn dropdown-toggle" data-toggle="dropdown">
												Tools <i class="fa fa-angle-down"></i>
											</button>
											<ul class="dropdown-menu pull-right">
												<li><a href="javascript:;"> Print </a></li>
												<li><a href="javascript:;"> Save as PDF </a></li>
												<li><a href="javascript:;"> Export to Excel </a></li>
											</ul>
										</div> -->
									</div>
								</div>
							</div>
							<table class="table table-striped table-bordered table-hover"
								id="sample_2">
								<thead>
									<tr>
										<th class="table-checkbox"><input type="checkbox"
											class="group-checkable" data-set="sample_2 .checkboxes" /></th>
										<th>Name</th>
										<th>Address</th>
										<th>Contact Number</th>
										<th>Contact Person</th>
										<th>Email</th>
										<th>Edit/Delete</th>
										<th>Transport Details</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${lTransportOwners}" var="transportOwner">
										<tr class="odd gradeX">

											<td><input type="checkbox" class="checkboxes" value="1" />
											</td>
											<td>${transportOwner.name}</td>
											<td>${transportOwner.address}</td>
											<td>${transportOwner.contactNo}</td>
											<td>${transportOwner.contactPersion}</td>
											<td>${transportOwner.emailId}</td>
											<td><a href="editTransportOwner.htm?id=${transportOwner.id}"
												class="btn btn-warning btn-xs"> Edit </a> <a
												href="deleteTransportOwner.htm?id=${transportOwner.id}"
												class="btn btn-info btn-xs"> Delete </a></td>
											<td>
											<a href="getAllTransportDetails.htm?id=${transportOwner.id}"> Trnsport Details 
												</a> 
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<!-- END EXAMPLE TABLE PORTLET-->
				</div>
			</div>


			<!-- END PAGE CONTENT INNER -->
		</div>
	</div>
	<!-- END PAGE CONTENT -->
</div>
<script>
	jQuery(document).ready(function() {
		Metronic.init(); // init metronic core components
		Layout.init(); // init current layout
		Demo.init(); // init demo features
		TableManaged.init();
	});
</script>
<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script',
			'../../../../../../www.google-analytics.com/analytics.js', 'ga');
	ga('create', 'UA-37564768-1', 'keenthemes.com');
	ga('send', 'pageview');
</script>
</body>
<!-- END BODY -->
<!-- Mirrored from www.keenthemes.com/preview/metronic/theme/templates/admin3/table_managed.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Aug 2015 18:08:04 GMT -->
</html>