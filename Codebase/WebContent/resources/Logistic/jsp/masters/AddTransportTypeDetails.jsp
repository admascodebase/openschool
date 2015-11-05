<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<li><a >Masters</a> <i class="fa fa-circle"></i></li>
				<li class="active">Add Transport Type Details</li>
			</ul>
			<!-- END PAGE BREADCRUMB -->
			<!-- BEGIN PAGE CONTENT INNER -->
			<div id="errorMessage" class="alert alert-danger"></div>
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

			<div class="row">
				<div class="col-md-12">
					<div
						class="tabbable tabbable-custom tabbable-noborder tabbable-reversed">
						<div class="tab-pane" id="tab_2">
							<div class="portlet box green">
								<div class="portlet-title">
									<div class="caption">
										<i class="fa fa-gift"></i>Transport Type Details
									</div>
									<div class="tools">
										<div class="caption">
										Transport Type : ${transportTypeName}
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
										<form:form name="addTransportTypeDetailsForm" onsubmit="return validateForm()" action="saveTransportTypeDetails.htm" modelAttribute="transportTypeDetails" class="form-horizontal">
											<form:hidden id="transportTypeId" path="transId"/>
											<form:hidden path="id"/>
											<div class="form-body">
												<h3 class="form-section"></h3>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Truck
																Name</label>
															<div class="col-md-9">
																<form:input id="truckNameId" type="text" path="truckName" class="form-control"
																	placeholder="Company Name here.."/> 
															</div>
														</div>
													</div>
													<!--/span-->
													<%-- <div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Transaction</label>
															<div class="col-md-9">
																<form:input type="text" path="transId" class="form-control"
																	placeholder="Address here.. "/> 
															</div>
														</div>
													</div> --%>
													
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Description
																</label>
															<div class="col-md-9">
																<form:input type="text" path="description" class="form-control"
																	placeholder="Transport Type Description."/> 
															</div>
														</div>
													</div>
													<!--/span-->
												</div>
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Unit</label>
															 <div class="col-md-9">
																<form:input id="unitId" path="unit" type="text" class="form-control" placeholder="Enter unit id 1."/>
															</div>
															<%-- <form:select id="unitId" path="unit" class="form-control">
																<form:option value="0" label="---Select---" />
																<form:options class="form-control" itemValue="id"
																	itemLabel="name" items="${lUnits}" />
															</form:select> --%>
														</div>
													</div>
													
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Size</label>
															<div class="col-md-9">
																<form:input id="sizeId" path="size" type="text" class="form-control"
																	placeholder="Enter your contact number."/>
															</div>
														</div>
													</div>
													<!--/span-->
												</div>
												<!--/row-->
												<div class="row">
												<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">width</label>
															<div class="col-md-9">
																<form:input id="widthId" path="width" type="text" class="form-control" placeholder="PAN Number"/>
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">wheels</label>
															<div class="col-md-9">
															<form:input path="wheelsNo" id="wheelsId" type="text" class="form-control" placeholder="Enter Number Of Wheels"/>
															</div>
														</div>
													</div>
													<!--/span-->
												</div>
												<!-- <h3 class="form-section">PAN Number</h3> -->
												<!--/row-->
												<div class="row">
													
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Max Capacity</label>
															<div class="col-md-9">
																<form:input path="maxCapacity" id="maxCapacityId" type="text" class="form-control" placeholder="Max Capacity"/>
															</div>
														</div>
													</div>
												
												
													<div class="col-md-6">
													<div class="form-group">
														<label class="control-label col-md-3">Capacity</label>
														<div class="col-md-9">
															<form:input path="capacity" data-required="1"
																id="capacityId" type="text" class="form-control"
																placeholder="capacity" />
														</div>
													</div>
												</div>
													
												</div>
												<!--/row-->
											</div>
											<div class="form-actions right">
												<button class="btn default" type="button" onclick="goBack()">Cancel</button>
												<button class="btn blue" type="submit">
													<i class="fa fa-check"></i> Save
												</button>
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
