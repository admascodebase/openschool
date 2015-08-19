
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>

<script type="text/javascript">

</script>

</head>

<body>
	<div>

		<a href="./showAddTransportType.htm"><button type="button"
				class="btn btn-success">Add</button></a> <a href="./showEditTransportType.htm"><button
				type="submit" class="btn btn-warning">Edit</button></a> <a
			href="./showDeleteTransportType.htm"><button type="button"
				class="btn btn-danger">Delete</button></a>

	</div>

	<!-- Row Start -->
	<div class="row">
		<div class="col-lg-12 col-md-12">
			<div class="widget">
				<div class="widget-header">
					<div class="title">Transport Type</div>
					<span class="tools"> <i class="fa fa-cogs"></i>
					</span>
				</div>
				<form:form name="cityForm">
					<div class="widget-body">
						<div class="table-responsive">



							<table
								class="table table-condensed table-striped table-bordered table-hover no-margin">
								<thead>
									<tr>
										<th style="width: 15%">ID</th>
										<th style="width: 15%">Transport Type Name</th>
										<th style="width: 15%">Transport Type Description</th>
										<th style="width: 15%">Edit/Delete</th>
										
									</tr>
								</thead>
								<c:if test="${not empty lTransports}">


									<c:forEach var="listValue" items="${lTransports}">

										<tbody>
											<tr>
												<td>${listValue.id}</td>
												<td>${listValue.name}</td>
												<td>${listValue.description}</td>
												 <td class="hidden-phone">
                              <a href="showEditTransportType.htm?id=${listValue.id}" class="btn btn-warning btn-xs">
                                Edit
                              </a>
                              <a href="showDeleteTransportType.htm?id=${listValue.id}" class="btn btn-info btn-xs">
                                Delete
                              </a>
                            </td>
											</tr>

										</tbody>
									</c:forEach>
								</c:if>
							</table>

						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
<!-- Row End -->