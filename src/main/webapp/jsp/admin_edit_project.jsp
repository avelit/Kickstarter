<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
        <%@include file='admin_panel.jsp' %>

        <div class="col-sm-6">
            <h1>Add project:</h1>
            <hr>
            <form name="myform"
                  action="/categories/<c:out value="${category_name}"/>/addProject" method="post">
            <h4>Project name: </h4>
            <input type="text"
                   name="project_name" class="form-control" id="input_name"
                   placeholder="Name" width="30%">
            <h4>Description:</h4>
            <input type="text" name="project_description" class="form-control"
                   id="input_description" placeholder="Description" width="30%">
            <br> <input type="hidden" name="category_name"
                        value="<c:out value="${category_name}"/>"/> <input type="submit"
                                                                           class="btn btn-success">
            </form>
        </div>
    </div>
</body>
</html>
