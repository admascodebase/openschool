
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>

<script type="text/javascript">

</script>

</head>

<body>
	<div>

		<a href="showAddBranch.htm"><button type="button"
				class="btn btn-success">Add</button></a> <a href="showEditBranch.htm"><button
				type="submit" class="btn btn-warning">Edit</button></a> <a
			href="showDeleteBranch.htm"><button type="button"
				class="btn btn-danger">Delete</button></a>

	</div>

	<!-- Row Start -->
	<div class="row">
		<div class="col-lg-12 col-md-12">
			<div class="widget">
				<div class="widget-header">
					<div class="title">Branch Details</div>
					<span class="tools"> <i class="fa fa-cogs"></i>
					</span>
				</div>
				<form:form name="BranchForm" commandName="selectedIds">
					<div class="widget-body">
						<div class="table-responsive">



<!-- 							<table
								class="table table-condensed table-striped table-bordered table-hover no-margin">
								<thead>
									<tr>
										<th style="width: 2%"><input type="checkbox"
											class="no-margin"></th>
										<th style="width: 15%">Branch Name</th>
										<th style="width: 15%">Edit/Delete</th>

									</tr>
								</thead> -->
								<%-- <c:set var="allBranch" value="${allBranch}"></c:set> --%>
								<c:if test="${empty lBranches}">
								
								hi guys...

<%-- 
									<c:forEach var="listValue" items="${allBranch}">

										<tbody>
											<tr>
												<td><form:checkbox path="ids" value="${listValue.branchName}"/></td>
												<td><a href="showEditBranch.htm"></a></td>
												 <td class="hidden-phone">
                              <a href="showEditBranch.htm?id=${listValue.id}" class="btn btn-warning btn-xs">
                                Edit
                              </a>
                              <a href="showDeleteBranch.htm?id=${listValue.id}" class="btn btn-info btn-xs">
                                Delete
                              </a>
                            </td>
											</tr>

										</tbody>
									</c:forEach> --%>
								</c:if>
						<!-- 	</table> -->
						
						an sleep..its 2:33

						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
<!-- Row End -->