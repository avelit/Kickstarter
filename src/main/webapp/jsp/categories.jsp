<%@ page import="ua.goit.gojava32.kickstarter.model.Category" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Discover Projects</title>
    <%@include file='header.jsp' %>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/signin.css" rel="stylesheet">
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
<br>
Add category:
<%@include file='/jsp/adminpanel/admin_edit_category.jsp'%>
</body>
</html>
