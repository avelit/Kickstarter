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
    <form class="form-signin" action="/search_by_email_page" method="get">
    <h5>Forgot your account's password? Enter your email address and we'll send you a recovery link.</h5>
        <input name="search_mail" type="email" id="inputEmail" class="form-control" placeholder="Enter you e-mail address" required autofocus>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Send recovery email</button>
    </form>
</div>
</body>
</html>
