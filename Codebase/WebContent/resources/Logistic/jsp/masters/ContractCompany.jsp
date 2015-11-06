<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="page-container">
	<!-- BEGIN PAGE HEAD -->
	<!-- END PAGE HEAD -->
	<!-- BEGIN PAGE CONTENT -->
	<div class="page-content">
		<div class="container">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div class="modal fade" id="portlet-config" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">Modal title</h4>
						</div>
						<div class="modal-body">Widget settings form goes here</div>
						<div class="modal-footer">
							<button type="button" class="btn blue">Save changes</button>
							<button type="button" class="btn default" data-dismiss="modal">Close</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE BREADCRUMB -->
			<ul class="page-breadcrumb breadcrumb">
				<li><a href="./login.htm">Home</a><i class="fa fa-circle"></i></li>
				<li><a href="#">Contract Company</a> <i class="fa fa-circle"></i></li>
				<li><a href="#">Contract Company Details</a> <i
					class="fa fa-circle"></i></li>
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
									class="caption-subject font-green-sharp bold uppercase">Contract
									Company Details</span>
							</div>
							<div class="tools">
								
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
							<div id="bootstrap_alerts"></div>
							<div class="table-toolbar">
								<div class="row">
									<div class="col-md-6">
										<div class="btn-group">
											<a href="showAddContractCompany.htm"><button
													class="btn btn-circle btn-primary">Add New</button></a>
										</div>
										<div class="btn-group">
											<a href="showAddContractCompany.htm"><button
													class="btn btn-circle btn-primary">delete</button></a>
										</div>
									</div>
									<div class="col-md-6">
										
									</div>
								</div>
							</div>
							<table class="table table-striped table-bordered table-hover"
								id="sample_1">
								<thead>
									<tr>
										<th class="table-checkbox"><input type="checkbox"
											class="group-checkable" data-set="#sample_1 .checkboxes" /></th>
										<th>Name</th>
										<th>Company</th>
										<th>Address</th>
										<th>Type</th>
										<th>Contact Person</th>
										<th>Contact Number 1</th>
										<!-- <th>Contact Number 2</th> -->
										<th>Edit/Delete</th>
										<!-- <th>Routes</th> -->
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${lContractCompanies}" var="contractCompany">
										<tr class="odd gradeX">
											<td><input type="checkbox" class="checkboxes" value="1" />
											</td>
											<td>${contractCompany.name}</td>
											<td>${contractCompany.compId}</td>
											<td>${contractCompany.address}</td>
											<td>${contractCompany.type}</td>
											<td>${contractCompany.contactPersion}</td>
											<td>${contractCompany.contactNo1}</td>
											<%-- <td>${contractCompany.contactNo2}</td> --%>
											<td><a
												href="showEditContractCompany.htm?id=${contractCompany.id}"
												class="btn btn-warning btn-xs"> Edit </a> <a
												href="deleteContractCompany.htm?id=${contractCompany.id}"
												class="btn btn-info btn-xs"> Delete </a></td>
											<%-- 	<td>
											<a href="getAllContractCompRoutes.htm?id=${contractCompany.id}"
													class="btn btn-info btn-xs">create Routes 
												</a>
											</td>	 --%>
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

<script>
	$(window).load(function() {

		Metronic.alert({
			container : '#bootstrap_alerts', // alerts parent container(by default placed after the page breadcrumbs)
			place : 'append', // append or prepent in container 
			type : 'danger', // alert's type
			message : 'Records not found', // alert's message
			close : '1', // make alert closable
			reset : '1', // close all previouse alerts first
			focus : '1', // auto scroll to the alert after shown
			closeInSeconds : '0', // auto close after defined seconds
			icon : "" // put icon before the message
		});
	});
</script>