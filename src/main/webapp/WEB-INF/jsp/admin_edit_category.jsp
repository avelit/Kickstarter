<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Empty</title>
  <%@include file='include/head.jsp' %>
</head>
<body>
<div id="wrapper">
  <%@include file='include/header.jsp' %>
    <div class="container">
      <%-- CONTENT --%>
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
                                 width="30%" required>
                          <h4>Description:</h4>
                          <input type="text" name="category_description"
                                 class="form-control" placeholder="Description"
                                 width="30%">
                          <br>
                          <input type="submit" class="btn btn-success" value="Submit">
                      </form>
                  </div>
              </div>
      <%-- /CONTENT --%>
    </div>
<%@include file='include/footer.jsp' %>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
 <%@include file='include/bottom_scripts.jsp' %>
 </body>
</html>