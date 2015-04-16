<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=request.getAttribute("project_name")%></title>
</head>
<body>

<h1>Project name: <font color="#d2691e"><%=request.getAttribute("project_name")%></font> </h1>
<h2>Category:  <%=request.getAttribute("category_name")%></h2>  <%-- add link to category--%>

<%
    List<String> comments = (List<String>)request.getAttribute("comments");
    if (comments != null) {
        for(String comment: comments) {
%>
<p>
<div class="comments">
    <%= comments %>
</div>
<%
        }
    }
%>

<p>

<form name="comments_form" >
  <textarea wrap="soft" rows="5"></textarea>
</form>

</body>
</html>
