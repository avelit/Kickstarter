<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit category</title>
        <!-- <%@include file='../header.jsp' %> -->
        <link href="/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/signin.css" rel="stylesheet">
</head>
<body>

<div class="col-md-4">
<br> Add category:
<div class="add_category">
    <form name="add_category" action="/categories/addCategory" method="post">
        <font size="2">Catagory name: </font>
        <input type="text" name="category_name" class="form-control" id="category_name" placeholder="Name" width="30%">
        <br>
        <font size="2">Description: </font>
        <input type="text" name="category_description" class="form-control" id="description" placeholder="Description" width="30%">
        <br>
        <input type="submit" class="btn btn-success">
    </form>
</div>
</div>
</body>
</html>
