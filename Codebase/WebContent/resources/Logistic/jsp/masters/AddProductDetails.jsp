<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<li><a href="#">Masters</a> <i class="fa fa-circle"></i></li>
				<li><a href="#">Product Details</a> <i class="fa fa-circle"></i></li>
			</ul>
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN EXAMPLE TABLE PORTLET-->
					<div class="portlet light">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-cogs font-green-sharp"></i> <span
									class="caption-subject font-green-sharp bold uppercase">Product
									Details</span>
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


						<div class="portlet-body">
							<div class="table-toolbar">
								<div class="row">
									<div class="col-md-6">
										<div class="btn-group">
											<a href="showAddProduct.htm"><button
													class="btn btn-circle btn-primary">Add New</button></a>
										</div>
									</div>
									<!-- <div class="col-md-6">
										<div class="btn-group pull-right">
											<button class="btn dropdown-toggle" data-toggle="dropdown">
												Tools <i class="fa fa-angle-down"></i>
											</button>
											<ul class="dropdown-menu pull-right">
												<li><a href="javascript:;"> Print </a></li>
												<li><a href="javascript:;"> Save as PDF </a></li>
												<li><a href="javascript:;"> Export to Excel </a></li>
											</ul>
										</div>
									</div> -->
								</div>
							</div>
							<table class="table table-striped table-bordered table-hover"
								id="sample_2">
								<thead>
									<tr>
										<th class="table-checkbox"><input type="checkbox"
											class="group-checkable" data-set="#sample_2 .checkboxes" /></th>
										<th>Name</th>
										<th>Description</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${lProducts}" var="product">
										<tr class="odd gradeX">

											<td><input type="checkbox" class="checkboxes" value="1" />
											</td>
											<td>${product.name}</td>
											<td>${product.description}</td>

											<td><a href="editProduct.htm?id=${product.id}"
												class="btn btn-warning btn-xs"> Edit </a> <a
												href="deleteProduct.htm?id=${product.id}"
												class="btn btn-info btn-xs"> Delete </a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
					<!-- END EXAMPLE TABLE PORTLET-->
				</div>
			</div>
		</div>
	</div>
</div>
