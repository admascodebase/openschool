<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="page-container">
	<!-- BEGIN PAGE HEAD -->
	<!-- END PAGE HEAD -->
	<!-- BEGIN PAGE CONTENT -->
	<div class="page-content">
		<div class="container">
			<!-- /.modal -->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE BREADCRUMB -->
			<ul class="page-breadcrumb breadcrumb">
				<li><a href="./login.htm">Home</a><i class="fa fa-circle"></i></li>
				<li><a href="./getAllContractCompany.htm">Contract Company</a>
					<i class="fa fa-circle"></i></li>
				<li class="">Add Company Load To Trans Entry</li>
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
										<i class="fa fa-gift"></i>Company Load To Trans Entry :
									</div>
									<div class="tools">
										<div class="caption">
											<%-- Company Name : ${contractCompanyName} --%>
										</div>
									</div>
								</div>

								<!-- CompanyStart -->
								<div class="portlet box green">
									<div class="portlet-body form">
										<!-- BEGIN FORM-->
										<form:form name="AddCompanyLoadToTranForm"
											action="saveCompLoadToTrans.htm"
											modelAttribute="companyLoadToTransDto"
											class="form-horizontal">
											<form:hidden path="id" />
											<form:hidden path="delFlag" />
											<form:hidden path="companyLoadDetail.id"
												id="CompanyLoadDtlId" />
											<form:hidden path="createdBy" />
											<form:hidden path="updatedBy" />
											<%-- <form:hidden path="createdOn"/>
										<form:hidden path="updatedOn"/> --%>
											<form:hidden path="status" />

											<div class="form-body">
												<h3 class="form-section"></h3>

												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Transport
																Owner </label>
															<div class="col-md-9">
																<%-- <form:input type="text" path="endCityId" class="form-control"/> --%>
																<form:select id="TransportOwnerSelect"
																	path="transortOwnerId" onchange="getAllOwnerTransportDetails()" class="form-control">
																	<form:option value="0" label="---Select---" />
																	<form:options class="form-control" itemValue="id"
																		itemLabel="name" items="${lLoweryOwnerDto}" />
																</form:select>
															</div>
														</div>
													</div>

													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Owner
																Transport Details</label>
															<div class="col-md-9">
																<form:select id="OwnerTransportDtlSelect"
																	path="TransportDtlId" class="form-control">
																	<form:option value="0" label="---Select---" />
																	<form:options class="form-control" itemValue="id"
																		itemLabel="loweryNo" items="${lTransportDetailsDto}" />
																</form:select>
															</div>
														</div>
													</div>


												</div>

												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Assigned
																Date</label>
															<div class="col-md-9">
																<form:input type="text" path="assignDate"
																	class="form-control" />
															</div>
														</div>
													</div>

												</div>

												<!--/row-->
												<div class="form-actions right">
													<button class="btn default" type="button"
														onclick="goBack()">Cancel</button>
													<button class="btn blue" type="submit">
														<i class="fa fa-check"></i> Submit
													</button>
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
		var companyId = document.getElementById("ContractcompanyId").value;
		document.AddCompanyLoadToTranForm.action = ".htm?compId="+companyId;
		document.AddCompanyLoadToTranForm.method = "GET";
		document.AddCompanyLoadToTranForm.submit();
	}

	function getAllOwnerTransportDetails() {
		var TransportOwnerSelectId = document.getElementById("TransportOwnerSelect").value;
		 alert("tansport owner id="+TransportOwnerSelectId);
		document.AddCompanyLoadToTranForm.action = "getAllOwnerTransports.htm?transortOwnerId="+TransportOwnerSelectId;
		document.AddCompanyLoadToTranForm.method = "GET";
		document.AddCompanyLoadToTranForm.submit();
	}
	
</script>
