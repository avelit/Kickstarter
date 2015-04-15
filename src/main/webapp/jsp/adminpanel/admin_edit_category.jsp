<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<div class="add_category">
<form name="add_category" action="<%= request.getContextPath() %>/addCategory" method="post">
    Catagory name:
    <input type="text" name="category_name">
    Description:
    <input type="text" name="category_description">
    <br>
    <input type="submit">
</form>
</div>

</body>
</html>
