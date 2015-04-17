<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
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
    <form name="myform" action="<%= request.getContextPath() %>/categories/addProject" method="post">
        <p>Catagory name:</p>
        <input type="text" name="project_name">

        <p>Description:</p>
        <input type="text" name="project_description">
        <br>
        <input type="submit">
    </form>
</div>
</body>
</html>
