<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Empty</title>
    <%@include file='include/head.jsp' %>
</head>
<body>
<div id="wrapper">
    <%@include file='include/header.jsp' %>
    <div id="container">


    <%-- CONTENT --%>


    <p>

    <h2>Sorry, something went wrong ;(</h2>
    </p>
    <p>

    <h1>${error_name} </h1></p>


    <%-- /CONTENT --%>
</div>
<%@include file='include/footer.jsp' %>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
<%@include file='include/bottom_scripts.jsp' %>
</body>
</html>






