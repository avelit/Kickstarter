<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Discover Projects</title>
    <%@include file='header.jsp' %>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <c:forEach var="c" items="${categories}">
            <div class="col-md-4">
                <div class="thumbnail">
                    <a href="#">
                        <div class="caption">
                            <h3>
                                <a href="/categories/<c:out value="${c.name}"/>"><c:out
                                        value="${c.name}"/></a>
                            </h3>
                        </div>
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
