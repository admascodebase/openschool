<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<div class="page-container">
	<!-- BEGIN PAGE HEAD -->
	<div class="page-head">
		<div class="container">
			<!-- BEGIN PAGE TITLE -->
			<div class="page-title">
				<h1>
					Contract Company Route  <small>All Contract Company Route Records are Here</small>
				</h1>
			</div>
			
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
				<li><a href="table_managed.html">Company Details</a> <i
					class="fa fa-circle"></i></li>
				<li class="active">Transport Details</li>
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
									class="caption-subject font-green-sharp bold uppercase">Transport
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
											<a href="showAddContractCompRoute.htm?compId=${contractCompId}"><button
													class="btn btn-circle btn-primary">Add New</button></a>
										</div>
									</div>
								 	<form:form name="compRouteForm" modelAttribute="companyRoute" action="getAllContractCompRoutes.htm">
								 	<div class="col-md-6">
										<div class="">
											<form:select id="mySelect" path="compId" class="form-control" onchange="getAllCompanyRoutes()">
												<form:option value="0" label="---Select---" />
												<form:options class="form-control" itemValue="id" itemLabel="name" items="${lContractCompanies}" />
											</form:select>
										</div>
									</div> 
									</form:form>
									
									<div class="col-md-6">
								</div>
							</div>
							<table class="table table-striped table-bordered table-hover"
								id="sample_2">
								<thead>
									<tr>
										<th class="table-checkbox"><input type="checkbox"
											class="group-checkable" data-set="#sample_2 .checkboxes" /></th>
										<th>Id</th>
										<th>Start City</th>
										<th>End City</th>
										<th>Edit/Delete</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${lCompanyRouteDtos}" var="CompanyRouteDto">
										<tr class="odd gradeX">
										<form:hidden path="contractCompId"/>
											<td><input type="checkbox" class="checkboxes" value="1" />
											</td>
											<td>${CompanyRouteDto.id}</td>
											<td>${CompanyRouteDto.startCityId.name}</td>
											<td>${CompanyRouteDto.endCityId.name}</td>
											<td><a href="editContractCompanyRoute.htm?id=${CompanyRouteDto.id}"
												class="btn btn-warning btn-xs"> Edit </a> <a
												href="deleteContractCompanyRoute.htm?id=${CompanyRouteDto.id}&compId=${CompanyRouteDto.compId}"
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
			<!-- END PAGE CONTENT INNER -->
		</div>
	</div>
	<!-- END PAGE CONTENT -->
</div>
</div>
<script>
function getAllCompanyRoutes() {
    var x = document.getElementById("mySelect").value;
    /* alert(""+x); */
    	 document.compRouteForm.action="getAllContractCompRoutes.htm?compId="+x;
    	 document.compRouteForm.method="GET";
    	 document.compRouteForm.submit();
}
</script>
