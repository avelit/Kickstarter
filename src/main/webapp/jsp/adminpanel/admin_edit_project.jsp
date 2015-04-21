<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit project</title>
        <!-- <%@include file='../header.jsp' %> -->
        <link href="/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/signin.css" rel="stylesheet">
</head>
<body>
<%
    String login = request.getParameter("login");
    String pass = request.getParameter("pass");

    String jspUrl = request.getContextPath();
    if (login != "admin" || pass != "") {

    }
%>



<div class="add_project">
    <form name="myform" action="/categories/<c:out value="${category_name}"/>/addProject" method="post">
        <font size="2">Project name: </font>
        <input type="text" name="project_name" class="form-control" id="exampleInputName2" placeholder="Violin" width="30%">
        <br>
        <font size="2">Description: </font>
        <input type="text" name="project_description" class="form-control" id="exampleInputName2" placeholder="Musical instrument" width="30%">
        <br>
        <input type="hidden" name = "category_name" value="<c:out value="${category_name}"/>"/> 
        <input type="submit" class="btn btn-success" >
    </form>
</div>
</body>
</html>
