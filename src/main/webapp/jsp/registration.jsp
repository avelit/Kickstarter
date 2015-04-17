<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/signin.css" rel="stylesheet">
    <%@include file='header.jsp' %>
</head>
<body>
    <div class="container">
        <form class="form-signin" action="/login" method="post">
            <h2 class="form-signin-heading">Sigh up</h2>
            <input name="name" class="form-control" id="focusedInput" type="text" placeholder="Name" required autofocus>
            <p></p>
            <input name="email" type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
            <p></p>
            <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <button class="btn btn-signup btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
    </div>
</div>

</body>
</html>
