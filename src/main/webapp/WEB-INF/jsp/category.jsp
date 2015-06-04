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
        <h3>
            Category: <c:out value="${category.name}"/>
            <br>
            Description: <c:out value="${category.description}"/>
        </h3>

        <div class="row">
            <c:forEach var="project" items="${projects}">
                <%@include file='include/project_box.jsp' %>
            </c:forEach>
        </div>
    </div>
    <div class="push" id="push"></div>
</div>
<%-- /CONTENT --%>
</div>
<%@include file='include/footer.jsp' %>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
<%@include file='include/bottom_scripts.jsp' %>
</body>
</html>