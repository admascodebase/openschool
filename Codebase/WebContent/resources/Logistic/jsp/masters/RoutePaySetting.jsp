<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<!-- <div class="page-toolbar">
				BEGIN THEME PANEL
				<div class="btn-group btn-theme-panel">
					<a href="javascript:;" class="btn dropdown-toggle"
						data-toggle="dropdown"> <i class="icon-settings"></i>
					</a>
					<div
						class="dropdown-menu theme-panel pull-right dropdown-custom hold-on-click">
						<div class="row">
							<div class="col-md-6 col-sm-6 col-xs-12">
								<h3>THEME COLORS</h3>
								<div class="row">
									<div class="col-md-6 col-sm-6 col-xs-12">
										<ul class="theme-colors">
											<li class="theme-color theme-color-default"
												data-theme="default"><span class="theme-color-view"></span>
												<span class="theme-color-name">Default</span></li>
											<li class="theme-color theme-color-blue-hoki"
												data-theme="blue-hoki"><span class="theme-color-view"></span>
												<span class="theme-color-name">Blue Hoki</span></li>
											<li class="theme-color theme-color-blue-steel"
												data-theme="blue-steel"><span class="theme-color-view"></span>
												<span class="theme-color-name">Blue Steel</span></li>
											<li class="theme-color theme-color-yellow-orange"
												data-theme="yellow-orange"><span
												class="theme-color-view"></span> <span
												class="theme-color-name">Orange</span></li>
											<li class="theme-color theme-color-yellow-crusta"
												data-theme="yellow-crusta"><span
												class="theme-color-view"></span> <span
												class="theme-color-name">Yellow Crusta</span></li>
										</ul>
									</div>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<ul class="theme-colors">
											<li class="theme-color theme-color-green-haze"
												data-theme="green-haze"><span class="theme-color-view"></span>
												<span class="theme-color-name">Green Haze</span></li>
											<li class="theme-color theme-color-red-sunglo"
												data-theme="red-sunglo"><span class="theme-color-view"></span>
												<span class="theme-color-name">Red Sunglo</span></li>
											<li class="theme-color theme-color-red-intense"
												data-theme="red-intense"><span class="theme-color-view"></span>
												<span class="theme-color-name">Red Intense</span></li>
											<li class="theme-color theme-color-purple-plum"
												data-theme="purple-plum"><span class="theme-color-view"></span>
												<span class="theme-color-name">Purple Plum</span></li>
											<li class="theme-color theme-color-purple-studio"
												data-theme="purple-studio"><span
												class="theme-color-view"></span> <span
												class="theme-color-name">Purple Studio</span></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-12 seperator">
								<h3>LAYOUT</h3>
								<ul class="theme-settings">
									<li>Theme Style <select
										class="theme-setting theme-setting-style form-control input-sm input-small input-inline tooltips"
										data-original-title="Change theme style" data-container="body"
										data-placement="left">
											<option value="boxed" selected="selected">Square
												corners</option>
											<option value="rounded">Rounded corners</option>
									</select>
									</li>
									<li>Layout <select
										class="theme-setting theme-setting-layout form-control input-sm input-small input-inline tooltips"
										data-original-title="Change layout type" data-container="body"
										data-placement="left">
											<option value="boxed" selected="selected">Boxed</option>
											<option value="fluid">Fluid</option>
									</select>
									</li>
									<li>Top Menu Style <select
										class="theme-setting theme-setting-top-menu-style form-control input-sm input-small input-inline tooltips"
										data-original-title="Change top menu dropdowns style"
										data-container="body" data-placement="left">
											<option value="dark" selected="selected">Dark</option>
											<option value="light">Light</option>
									</select>
									</li>
									<li>Top Menu Mode <select
										class="theme-setting theme-setting-top-menu-mode form-control input-sm input-small input-inline tooltips"
										data-original-title="Enable fixed(sticky) top menu"
										data-container="body" data-placement="left">
											<option value="fixed">Fixed</option>
											<option value="not-fixed" selected="selected">Not
												Fixed</option>
									</select>
									</li>
									<li>Mega Menu Style <select
										class="theme-setting theme-setting-mega-menu-style form-control input-sm input-small input-inline tooltips"
										data-original-title="Change mega menu dropdowns style"
										data-container="body" data-placement="left">
											<option value="dark" selected="selected">Dark</option>
											<option value="light">Light</option>
									</select>
									</li>
									<li>Mega Menu Mode <select
										class="theme-setting theme-setting-mega-menu-mode form-control input-sm input-small input-inline tooltips"
										data-original-title="Enable fixed(sticky) mega menu"
										data-container="body" data-placement="left">
											<option value="fixed" selected="selected">Fixed</option>
											<option value="not-fixed">Not Fixed</option>
									</select>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				END THEME PANEL
			</div> -->
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
				<li><a href="#">Home</a><i class="fa fa-circle"></i></li>
				<li><a href="table_managed.html">Masters</a> <i
					class="fa fa-circle"></i></li>
				<li><a href="table_managed.html"></a> <i class="fa fa-circle"></i></li>
				<li class="active">Payment Setting</li>
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
						<form:form name="routePaySettingForm"
							modelAttribute="companyRouteDto">
							<div class="portlet-body">
								<div class="table-toolbar">
									<div class="row">
										<div class="col-md-6">
											<div class="btn-group">
												<button class="btn btn-circle btn-primary"
													onclick="showAddRoutePaySetting()">Add New</button>
											</div>
										</div>

										<div class="col-md-6">
											<div class="btn-group pull-right">
												<form:select id="contractCompSelect" path="compId"
													class="form-control" onchange="getAllCompRoutes()">
													<form:option value="0" label="---Select---" />
													<form:options class="form-control" itemValue="id"
														itemLabel="name" items="${lCompanies}" />
												</form:select>

											</div>
										</div>
										<div class="col-md-6">
											<div class="btn-group pull-right">
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
													href="deleteRoutePaySetting.htm?id=${PaymentSetting.id}"
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
</div>

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