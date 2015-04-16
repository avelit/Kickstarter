<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${name}</title>
</head>
<body>
<h1>Category: ${name}</h1>

<%
    Set<String> projects = (Set<String>)request.getAttribute("projects");
    for(String p: projects) {
%>

<div class="category-container">
    <a href="<%= request.getContextPath() %>/<%= p %>"> <%= p %> </a>
</div>

<%
    }
%>

</body>
</html>
