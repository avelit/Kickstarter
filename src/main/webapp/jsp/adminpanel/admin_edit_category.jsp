<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit category</title>
        <%@include file='../header.jsp' %>
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



<center><table border=0>
<div class="add_category">
<tr>
<td>
    <form name="add_category" action="<%= request.getContextPath()%>/categories/addCategory" method="post">
        <font size="2">Catagory name: </font>
        <br>
        <input type="text" name="category_name">
        <br>
        <br>
        <font size="2">Description: </font>
        <br>
        <input type="text" name="category_description">
        <br>
        <br>
        <center><input type="submit" class="btn btn-success"></center>
    </form>
</div>
</td>
<tr>
<table>
</body>
</html>
