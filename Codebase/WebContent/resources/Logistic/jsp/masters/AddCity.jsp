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
				Master Data <small>Master Data</small>
			</div>
			<!-- END PAGE TITLE -->
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
				<li><a href="form_layouts.html">UI Components</a> <i
					class="fa fa-circle"></i></li>
				<li class="active">Form Layouts</li>
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
										<i class="fa fa-gift"></i>City Details
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
								<div class="portlet-body form">
									<!-- BEGIN FORM-->
									<form:form action="saveCity.htm" modelAttribute="cityDto" class="form-horizontal" >
									<form:hidden path="id" />
										<form:hidden path="delFlag" />
										<form:hidden path="compId" />
										
										<div class="form-body">
											<h3 class="form-section">Enter City Details</h3>
											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<label class="control-label col-md-3">City Name</label>
														<div class="col-md-9">
															<form:input path="name" type="text" class="form-control"
																placeholder="City Name.. " />
														</div>
													</div>
												</div>
												<!--/span-->
												<div class="col-md-6">
													<div class="form-group">
														<label class="control-label col-md-3">State</label>
														<div class="col-md-9">
															<form:select path="stateId"
																class="select2me form-control">
																<form:option value="0" label="-- Select -- " />
																<form:options itemValue="id" itemLabel="name"
																	items="${lStates}" />
															</form:select>
														</div>
													</div>
												</div>
												<!--/span-->
											</div>
											<!--/row-->

										</div>
										<div class="form-actions right">
										<a href="getAllCity.htm"><button class="btn default" type="button">Cancel</button></a>
											<button class="btn blue" type="submit">
												<i class="fa fa-check"></i> Save
											</button>
										</div>
									</form:form>
									<!-- END FORM-->
								</div>
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

