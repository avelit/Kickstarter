<%@page import="ua.goit.gojava32.kickstarter.model.Project" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=request.getAttribute("category_name")%></title>
    <%@include file='header.jsp' %>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/signin.css" rel="stylesheet">
</head>
<body>
<h1>Category: <%=request.getAttribute("category_name")%>
</h1>

<%
    List<Project> projects = (List<Project>) request.getAttribute("projects");
    if (projects != null) {
        for (Project p : projects) {
%>

<div class="category-container">
    <a href="/categories/<%=request.getAttribute("category_name")%>/<%= p.getName() %>"><%= p.getName() %>
    </a>
</div>

<%
        }
    }
%>

</body>
</html>
