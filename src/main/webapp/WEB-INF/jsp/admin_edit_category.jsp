<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit category</title>
    <link href="/css/signin.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="wrapper">
    <%@include file='header.jsp' %>
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <h1>Add category:</h1>
                <hr>
                <div class="add_category">
                    <form name="add_category" action="/category/add"
                          method="post">
                        <h4>Catagory name:</h4>
                        <input type="text" name="category_name"
                               class="form-control"
                               placeholder="Name"
                               width="30%">
                        <h4>Description:</h4>
                        <input type="text" name="category_description"
                               class="form-control" placeholder="Description"
                               width="30%">
                        <br>
                        <input type="submit" class="btn btn-success" value="Submit">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file='footer.jsp' %>
</body>
</html>
