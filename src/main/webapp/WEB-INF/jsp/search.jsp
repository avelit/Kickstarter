<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result Search</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="wrapper">
    <%@include file='header.jsp' %>
    <div class="container">
        <div class="row">
            <h3>
                <c:out value="${resultCategoriesSearch.size()}"/>
                    results found in categories
            </h3>
            <c:forEach var="c" items="${resultCategoriesSearch}">
                <div class="col-md-4">
                    <div class="thumbnail">
                        <a href="#">
                            <div class="caption">
                                <h3>
                                    <a href="/category/<c:out value="${c.id}"/>"><c:out
                                            value="${c.name}"/></a>
                                </h3>
                            </div>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="row">
            <h3>
                <c:out value="${resultProjectsSearch.size()}"/> results
                    found in projects
            </h3>
            <c:forEach var="c" items="${resultProjectsSearch}">
                <div class="col-md-4">
                    <div class="thumbnail">
                        <a href="#">
                            <div class="caption">
                                <h3>
                                    <a href="/project/<c:out value="${c.id}"/>"><c:out
                                            value="${c.name}"/></a>
                                </h3>
                            </div>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<%@include file='footer.jsp' %>
</body>
</html>
