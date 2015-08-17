<!-- Main Container start -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <div class="dashboard-container">

      <div class="container">

        <!-- Row Start -->
        <div class="row">
          <div class="col-lg-4 col-md-4 col-md-offset-4">
            <div class="sign-in-container">
              <form action="userLogin.htm"  class="login-wrapper" method="post">
                <div class="header">
                  <div class="row">
                    <div class="col-md-12 col-lg-12">
                      <h3>Login<img src="${pageContext.request.contextPath}/resources/Logistic/assets/img/logo1.png" alt="Logo" class="pull-right"></h3>
                      <p>Fill out the form below to login.</p>
                    </div>
                  </div>
                </div>
                <div class="content">
                  <div class="form-group">
                    <label for="userName">User Name</label>
                    <input type="text" class="form-control" name="userName" placeholder="User Name" />
                  </div>
                  <div class="form-group">
                    <label for="Password1">Password</label>
                    <input type="password" class="form-control" name="password" placeholder="Password" />
                  </div>
                </div>
                <div class="actions">
                  <input class="btn btn-danger" name="Login" type="submit" value="Login">
                  <a class="link" href="#">Forgot Password?</a>
                  <div class="clearfix"></div>
                </div>
              </form>
            </div>
          </div>
        </div>
        <!-- Row End -->
        
      </div>
    </div>