<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit category</title>

    <link href="/css/signin.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <%@include file='admin_panel.jsp' %>

        <div class="col-sm-6">
            <h1>Add category:</h1>
            <hr>
            <div class="add_category">
                <form name="add_category" action="/categories/addCategory" method="post">
                    <h4>Catagory name:</h4>
                    <input type="text" name="category_name" class="form-control" id="category_name" placeholder="Name"
                           width="30%">
                    <h4>Description:</h4>
                    <input type="text" name="category_description" class="form-control" id="description"
                           placeholder="Description" width="30%">
                    <br>
                    <input type="submit" class="btn btn-success">
                </form>
            </div>
        </div>
        </div>
    </div>
</body>
</html>
