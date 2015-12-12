<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="page-container">
	<!-- BEGIN PAGE HEAD -->
	<!-- END PAGE HEAD -->
	<!-- BEGIN PAGE CONTENT -->
	<div class="page-content">
		<div class="container">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- <div class="modal fade" id="portlet-config" tabindex="-1"
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
			 -->
			<!-- /.modal -->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE BREADCRUMB -->
			<ul class="page-breadcrumb breadcrumb">
				<li><a href="./login.htm">Home</a><i class="fa fa-circle"></i></li>
				<li><a href="./getAllContractCompany.htm">Contract Company</a>
					<i class="fa fa-circle"></i></li>
				<li><a>Company Load To Transport Entry</a> <i
					class="fa fa-circle"></i></li>
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
									class="caption-subject font-green-sharp bold uppercase">Company
									Load To Transport Entry</span>
							</div>
							<div class="tools"></div>
						</div>
						<c:if test="${errorCode ne null}">
							<div id="errorDiv" class="alert alert-danger">
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

						<form:form name="LoadEntryForm" modelAttribute="LoadEntry"
							action="getAllTransportDetails.htm">
							<div class="portlet-body">
								<div class="table-toolbar">
									<div class="row">
										<div class="col-md-4">
											<div id="addButtondiv">
												<div class="btn-group">
													<a
														href="showAddloadEntry.htm?contractCompId=${id}"><button
															class="btn btn-circle btn-primary">Add New</button></a>
													<button class="btn btn-circle btn-primary" onclick="showAddCompLoadToTrans()">Add New</button>
												</div>
											</div>
										</div>
										<div class="col-md-4"></div>
										<div class="col-md-4">
											<div class="btn-group pull-right">

												<label class="control-label col-md-10">Select
													Contract Company </label>
												<form:select id="contractCompanySelect"
													path="contractCompId" class="form-control"
													onchange="getAllLoadEntryForloadToTrans()">
													<form:option value="0" label="---Select---" />
													<form:options class="form-control" itemValue="id"
														itemLabel="name" items="${lContractCompanies}" />
												</form:select>
											</div>
										</div>
									</div>
								</div>
								<table class="table table-striped table-bordered table-hover"
									id="sample_2">
									<thead>
										<tr>
											<th class="table-checkbox"><input type="checkbox"
												class="group-checkable" data-set="#sample_2 .checkboxes" /></th>
											<th>Contract Company</th>
											<th>Route</th>
											<th>Transport Details</th>
											<th>Loading Date</th>
											<th>Unloading Date</th>
											<th>Amount</th>
											<th>Advance Amount</th>
											<th>Balance Amount</th>
											<th>Load Status</th>
											<th>Edit/Delete</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${lLoadDto}" var="LoadEntry">
											<tr class="odd gradeX">
												<form:hidden path="contractCompId" />
												<td><input name="loadDtlId" type="radio" class="checkboxes" value="${LoadEntry.id}"/></td>
												<td id="loadDtlId">${LoadEntry.id}</td>
												<%-- <td>${LoadEntry.companyRouteDto.routeName}</td> --%>
												<%-- <td>${LoadEntry.transportTypeDtlDto.truckName}</td> --%>
												<td>${LoadEntry.compRouteId}</td>
												<td>${LoadEntry.transportTypeDtlId}</td>
												<td>${LoadEntry.loadingDate}</td>
												<td>${LoadEntry.unloadingDate}</td>
												<td>${LoadEntry.amount}</td>
												<td>${LoadEntry.advance}</td>
												<td>${LoadEntry.balance}</td>
												<td>${LoadEntry.status}</td>
												<td><a href="editLoadEntry.htm?id=${LoadEntry.id}"
													class="btn btn-warning btn-xs"> Edit </a> <a
													href="deleteLoadEntry.htm?id=${LoadEntry.id}&contractCompId=${LoadEntry.contractCompId}"
													class="btn btn-info btn-xs"> Delete </a></td>
													<td><a class="btn btn-info btn-xs" href="showAddCompLoadToTrans.htm?companyLoadDetailId=${LoadEntry.id}">Add</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							</form:form>
					</div>
					<!-- END EXAMPLE TABLE PORTLET-->
				</div>
			</div>
			<!-- END PAGE CONTENT INNER -->
		</div>
	</div>
	<!-- END PAGE CONTENT -->
</div>
<script>
	function getAllLoadEntryForloadToTrans() {
		var x = document.getElementById("contractCompanySelect").value;
		document.LoadEntryForm.action = "getAllCompLoadToTrans.htm?contractCompId="
				+ x;
		document.LoadEntryForm.method = "GET";
		document.LoadEntryForm.submit();
	}
	
	function showAddCompLoadToTrans() {
		var selected = $("input[type='radio'][name='loadDtlId']:checked").val();
		alert(selected);
		document.LoadEntryForm.action = "showAddCompLoadToTrans.htm?companyLoadDetailId=" + selected;
		document.LoadEntryForm.method = "GET";
		document.LoadEntryForm.submit();
	}
</script>
<script type="text/javascript">
	var y = document.getElementById("contractCompanySelect").value;
	if (y == 0) {
		var x = document.getElementById("errorDiv");
		x.innerHTML += "<br /> Please Select Contract Company First"
		document.getElementById("addButtondiv").style.display = "none";
	}
</script>
