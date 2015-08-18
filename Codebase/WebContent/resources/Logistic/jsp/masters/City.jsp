
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>

<script type="text/javascript">

</script>

</head>

<body>
	<div>

		<a href="showAddCity.htm"><button type="button"
				class="btn btn-success">Add</button></a> <a href="showEditCity.htm"><button
				type="submit" class="btn btn-warning">Edit</button></a> <a
			href="showDeleteCity.htm"><button type="button"
				class="btn btn-danger">Delete</button></a>

	</div>

	<!-- Row Start -->
	<div class="row">
		<div class="col-lg-12 col-md-12">
			<div class="widget">
				<div class="widget-header">
					<div class="title">City Details</div>
					<span class="tools"> <i class="fa fa-cogs"></i>
					</span>
				</div>
				<form:form name="cityForm" commandName="selectedIds">
					<div class="widget-body">
						<div class="table-responsive">



							<table
								class="table table-condensed table-striped table-bordered table-hover no-margin">
								<thead>
									<tr>
										<th style="width: 2%"><input type="checkbox"
											class="no-margin"></th>
										<th style="width: 5%">City Name</th>

									</tr>
								</thead>
								<c:if test="${not empty lCities}">


									<c:forEach var="listValue" items="${lCities}">

										<tbody>
											<tr>
												<td><form:checkbox path="ids" value="${listValue.cityName}"/></td>
												<td>${listValue.cityName}</td>
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