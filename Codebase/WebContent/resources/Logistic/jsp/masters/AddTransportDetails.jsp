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
				<li><a >Masters</a> <i class="fa fa-circle"></i></li>
				<li class="active">Add Transport Details</li>
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
										<i class="fa fa-gift"></i>Transport Details
									</div>
									<div class="tools">
										<div class="caption">
										Transport Owner Name : ${TransportOwnerName}
										</div>
									</div>
								</div>

								<!-- CompanyStart -->
								<div class="portlet box green">
									<!-- <div class="portlet-title">
										<div class="caption">
											<i class="fa fa-gift"></i>Form Sample
										</div>
										<div class="tools">
											<a href="javascript:;" class="collapse">
											</a>
											<a href="#portlet-config" data-toggle="modal" class="config">
											</a>
											<a href="javascript:;" class="reload">
											</a>
											<a href="javascript:;" class="remove">
											</a>
										</div>
									</div> -->
									<div class="portlet-body form">
										<!-- BEGIN FORM-->
										<form:form name="addTransportDetailsForm" action="saveTransportDetails.htm"
											modelAttribute="TransportDetailsDto" class="form-horizontal">
											<form:hidden id="ownerId" path="ownId" />
											<form:hidden path="id" />
											<form:hidden path="delFlag" />
											<%-- <form:hidden path="compId" /> --%>
											<div class="form-body">
												<h3 class="form-section"></h3>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Transport
																Type</label>
															<div class="col-md-9">
																<%-- <form:input type="text" path="tranTypeDtlId" class="form-control"
																	placeholder="Transport Type Detail."/> --%>
																<form:select id="tranTypeDtlId" path="transportTypeId"
																	onchange="getAllTransportTypeDetails()"
																	class="form-control">
																	<form:option value="0" label="---Select---" />
																	<form:options class="form-control" itemValue="id"
																		itemLabel="name" items="${lTransportTypeDtos}" />
																</form:select>
															</div>
														</div>
													</div>

													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Transport
																Type Detail</label>
															<div class="col-md-9">
																<%-- <form:input type="text" path="tranTypeDtlId" class="form-control"
																	placeholder="Transport Type Detail."/> --%>
																<form:select id="tranTypeDtlId" path="tranTypeDtlId"
																	class="form-control">
																	<form:option value="0" label="---Select---" />
																	<form:options class="form-control" itemValue="id"
																		itemLabel="truckName" items="${lTransportTypeDtlDtos}" />
																</form:select>
															</div>
														</div>
													</div>

													<!--/span-->
												</div>
												<!--/row-->
												<div class="row">

													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Lowery
																Number</label>
															<div class="col-md-9">
																<form:input type="text" path="loweryNo"
																	class="form-control" placeholder="Lowery Number here.." />
															</div>
														</div>
													</div>

												</div>
												<!--/row-->
												<div class="form-actions right">
														<button class="btn default" type="button" onclick="goBack()">Cancel</button>
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
	var x = document.getElementById("ownerId").value;
	var ownId = document.getElementById('ownerId').value;
	/* alert("" + x + "---" + ownId); */
	 	 document.addTransportDetailsForm.action="getAllTransportDetails.htm?transportTypeId=" + x;
		 document.addTransportDetailsForm.method="GET";
		 document.addTransportDetailsForm.submit();
}

	function getAllTransportTypeDetails() {
		var x = document.getElementById("tranTypeDtlId").value;
		var ownId = document.getElementById('ownerId').value;
		/* alert("" + x + "---" + ownId); */
		 	 document.addTransportDetailsForm.action="getAllTransportTypeDetailList.htm?transportTypeId=" + x + "&ownId=" + ownId;
			 document.addTransportDetailsForm.method="GET";
			 document.addTransportDetailsForm.submit();
	}
</script>

