<%@ page import="ua.goit.gojava32.kickstarter.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file='../css/categoriescss.css' %>
    </style>
    <title>Discover Projects</title>
</head>
<body>

<%
  List<Category> categories = (List<Category>)request.getAttribute("categories");
  for(Category category: categories) {
%>

  <div class="category-container">
  <%= "<a href = ./categories/" + category.getName() + ".jsp>" %>
  </div>

<%
    }
%>

</body>
</html>
