<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="page-container">
	<!-- BEGIN PAGE HEAD -->
	<div class="page-head">
		<div class="container">
			<!-- BEGIN PAGE TITLE -->
			<div class="page-title">
				<h1>
					Master Data <small>Master Data</small>
				</h1>
			</div>
			<!-- END PAGE TITLE -->
			<!-- BEGIN PAGE TOOLBAR -->
			
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
				<li><a href="#">Masters</a> <i class="fa fa-circle"></i></li>
				<li class="active">Add Contract Company</li>
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
										<i class="fa fa-gift"></i>Contract Company Details
									</div>
									<div class="tools">
										<a href="javascript:;" class="collapse"> </a> <a
											href="#portlet-config" data-toggle="modal" class="config">
										</a> <a href="javascript:;" class="reload"> </a> <a
											href="javascript:;" class="remove"> </a>
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
										<form:form action="saveContractCompany.htm" modelAttribute="contractCompany" class="form-horizontal">
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
																<form:input type="text" path="name" class="form-control"
																	placeholder="Company Name here.."/> 
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Address</label>
															<div class="col-md-9">
																<form:textarea type="text" path="address" class="form-control"
																	placeholder="Address here.. "/> 
															</div>
														</div>
													</div>
													<!--/span-->
												</div>
												<!--/row-->
												<div class="row">
													
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Company Type</label>
															<div class="col-md-9">
															
															<form:select path="type" class="form-control">
															   <form:option value="NONE" label="--- Select ---"/>
															  <form:option value="Direct" label="Direct"/>
															  <form:option value="Agent" label="Agent"/>
															</form:select>
															</div>
														</div>
													</div>
													<!--/span-->
													
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Contact Person</label>
															<div class="col-md-9">
																<form:input path="contactPersion" type="text" class="form-control" placeholder="Contact Person name."/>
															</div>
														</div>
													</div>
													
												</div>
												<!--/row-->
												<div class="row">
													
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Landline Number</label>
															<div class="col-md-9">
															<form:input path="contactNo1" type="text" class="form-control" placeholder="Enter persons Landline Number"/>
															</div>
														</div>
													</div>
													<!--/span-->
													
													 <div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Mobile Number</label>
															<div class="col-md-9">
																<form:input path="contactNo2" type="text" class="form-control" placeholder="Enter Persons Mobile Number"/>
															</div>
														</div>
													</div>
												</div>
												
												<div class="row">
													
													<!--/span-->
													 <div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Tin No</label>
															<div class="col-md-9">
																<form:input path="tinNo" type="text" class="form-control" placeholder="Enter Tin No..."/>
															</div>
														</div>
													</div> 
													<!--/span-->
													
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Product</label>
															<div class="col-md-9">
																<form:input path="product" type="text" class="form-control" placeholder="Enter Product..."/>
															</div>
														</div>
													</div>
												</div>
												
											 	<div class="row">
													
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Owner Details</label>
															<div class="col-md-9">
															<form:input path="ownerDetails" type="text" class="form-control" placeholder="Enter Owner Details..."/>
															</div>
														</div>
													</div>
													<!--/span-->
													
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">owner Contact</label>
															<div class="col-md-9">
																<form:input path="ownerContact" type="text" class="form-control" placeholder="Enter ownerContact..."/>
															</div>
														</div>
													</div>
												</div>
												
												<div class="row">
													<!--/span-->
												<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Loading Staff</label>
															<div class="col-md-9">
															<form:input path="loadingStaff" type="text" class="form-control" placeholder="Enter Loading Staff..."/>
															</div>
														</div>
													</div> 
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">loading Staff Contact</label>
															<div class="col-md-9">
																<form:input path="loadingStaffContact" type="text" class="form-control" placeholder="Enter loading Staff Contact..."/>
															</div>
														</div>
													</div>
												</div>
												
												
												<div class="row">
													<!--/span-->
												<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Unloading Staff</label>
															<div class="col-md-9">
															<form:input path="unloadingStaff" type="text" class="form-control" placeholder="Enter Unloading Staff..."/>
															</div>
														</div>
													</div> 
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Unloading Staff Contact</label>
															<div class="col-md-9">
																<form:input path="unloadingStaffContact" type="text" class="form-control" placeholder="Enter Unloading Staff Contact..."/>
															</div>
														</div>
													</div>
												</div>
												
												
												<div class="row">
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Concern Email</label>
															<div class="col-md-9">
															<form:input path="email" type="text" class="form-control" placeholder="Enter halting..."/>
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Website</label>
															<div class="col-md-9">
																<form:input path="website" type="text" class="form-control" placeholder="Enter Tin No..."/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
												<div class="col-md-6">
												</div>
												<div class="col-md-6">
														<div class="form-group">
															<label>Is Regular</label>
															<div class="input-group">
																<div class="icheck-inline">
																	<label>
																	<form:radiobutton path="isRegular" value="Y" class="icheck"/> Yes </label>
																	<label>
																	<form:radiobutton path="isRegular" value="N" class="icheck"/> No </label>
																</div>
															</div>
														</div>
													</div>
												</div>
												
												<%-- <div class="row">
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Load Given for</label>
															<div class="col-md-9">
															<form:input path="" type="text" class="form-control" placeholder="Enter halting..."/>
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Owner Details</label>
															<div class="col-md-9">
																<form:input path="" type="text" class="form-control" placeholder="Enter Tin No..."/>
															</div>
														</div>
													</div>
												</div> --%>
												
												
												<%-- <div class="row">
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Loading Staff Details</label>
															<div class="col-md-9">
															<form:input path="" type="text" class="form-control" placeholder="Enter halting..."/>
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Concern Labour</label>
															<div class="col-md-9">
																<form:input path="" type="text" class="form-control" placeholder="Enter Tin No..."/>
															</div>
														</div>
													</div>
												</div> --%>
												
												<%-- 
												<div class="row">
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Indent Sender</label>
															<div class="col-md-9">
															<form:input path="" type="text" class="form-control" placeholder="Enter halting..."/>
															</div>
														</div>
													</div>
											
												</div> --%>
												
												
											</div>
											<div class="form-actions right">
												<button class="btn default" type="button">Cancel</button>
												<button class="btn blue" type="submit"><i class="fa fa-check"></i> Save</button>
											</div>
											<!-- <div class="form-actions">
												<div class="row">
													<div class="col-md-6">
														<div class="row">
															<div class="col-md-offset-3 col-md-9">
																<button type="submit" class="btn green">Submit</button>
																<button type="button" class="btn default">Cancel</button>
															</div>
														</div>
													</div>
													<div class="col-md-6"></div>
												</div>
											</div> -->
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


