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

          <form class="form-signin" action="/registration" method="post">
              <h2 class="form-signin-heading">Sign up</h2>

              <input name="name" class="form-control" id="focusedInput"
                     type="text" placeholder="Name" required autofocus>

              <input name="email" type="email" id="inputEmail"
                     class="form-control" placeholder="Email address" required>

              <input name="password" type="password" id="inputPassword"
                     class="form-control" placeholder="Password" required>

              <button class="btn btn-signup btn-lg btn-primary btn-block"
                      type="submit">Sign up
              </button>
              <h3 class="alert"><c:out value="${text_failed}"/></h3>
          </form>
      <%-- /CONTENT --%>
    </div>
<%@include file='include/footer.jsp' %>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
 <%@include file='include/bottom_scripts.jsp' %>
 </body>
</html>