<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="page-container">
	<!-- BEGIN PAGE HEAD -->
	<!-- END PAGE HEAD -->
	<!-- BEGIN PAGE CONTENT -->
	<div class="page-content">
		<div class="container">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
		<!-- 	<div class="modal fade" id="portlet-config" tabindex="-1"
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
			</div>
		 -->	<!-- /.modal -->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE BREADCRUMB -->
			<ul class="page-breadcrumb breadcrumb">
				<li><a href="./login.htm">Home</a><i class="fa fa-circle"></i></li>
				<li><a href="./getAllContractCompany.htm">Contract Company</a> <i class="fa fa-circle"></i></li>
				<li class="">Add Load Entry</li>
			</ul>
			<!-- END PAGE BREADCRUMB -->
			<!-- BEGIN PAGE CONTENT INNER -->
			<div class="row">
				<div class="col-md-12">
					<div
						class="tabbable tabbable-custom tabbable-noborder tabbable-reversed">
						<div class="tab-pane" id="tab_2">
							<div class="portlet box green">
								<div class="portlet-title">
									<div class="caption">
										<i class="fa fa-gift"></i>Load Entry : 
									</div>
									<div class="tools">
									<div class="caption">
										Company Name : ${contractCompanyName}
										</div>
									</div>
								</div>

								<!-- CompanyStart -->
								<div class="portlet box green">
									<div class="portlet-body form">
										<!-- BEGIN FORM-->
										<form:form name="AddLoadEntryForm" action="saveLoadEntry.htm" modelAttribute="LoadEntry" class="form-horizontal">
										<form:hidden path="id" />
										<form:hidden path="delFlag" />
										<form:hidden path="compId" id="ContractcompId"/>
											<div class="form-body">
												<h3 class="form-section"></h3>
												
												
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Transport Type</label>
															<div class="col-md-9">
																<%-- <form:input type="text" path="endCityId" class="form-control"/> --%>
																<form:select id="TransportTypeSelect" path="transportTypeId"
															class="form-control"
															onchange="getAllTransportTypeDetails()">
															<form:option value="0" label="---Select---" />
															<form:options class="form-control" itemValue="id"
																itemLabel="name" items="${lTransports}" />
														</form:select> 
															</div>
														</div>
													</div>
													
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Transport Type Details</label>
															<div class="col-md-9">
																<%-- <form:input type="text" path="endCityId" class="form-control"/> --%>
																<form:select id="tranTypeDtlId" path="transportTypeDtlDto.id"
																	class="form-control">
																	<form:option value="0" label="---Select---" />
																	<form:options class="form-control" itemValue="id"
																		itemLabel="truckName" items="${lTransportTypeDtls}" />
																</form:select>
															</div>
														</div>
													</div>
													
												</div>
												
												
												
												<div class="row">
													<%-- <div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Comp id</label>
															<div class="col-md-9">
																<form:input type="text" path="compId" class="form-control"
																	placeholder="Route Type Detail."/> 
															</div>
														</div>
													</div> --%>
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Route</label>
															<div class="col-md-9">
																	<form:select id="routeSelect" path="id" class="form-control"
													onchange="getAllTransportTypes()">
													<form:option value="0" label="---Select---" />
													<form:options class="form-control" itemValue="id"
														itemLabel="routeName" items="${lCompanyRouteDtos}" />
												</form:select> 
															</div>
														</div>
													</div>
													<!--/span-->
													<!--/span-->
												</div>
												<!--/row-->
												
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Loading Date</label>
															<div class="col-md-9">
																<form:input type="text" path="loadingDate" class="form-control"/>
																 
															</div>
														</div>
													</div>
													
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Unloading Date</label>
															<div class="col-md-9">
																<form:input type="text" path="unloadingDate" class="form-control"/>
															</div>
														</div>
													</div>
													
												</div>
												
												
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Amount</label>
															<div class="col-md-9">
																<form:input type="text" path="amount" class="form-control"/>
															</div>
														</div>
													</div>
													
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Advance</label>
															<div class="col-md-9">
																<form:input type="text" path="advance" class="form-control"/>
															</div>
														</div>
													</div>
												</div>
												
												
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Balance</label>
															<div class="col-md-9">
																<form:input type="text" path="balance" class="form-control"/>
															</div>
														</div>
													</div>
												</div>
												
												<!--/row-->
											<div class="form-actions right">
												<button class="btn default" type="button" onclick="goBack()">Cancel</button>
												<button class="btn blue" type="submit"><i class="fa fa-check"></i> Submit</button>
											</div>
											</div>
										</form:form>
										<!-- END FORM-->
									</div>
								</div>
								<!--companyEnd  -->
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- END PAGE CONTENT INNER -->
		</div>
	</div>
	<!-- END PAGE CONTENT -->
</div>

<script>

	function goBack() {
		var companyId = document.getElementById("ContractcompId").value;
		document.AddLoadEntryForm.action = "getAllLoadEntry.htm?compId="+companyId;
		document.AddLoadEntryForm.method = "GET";
		document.AddLoadEntryForm.submit();
	}

	function getAllTransportTypeDetails() {
		var x = document.getElementById("TransportTypeSelect").value;
		var companyId = document.getElementById("ContractcompId").value;
		document.AddLoadEntryForm.action = "getAllTransportTypeDetailListForLoad.htm?transportTypeId="+ x+"&compId="+companyId;
		document.AddLoadEntryForm.method = "GET";
		document.AddLoadEntryForm.submit();
	}
</script>
