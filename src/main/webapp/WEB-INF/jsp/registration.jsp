<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/signin.css" rel="stylesheet">
</head>
<body>
<div class="wrapper">
    <%@include file='header.jsp' %>
    <div class="container">
        <form class="form-signin" action="/registration" method="post">
            <h2 class="form-signin-heading">Sign up</h2>

            <input name="name" class="form-control" id="focusedInput"
                   type="text" placeholder="Name" required autofocus>

            <input name="email" type="email" id="inputEmail"
                   class="form-control" placeholder="Email address" required>

            <input name="password" type="password" id="inputPassword"
                   class="form-control" placeholder="Password" required>

          <button class="btn btn-signup btn-lg btn-primary btn-block"
                    type="submit">Sign up
            </button>
          <h3 class="alert"><c:out value="${text_failed}"/></h3>
        </form>
    </div>
</div>
</div>
<%@include file='footer.jsp' %>
</body>
</html>
