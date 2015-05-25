<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>${user_name}</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="wrapper">
    <%@include file='header.jsp' %>
    <div class="container">
        <div class="col-sm-3">
            <h3>Admin menu</h3>
            <hr>
            <ul class="nav nav-stacked">
                <li><a href="/admin/edit_category"><h4>Add category</h4></a>
                </li>
                <li><a href="/admin/edit_project"><h4>Add project</h4></a></li>
                <li>for</li>
            </ul>
        </div>
        <h3>You projects:</h3>
        <div class="col-sm-9">
            <c:forEach var="c" items="${projects}">
                <div class="row">
                    <div class="thumbnail">
                        <a href="#">
                            <div class="caption">
                                <h3>
                                    <a href="/project/<c:out value="${c.id}"/>"><c:out
                                            value="${c.name}, category ${c.category.name}"/></a> |
                                    <a href="/project/<c:out value="${c.id}"/>/edit">edit</a> |
                                    <a href="/project/<c:out value="${c.id}"/>/delete">delete </a>
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
