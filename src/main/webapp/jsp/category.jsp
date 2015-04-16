<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${name}</title>
</head>
<body>
<h1>Category: ${name}</h1>

<%
    List<String> projects = (List<String>)request.getAttribute("projects");
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
