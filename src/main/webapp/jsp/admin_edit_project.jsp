<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit project</title>
    <%@include file='header.jsp' %>
    <link href="/css/signin.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-6">
            <h1>Add project:</h1>
            <hr>
            <form name="add_project" action="/categories/addProject" method="post">

                <h4>Category:</h4>
                <select name="category_id" class="form-control">
                    <c:forEach var="category" items="${categories}">
                        <option value="<c:out value="${category.id}"/>"><c:out value="${category.name}"/></option>
                    </c:forEach>
                </select>

                <h4>Project name: </h4>
                <input type="text" name="project_name" class="form-control" placeholder="Name" width="30%">

                <h4>Description:</h4>
                <input type="text" name="project_description" class="form-control" placeholder="Description" width="30%">
                <br>

                <input type="submit" class="btn btn-success">

            </form>
        </div>
    </div>
</div>
</body>
</html>
