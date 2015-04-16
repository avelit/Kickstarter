<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${category_name}</title>
</head>
<body>
<h1>Category: ${category_name}</h1>

<%
    List<String> projects = (List<String>)request.getAttribute("projects");
    if (projects != null) {
        for(String p: projects) {
%>

<div class="category-container">
    <a href="/categories/${category_name}/<%= p %>"> <%= p %> </a>
</div>

<%
        }
    }
%>

</body>
</html>
