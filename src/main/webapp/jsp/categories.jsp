<%@ page import="ua.goit.gojava32.kickstarter.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
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
    Set<String> categories = (Set<String>)request.getAttribute("categories");
  for(String s: categories) {
%>

  <div class="category-container">
      <%= s %>
  </div>

<%
    }
%>

</body>
</html>
