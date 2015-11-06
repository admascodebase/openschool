<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script src="<c:url value="/resources/main.js" />"></script>
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
				<li><a href="#">Masters</a> <i class="fa fa-circle"></i></li>
				<li><a href="table_managed.html">Transport Type Details</a> <i
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
									class="caption-subject font-green-sharp bold uppercase">Transport
									Type Details</span>
							</div>
							<div class="tools">
								<a href="javascript:;" class="collapse"> </a> <a
									href="#portlet-config" data-toggle="modal" class="config">
								</a> <a href="javascript:;" class="reload"> </a> <a
									href="javascript:;" class="remove"> </a>
							</div>
						</div>

						<c:if test="${errorCode ne null}">
							<div id="errorDiv" class="alert alert-danger">
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
									<div class="col-md-4">
										<div id="addButton">
										<div class="btn-group">
											<a href="showAddTransportTypeDetails.htm?transId=${transId}"><button
													class="btn btn-circle btn-primary">Add New</button></a>
										</div>
										</div>
									</div>
									<div class="col-md-4"></div>
									<div class="col-md-4">
										<form:form name="TransportDetailsForm"
											modelAttribute="transportTypeDtlDto"
											action="getAllTransportDetails.htm">

											<div class="btn-group pull-right">
												<label class="control-label col-md-10">Select
													Transport Type </label>
												<form:select id="selectTransportType" path="transId"
													class="form-control"
													onchange="getAllTransportTypeDetails()">
													<form:option value="0" label="---Select---" />
													<form:options class="form-control" itemValue="id"
														itemLabel="name" items="${lTransports}" />
												</form:select>
											</div>
										</form:form>
									</div>

								</div>
							</div>

							<table class="table table-striped table-bordered table-hover"
								id="sample_1">
								<thead>
									<tr>
										<th class="table-checkbox"><input type="checkbox"
											class="group-checkable" data-set="#sample_1 .checkboxes" /></th>
										<th>Id</th>
										<th>Transport Id</th>
										<th>Truck Name</th>
										<th>Description</th>
										<th>Size</th>
										<th>Unit</th>
										<th>Wheels</th>
										<th>Width</th>
										<th>Capacity</th>
										<th>Max Capacity</th>
										<th>Edit/Delete</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${lTransportTypeDtls}" var="transportTypeDtl">
										<tr class="odd gradeX">
											<form:hidden path="transId" />
											<td><input type="checkbox" class="checkboxes" value="1" />
											</td>
											<td>${transportTypeDtl.id}</td>
											<td>${transportTypeDtl.transId}</td>
											<td>${transportTypeDtl.truckName}</td>
											<td>${transportTypeDtl.description}</td>
											<td>${transportTypeDtl.size}</td>
											<td>${transportTypeDtl.unit}</td>
											<td>${transportTypeDtl.wheelsNo}</td>
											<td>${transportTypeDtl.width}</td>
											<td>${transportTypeDtl.maxCapacity}</td>
											<td>${transportTypeDtl.capacity}</td>
											<td><a
												href="showEditTransportTypeDetails.htm?id=${transportTypeDtl.id}"
												class="btn btn-warning btn-xs"> Edit </a> <a
												href="showDeleteTransportTypeDetails.htm?id=${transportTypeDtl.id}&transId=${transportTypeDtl.transId}"
												class="btn btn-info btn-xs"> Delete </a></td>
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
	function getAllTransportTypeDetails() {
		var x = document.getElementById("selectTransportType").value;
		/* alert(""+x); */
		document.TransportDetailsForm.action = "getAllTransportTypeDetails.htm?transId="
				+ x;
		document.TransportDetailsForm.method = "GET";
		document.TransportDetailsForm.submit();
		document.getElementById(id).style.display = "block";
	}
</script>
</body>?
<!-- END BODY -->

<!-- Mirrored from www.keenthemes.com/preview/metronic/theme/templates/admin3/table_managed.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 19 Aug 2015 18:08:04 GMT -->
</html>