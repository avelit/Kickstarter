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
          <h3 class="alert"><c:out value="${result_search}"/></h3>
      <%-- /CONTENT --%>
    </div>
<%@include file='include/footer.jsp' %>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
 <%@include file='include/bottom_scripts.jsp' %>
 </body>
</html>