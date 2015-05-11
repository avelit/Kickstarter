<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/signin.css" rel="stylesheet">
    <%@include file='header.jsp' %>
</head>
<body>
    <div class="container">
        <form class="form-signin" action="/restore_password" method="post">
            <h2 class="form-signin-heading">Type new password</h2>
            <input name="password" class="form-control" id="password1" type="password" placeholder="Password" required>
            <p></p>
            <input name="password2" type="password" id="password2" class="form-control" placeholder="Repeat password" required>
            <p></p>
            <button class="btn btn-signup btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form>
    </div>
</div>
</body>
</html>