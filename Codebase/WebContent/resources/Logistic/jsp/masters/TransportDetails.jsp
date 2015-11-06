<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<li><a>Transport Owner/Agent</a> <i class="fa fa-circle"></i></li>
				<li><a>Transport Details</a> <i class="fa fa-circle"></i></li>
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
									Details</span>
							</div>

							<div class="tools">
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
									<div id="addButtondiv">
										<div class="btn-group">
											<a href="showAddTransportDetails.htm?ownId=${ownId}"><button
													class="btn btn-circle btn-primary">Add New</button></a>
										</div></div>
									</div>
									<div class="col-md-4"></div>
									<div class="col-md-4">
										<div class="btn-group pull-right">
											<form:form name="TransportDetailsForm"
												modelAttribute="transportDetailsDto"
												action="getAllTransportDetails.htm">
												<label class="control-label col-md-10">Select
													Transport Owner</label>
												<form:select id="selectTransportOwner" path="ownId" class="form-control"
													onchange="getAllTransportDetails()">
													<form:option value="0" label="---Select---" />
													<form:options class="form-control" itemValue="id"
														itemLabel="name" items="${lTransportOwners}" />
												</form:select>
											</form:form>
										</div>
									</div>
								</div>
							</div>
							<table class="table table-striped table-bordered table-hover"
								id="sample_2">
								<thead>
									<tr>
										<th class="table-checkbox"><input type="checkbox"
											class="group-checkable" data-set="#sample_2 .checkboxes" /></th>
										<th>Lowery Number</th>
										<th>Transport Type</th>
										<th>Lowery Owner</th>
										<th>Edit/Delete</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${lTransportDetails}" var="TransportDetails">
										<tr class="odd gradeX">
											<form:hidden path="ownId" />
											<td><input type="checkbox" class="checkboxes" value="1" />
											</td>
											<td>${TransportDetails.loweryNo}</td>
											<td>${TransportDetails.tranTypeDtlId}</td>
											<td>${TransportDetails.ownId}</td>
											<td><a
												href="editTransportDetails.htm?id=${TransportDetails.id}"
												class="btn btn-warning btn-xs"> Edit </a> <a
												href="deleteTransportDetails.htm?id=${TransportDetails.id}&ownId=${TransportDetails.ownId}"
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
	function getAllTransportDetails() {
		var x = document.getElementById("selectTransportOwner").value;
		/* alert(""+x); */
		document.TransportDetailsForm.action = "getAllTransportDetails.htm?ownId="
				+ x;
		document.TransportDetailsForm.method = "GET";
		document.TransportDetailsForm.submit();
	}
</script>
<script type="text/javascript">
var y = document.getElementById("selectTransportOwner").value;
if(y==0){
	var x = document.getElementById("errorDiv");
	x.innerHTML += "<br /> Please Select Transport Owner First"
	document.getElementById("addButtondiv").style.display = "none";
}
</script>
 