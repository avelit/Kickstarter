<%@ page import="ua.goit.gojava32.kickstarter.model.Category" %>
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
    Set<Category> categories = (Set<Category>) request.getAttribute("categories");
    for (Category s : categories) {
%>

<div class="category-container">
    <a href="/categories/<%= s.getName() %>"><%= s.getName() %>
    </a>
</div>

<%
    }
%>

</body>
</html>
