<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Empty</title>
    <%@include file='include/head.jsp' %>
</head>
<body>
<div id="wrapper">
    <%@include file='include/header.jsp' %>
    <div class="container">
        <%-- CONTENT --%>
        <div class="row">
            <div class="col-md-6 col-md-offset-2">
                <form class="form-signin" action="/search_by_email_page" method="get">
                    <h5>Forgot your account's password? Enter your email address and
                        we'll send you a recovery link.</h5>
                    <input name="search_mail" type="email" id="inputEmail"
                           class="form-control" placeholder="Enter you e-mail address"
                           required autofocus>
                    <br>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Send
                        recovery email
                    </button>
                </form>
            </div>
        </div>
        <%-- /CONTENT --%>

    </div>
    <%@include file='include/footer.jsp' %>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
<%@include file='include/bottom_scripts.jsp' %>
</body>
</html>