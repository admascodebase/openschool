
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
				<li><a href="#">Masters</a> <i class="fa fa-circle"></i></li>
				<li class="active">Add Company</li>
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
										<i class="fa fa-gift"></i>Company Details
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
										<form:form action="saveCompany.htm" modelAttribute="company" class="form-horizontal">
										<form:hidden path="id" />
										<form:hidden path="delFlag" />
										<%-- <form:hidden path="compId" /> --%>
											<div class="form-body">
												<h3 class="form-section"></h3>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Company
																Name</label>
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
																<form:input type="text" path="address" class="form-control"
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
															<label class="control-label col-md-3">Contact
																No.1</label>
															<div class="col-md-9">
																<form:input type="text" path="contactNo1" class="form-control"
																	placeholder="Enter your contact number."/> 
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Contact
																No.2</label>
															<div class="col-md-9">
																<form:input path="contactNo2" type="text" class="form-control"
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
															<label class="control-label col-md-3">Email Id 1</label>
															<div class="col-md-9">
																<form:input path="emailId1" type="text" class="form-control" placeholder="Enter email id 1."/>
															</div>
														</div>
													</div>
													<!--/span-->
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Email Id 2</label>
															<div class="col-md-9">
															<form:input path="emailId2" type="text" class="form-control" placeholder="Enter email id 2"/>
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
															<label class="control-label col-md-3">PAN Number</label>
															<div class="col-md-9">
																<form:input path="panNo" type="text" class="form-control" placeholder="PAN Number"/>
															</div>
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">TAN Number</label>
															<div class="col-md-9">
																<form:input path="tanNo" type="text" class="form-control" placeholder="TAN Number"/>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Tag Line</label>
															<div class="col-md-9">
																<form:input path="tagLine" type="text" class="form-control" placeholder="Company tag line"/>
															</div>
														</div>
													</div>
													
												</div>
												
												<!--/row-->
											</div>
											<div class="form-actions right">
											<a href="getAllCompany.htm">
												<button class="btn default" type="button">Cancel</button></a>
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


