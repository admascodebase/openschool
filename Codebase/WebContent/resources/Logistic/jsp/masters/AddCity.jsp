
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Dashboard Wrapper Start -->
<div class="">
	<!-- Row Start -->
	<div class="row">
		<div class="col-lg-12 col-md-12">
			<div class="widget">
				<div class="widget-header">
					<div class="title">City</div>
				</div>
				<div class="widget-body">
					<form:form action="saveCity.htm" modelAttribute="city" class="form-horizontal no-margin">
						<div class="form-group">
							<label for="pwd" class="col-sm-2 control-label">City Name</label>
							<div class="col-sm-10">
								<div class="row">
									<div class="col-md-4 col-sm-4 col-xs-4">
										<form:input type="text" class="form-control" path="cityName" id="orgId"
											placeholder="City Name"/>
									</div>
									<label for="pwd" class="col-sm-2 control-label">State Name</label>
									<div class="col-md-4 col-sm-4 col-xs-4">
										<form:select class="form-control" path="">
										<form:options items="${lState}" itemLabel="stateName" itemValue="id"/>
										</form:select>
									</div>
								</div>
							</div>
						</div>
			<button type="submit" class="btn btn-success">Save</button> 
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<!-- Row End -->


</div>
