
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
				<li><a href="#">Home</a><i class="fa fa-circle"></i></li>
				<li><a href="#">Masters</a> <i class="fa fa-circle"></i></li>
				<li class="active">Add Employee</li>
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
										<i class="fa fa-gift"></i>Employee Details
									</div>
									<div class="tools">
									</div>
								</div>

								<!-- CompanyStart -->
								<div class="portlet box green">
									<div class="portlet-body form">
										<!-- BEGIN FORM-->
										<form:form action="saveEmployee.htm" modelAttribute="employee" class="form-horizontal login-form">
										<form:hidden path="id" />
										<form:hidden path="delFlag" />
										<form:hidden path="compId" />
											<div class="form-body">
												<h3 class="form-section"></h3>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Name</label>
															<div class="col-md-9">
																<form:input path="name" type="text" class="form-control"
																	placeholder="Enter name ..." name="userName" data-required="1"/> 
															</div>
														</div>
													</div>
													<!--/span-->
													
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Contact
																No</label>
															<div class="col-md-9">
																<form:input path="contactNo" type="text" class="form-control"
																	placeholder=" Enter your contact number."/> 
															</div>
														</div>
													</div>
													
													<!--/span-->
												</div>
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Pan Number</label>
															<div class="col-md-9">
																<form:input path="pan" type="text" class="form-control"
																	placeholder="Enter PAN"/> 
															</div>
														</div>
													</div>												
													
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Gender</label>
															<div class="col-md-9">
																<label class="radio-inline">
																<form:radiobutton path="gender" value="M" class="icheck" />
																 Male </label>
																<label class="radio-inline">
																<form:radiobutton path="gender" value="F" class="icheck" /> Female </label>
															</div>
														</div>
													</div>
												</div>
												<!--/row-->
												<div class="row">
												
												
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">System Access</label>
															<div class="col-md-9">
																<label class="radio-inline">
																<form:radiobutton path="isSysAcc" value="Y" class="icheck" />
																 Yes </label>
																<label class="radio-inline">
																<form:radiobutton path="isSysAcc" value="N" class="icheck" /> No </label>
															</div>
														</div>
													</div>
													
												
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Salary Type</label>
															<div class="col-md-9">
															
															<form:select path="salaryType" class="form-control">
															   <form:option value="NONE" label="--- Select ---"/>
															  <form:option value="Daily" label="Daily"/>
															  <form:option value="Hourly" label="Hourly"/>
															  <form:option value="Weekly" label="Weekly"/>
															  <form:option value="Monthly" label="Monthly"/>
															</form:select>
															</div>
														</div>
														
														<div class="form-group">
															<label class="control-label col-md-3">Role</label>
															<div class="col-md-9">
															<form:select path="roleId"
																class="select2me form-control">
																<form:option value="0" label="-- Select -- " />
																<form:options itemValue="id" itemLabel="name"
																	items="${lRoles}" />
															</form:select>
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
															<label class="control-label col-md-3">Salary</label>
															<div class="col-md-9">
																<form:input path="salary" type="text" class="form-control"
																	placeholder="Enter salary ..."/> 
															</div>
														</div>
													</div>
													
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Address</label>
															<div class="col-md-9">
															
															<form:textarea class="form-control" rows="3" path="address"></form:textarea>
															</div>
														</div>
													</div>	
													
												</div>
												
												<!--/row-->
											</div>
											
											<div class="form-actions right">
												<a href="getAllEmployee.htm"><button class="btn default" type="button">Cancel</button></a>
												<button class="btn blue" type="submit"><i class="fa fa-check"></i> Submit</button>
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


