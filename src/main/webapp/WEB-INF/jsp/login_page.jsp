<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/signin.css" rel="stylesheet">

</head>
<body>
<div class="wrapper">
    <%@include file='header.jsp' %>
<div class="container">
    <form class="form-signin" action="/j_spring_security_check" method="post">
        <h2 class="form-signin-heading">Please sign in:</h2>
        <input name="j_username" type="email" class="form-control" placeholder="Email address" required autofocus>
        <input name="j_password" type="password" class="form-control" placeholder="Password" required>

        <div class="checkbox">
            <label>
                <input type="checkbox" id="_spring_security_remember_me" name = "_spring_security_remember_me"> Remember me
            </label>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <a class="btn btn-warning btn-lg btn-primary btn-block" href="/restore_page">Forgot password</a>
        <h3 class="alert"><c:out value="${text_failed}"/></h3>
    </form>
</div>
</div>
<%@include file='footer.jsp' %>
</body>
</html>
