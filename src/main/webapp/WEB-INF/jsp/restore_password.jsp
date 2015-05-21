<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restore password</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/signin.css" rel="stylesheet">
</head>
<body>
<div class="wrapper">
    <%@include file='header.jsp' %>
    <div class="container">
        <form class="form-signin" action="/restore_password" method="post">
            <h2 class="form-signin-heading">Type new password</h2>
            <input name="password" class="form-control" id="password1"
                   type="password" placeholder="Password" required>

            <p></p>
            <input name="password2" type="password" id="password2"
                   class="form-control" placeholder="Repeat password" required>

            <p></p>
            <button class="btn btn-signup btn-lg btn-primary btn-block"
                    type="submit">Submit
            </button>
        </form>
    </div>
</div>
</div>
<%@include file='footer.jsp' %>
</body>
</html>