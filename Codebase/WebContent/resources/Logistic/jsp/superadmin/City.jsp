
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
<div>

<a href="./addCity.htm"><button type="button" class="btn btn-success">Add</button></a>
<a href="./editCity.htm"><button type="button" class="btn btn-warning">Edit</button></a>
<a href="./deleteCity.htm"><button type="button" class="btn btn-danger">Delete</button></a>

</div>

<!-- Row Start -->
            <div class="row">
              <div class="col-lg-12 col-md-12">
                <div class="widget">
                  <div class="widget-header">
                    <div class="title">
                     City Details
                    </div>
                    <span class="tools">
                      <i class="fa fa-cogs"></i>
                    </span>
                  </div>
                  <div class="widget-body">
                    <div class="table-responsive">
                   
                    <c:forEach items="${city}" var="list">        
<form:textarea path="city.cityName"/>  
</c:forEach>
                      <table class="table table-condensed table-striped table-bordered table-hover no-margin">
                        <thead>
                          <tr>
                            <th style="width:2%">
                               <input type="checkbox" class="no-margin">
                            </th>
							<th style="width:5%">
                               City Name
                            </th>
                            
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>
                               <input type="checkbox" class="no-margin">
                            </td>
							<td>
                              Pune
                            </td>
                          </tr>
                          
                        </tbody>
                      </table>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            </body>
            <!-- Row End -->