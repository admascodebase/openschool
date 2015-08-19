
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="">


	<!-- Row Start -->
	<div class="row">
		<div class="col-lg-12 col-md-12">
			<div class="widget">
				<div class="widget-header">
					<div class="title">Transport Type</div>
				</div>
				<div class="widget-body">
					<form:form action="saveTransportType.htm" method="post"
						modelAttribute="transportType" class="form-horizontal no-margin">
						<div class="form-group">
							<label for="pwd" class="col-sm-2 control-label">Company
								Id</label>
							<div class="col-sm-10">
								<div class="row">
									<div class="col-md-4 col-sm-4 col-xs-4">
										<form:input type="text" class="form-control" path="companyId"
											placeholder="Company ID" />
									</div>
									<label for="pwd" class="col-sm-2 control-label">Transport Type
										Name</label>
									<div class="col-md-4 col-sm-4 col-xs-4">
										<form:input type="text" class="form-control"
											path="name" placeholder="Transport Type Name" />
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="pwd" class="col-sm-2 control-label">Description</label>
							<div class="col-sm-10">
								<div class="row">
									<div class="col-md-4 col-sm-4 col-xs-4">

										<form:input type="text" class="form-control" path="description"
											placeholder="Transport Type Description" />
									</div>

								</div>
							</div>
						</div>



						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" id="confirm" class="btn btn-success">Save</button>
								<button type="submit" id="confirm" class="btn btn-danger">Cancel</button>
								<button type="submit" id="confirm" class="btn btn-warning">Reset</button>
							</div>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<!-- Row End -->


</div>