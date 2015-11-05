<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="page-container">
	<!-- BEGIN PAGE HEAD -->
	</div>
	<!-- END PAGE HEAD -->
	<!-- BEGIN PAGE CONTENT -->
	<div class="page-content">
		<div class="container">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- <div class="modal fade" id="portlet-config" tabindex="-1"
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
					/.modal-content
				</div>
				/.modal-dialog
			</div> -->
			<!-- /.modal -->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE BREADCRUMB -->
			<ul class="page-breadcrumb breadcrumb">
				<li><a href="./login.htm">Home</a><i class="fa fa-circle"></i></li>
				<li><a href="#">Contract Company</a> <i class="fa fa-circle"></i></li>
				<li><a href="#"></a>Payment Setting <i class="fa fa-circle"></i></li>
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
									class="caption-subject font-green-sharp bold uppercase">Payment
									Setting</span>
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
						<form:form name="routePaySettingForm"
							modelAttribute="companyRouteDto">
							<div class="portlet-body">
								<div class="table-toolbar">
									<div class="row">
										<div class="col-md-4">
											<div class="btn-group">
												<button class="btn btn-circle btn-primary"
													onclick="showAddRoutePaySetting()">Add New</button>
											</div>
										</div>

										<div class="col-md-4">
											<div class="btn-group pull-right">
												<label class="control-label col-md-10">Select Contract Company</label>
												<form:select id="contractCompSelect" path="compId"
													class="form-control" onchange="getAllCompRoutes()">
													<form:option value="0" label="---Select---" />
													<form:options class="form-control" itemValue="id"
														itemLabel="name" items="${lCompanies}" />
												</form:select>

											</div>
										</div>
										<div class="col-md-4">
											<div class="btn-group pull-right">
												<label class="control-label col-md-10">Select Contract Company Route</label>
												<form:select id="routeSelect" path="id" class="form-control"
													onchange="getAllPaySettings()">
													<form:option value="0" label="---Select---" />
													<form:options class="form-control" itemValue="id"
														itemLabel="routeName" items="${lCompanyRouteDto}" />
												</form:select>

											</div>
										</div>
										<%-- <form:input path="compId"/> --%>
										<form:hidden path="compId" />
										<form:hidden path="id" />

									</div>
								</div>
								<table class="table table-striped table-bordered table-hover"
									id="sample_2">
									<thead>
										<tr>
											<th class="table-checkbox"><input type="checkbox"
												class="group-checkable" data-set="#sample_2 .checkboxes" /></th>
											<th>Id</th>
											<th>Transport Type</th>
											<th>Transport Type Details</th>
											<th>Amount</th>
											<th>Advance</th>
											<th>Balance</th>
											<th>Edit/Delete</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${lRoutePaySettingDto}" var="PaymentSetting">
											<tr class="odd gradeX">

												<td><input type="checkbox" class="checkboxes" value="1" />
												</td>
												<td>${PaymentSetting.id}</td>
												<td>${PaymentSetting.transportTypeId}</td>
												<td>${PaymentSetting.transportTypeDtlId}</td>
												<td>${PaymentSetting.amount}</td>
												<td>${PaymentSetting.advance}</td>
												<td>${PaymentSetting.balance}</td>
												<td><a
													href="editRoutePaySetting.htm?id=${PaymentSetting.id}&contractCompId=${companyRouteDto.compId}"
													class="btn btn-warning btn-xs"> Edit </a> <a
													href="deleteRoutePaySetting.htm?id=${PaymentSetting.id}&contractCompId=${companyRouteDto.compId}&routeId=${companyRouteDto.id}"
													class="btn btn-info btn-xs"> Delete </a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</form:form>
					</div>
					<!-- END EXAMPLE TABLE PORTLET-->
				</div>
			</div>
			<!-- END PAGE CONTENT INNER -->
		</div>
	</div>
	<!-- END PAGE CONTENT -->

<script>
	function getAllPaySettings() {
		var x = document.getElementById("routeSelect").value;
		document.routePaySettingForm.action = "getAllRoutePaySetting.htm?id="
				+ x;
		document.routePaySettingForm.method = "GET";
		document.routePaySettingForm.submit();
	}

	function getAllCompRoutes() {
		var x = document.getElementById("contractCompSelect").value;
		document.routePaySettingForm.action = "getAllCompRoutes.htm?compId="
				+ x;
		document.routePaySettingForm.method = "GET";
		document.routePaySettingForm.submit();
	}

	function showAddRoutePaySetting() {
		var x = document.getElementById("routeSelect").value;
		document.routePaySettingForm.action = "showAddRoutePaySetting.htm?routeId="
				+ x;
		document.routePaySettingForm.method = "GET";
		document.routePaySettingForm.submit();
	}
</script>