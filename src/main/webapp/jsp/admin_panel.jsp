<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin panel</title>
    <%@include file='header.jsp'%>
  <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<div class="row">
    <div class="col-sm-3">
      <h3>Admin menu</h3>
      <hr>
      <ul class="nav nav-stacked">
        <li><a href="/"><h4>Edit category</h4></a> </li>
        <li><a href="/"><h4>Edit category</h4></a> </li>
      </ul>
    </div>

  <div class="col-sm-9">
    <%@include file='/jsp/adminpanel/admin_edit_category.jsp'%>
  </div>
  </div>
</div>
</body>
</html>
