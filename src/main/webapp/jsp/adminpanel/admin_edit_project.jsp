<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit project</title>
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
<tr>
<td>
<div class="add_project">
    <form name="myform" action="<%= request.getContextPath() %>/categories/addProject" method="post">
        <font size="2">Catagory name: </font>
        <input type="text" name="project_name" class="form-control" id="exampleInputName2" placeholder="Violin">
        <br>
        <font size="2">Description: </font>
        <input type="text" name="project_description" class="form-control" id="exampleInputName2" placeholder="Musical instrument">
        <br>
        <center><input type="submit" class="btn btn-success" ></center>
    </form>
</div>
</td>
</tr>
</table>
</body>
</html>
