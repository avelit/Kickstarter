<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${error_name}</title>
</head>
<body>
<div class="wrapper">
    <%@include file='header.jsp' %>
    <link href="/resource/css/bootstrap.min.css" rel="stylesheet">
    <div class="top-left">
        ERROR! ${error_name}
    </div>
</div>
<%@include file='footer.jsp' %>
</body>
</html>
