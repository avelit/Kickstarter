<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/signin.css" rel="stylesheet">
    <%@include file='header.jsp' %>
</head>
<body>

<div class="container">
    <form class="form-signin" action="/find_mail" method="post">
        <label for="inputEmail" class="sr-only">Enter you e-mail address</label>
        <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form>
</div>
</body>
</html>
