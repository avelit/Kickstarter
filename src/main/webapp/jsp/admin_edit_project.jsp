<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="add_project">
    <form name="myform" action="<%= request.getContextPath() %>/addProject" method="post">
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
