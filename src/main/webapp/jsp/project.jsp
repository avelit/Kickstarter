<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=request.getAttribute("project_name")%></title>
    <%@include file='header.jsp' %>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/signin.css" rel="stylesheet">
</head>
<body>
<center>
<table border=0>
<tr>
<td>
<center><h1>Project name: <%=request.getAttribute("project_name")%></h1></center>
</td>
</tr>
<tr>
<td>
<center><h2>Category:  <%=request.getAttribute("category_name")%></h2></center>
</td>
</tr>
<tr>
<td>
<%
    List<String> comments = (List<String>) request.getAttribute("comments");
    if (comments != null) {
        for (String comment : comments) {
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

<form name="comments_form">
    <font size="2">Enter your name: </font>
    <br>
    <input type=text name=firstname>
    <br>
    <br>
    <font size="2">Enter your comment: </font>
    <br>
    <textarea name="comment" wrap="soft" rows="5" cols="50"></textarea>
    </td>
    <td>
    <center>&nbsp &nbsp<input name="submit" value="Send" type="submit"  class="btn btn-success" onClick="output(comment.value)"></center>
    </td>
</form>
</tr>
</table>
</body>
</html>
