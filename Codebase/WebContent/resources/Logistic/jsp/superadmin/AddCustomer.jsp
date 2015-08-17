<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Dashboard Wrapper Start -->
         <div class="dashboard-wrapper">
          
          <!-- Left Sidebar Start -->
          <div class="">
            

            <!-- Row Start -->
            <div class="row">
              <div class="col-lg-12 col-md-12">
                <div class="widget">
                  <div class="widget-header">
                    <div class="title">
                    Add Customer
                     
                    </div>
                  </div>
                  <div class="widget-body">
                    <form:form action="addCustomerSubmit.htm" method="post" modelAttribute="customer"  class="form-horizontal no-margin">
                      <div class="form-group">
                        <label for="pwd" class="col-sm-2 control-label">Company Name</label>
                        <div class="col-sm-10">
                          <div class="row">
                            <div class="col-md-4 col-sm-4 col-xs-4">
                             <form:input type="text" class="form-control" path="companyName" placeholder="Company Name"/>
                            </div>
                          <label for="pwd" class="col-sm-2 control-label">Company Address</label>
                            <div class="col-md-4 col-sm-4 col-xs-4">
                              <form:textarea path="companyAddress" class="form-control" placeholder="Company Address..."></form:textarea>
                            </div>
                          </div>
                        </div>
                      </div>
                         <div class="form-group">
                        <label for="pwd" class="col-sm-2 control-label">Address</label>
                        <div class="col-sm-10">
                          <div class="row">
                            <div class="col-md-4 col-sm-4 col-xs-4">
                              
							  <form:input type="text" class="form-control" path="address" placeholder="Address"/>
                            </div>
                           <label for="pwd" class="col-sm-2 control-label">Email</label>
                            <div class="col-md-4 col-sm-4 col-xs-4">
                               <form:input type="text" class="form-control" path="emailId" placeholder="Email Id"/>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="pwd" class="col-sm-2 control-label">Contact Number 1</label>
                        <div class="col-sm-10">
                          <div class="row">
                            <div class="col-md-4 col-sm-4 col-xs-4">
                             <form:input type="text" class="form-control" path="contactNo1" placeholder="Contact Number 1"/>
                            </div>
                           <label for="pwd" class="col-sm-2 control-label">Contact Number 2</label>
                            <div class="col-md-4 col-sm-4 col-xs-4">
                               <form:input type="text" class="form-control" path="ContactNo2" placeholder="Contact Number 2"/>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="pwd" class="col-sm-2 control-label">Contact Person</label>
                        <div class="col-sm-10">
                          <div class="row">
                            <div class="col-md-4 col-sm-4 col-xs-4">
                             <form:input type="text" class="form-control" path="contactPerson" placeholder="Contact Person Name"/>
                            </div>
                           <label for="pwd" class="col-sm-2 control-label">Contact Person Number</label>
                            <div class="col-md-4 col-sm-4 col-xs-4">
                               <form:input type="text" class="form-control" path="contactPersonNo" placeholder="Phone Number"/>
                            </div>
                          </div>
                        </div>
                      </div>
					  
					   <div class="form-group">
                        <label for="pwd" class="col-sm-2 control-label">Price Plan</label>
                        <div class="col-sm-10">
                          <div class="row">
                            <div class="col-md-4 col-sm-4 col-xs-4">
                             <select class="form-control">
							 
							 </select>
                            </div>
                           <label for="pwd" class="col-sm-2 control-label">SMS Gateway</label>
                            <div class="col-md-4 col-sm-4 col-xs-4">
                                <select class="form-control">
							 
							 </select>
                            </div>
                          </div>
						 
                        </div>
                      </div>
					  
					  
					  
					   <div class="form-group">
                        <label for="pwd" class="col-sm-2 control-label">Website</label>
                        <div class="col-sm-10">
                          <div class="row">
                            <div class="col-md-4 col-sm-4 col-xs-4">
                            <input type="text" class="form-control" id="website" placeholder="Website">
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
          <!-- Left Sidebar End -->

        </div>
        <!-- Dashboard Wrapper End -->