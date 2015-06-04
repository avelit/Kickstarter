<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
  <title>Empty</title>
  <%@include file='include/head.jsp' %>
</head>
<body>
<div id="wrapper">
  <%@include file='include/header.jsp' %>
    <div class="container">
      <%-- CONTENT --%>
          <form class="form-signin" action="/update_password" method="post">
              <h2 class="form-signin-heading">Type new password</h2>
              <input type="hidden" name="token" value="<c:out value="${token}"/>">
              <input type="hidden" name="email" value="<c:out value="${email}"/>">
              <input name="password" class="form-control" id="password1"
                     type="password" placeholder="Password" required>

              <p></p>
              <input name="password2" type="password" id="password2"
                     class="form-control" placeholder="Repeat password" required>

              <p></p>
              <button class="btn btn-signup btn-lg btn-primary btn-block"
                      type="submit">Submit
              </button>
          </form>
      <%-- /CONTENT --%>
    </div>
<%@include file='include/footer.jsp' %>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
 <%@include file='include/bottom_scripts.jsp' %>
 </body>
</html>