<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
 <!-- Left Sidebar Start -->
          <div class="">
            

            <!-- Row Start -->
            <div class="row">
              <div class="col-lg-12 col-md-12">
                <div class="widget">
                  <div class="widget-header">
                    <div class="title">
                    SMS Settings
                     
                    </div>
                  </div>
                  <div class="widget-body">
                    <form:form class="form-horizontal no-margin" action="addsmssettingsubmit.htm" commandName="smssettings">
                      <div class="form-group">
                        <label for="pwd" class="col-sm-2 control-label">Organization Id</label>
                        <div class="col-sm-10">
                          <div class="row">
                            <div class="col-md-4 col-sm-4 col-xs-4">
                             <form:input type="text" class="form-control" path="orgId" placeholder="Organization Name"/>
                            </div>
                          <label for="pwd" class="col-sm-2 control-label">URL</label>
                            <div class="col-md-4 col-sm-4 col-xs-4">
                              <form:input type="text" class="form-control" path="url" placeholder="URL"/>
                            </div>
                          </div>
                        </div>
                      </div>
                         <div class="form-group">
                        <label for="pwd" class="col-sm-2 control-label">User id</label>
                        <div class="col-sm-10">
                          <div class="row">
                            <div class="col-md-4 col-sm-4 col-xs-4">
                              
							  <form:input type="text" class="form-control" path="userId" placeholder="user id"/>
                            </div>
                           <label for="pwd" class="col-sm-2 control-label">Password</label>
                            <div class="col-md-4 col-sm-4 col-xs-4">
                               <form:input type="text" class="form-control" path="password" placeholder="Password"/>
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
