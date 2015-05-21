<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link href="/css/header.css" rel="stylesheet">

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/"><img class="logo" src="/resource/Kickstarter-logo-light.png"> </a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/category">Discover</a></li>
            </ul>
            <form class="navbar-form navbar-left" role="search" action="/search">
                <div class="form-group">
                    <input name="search_text" type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Search</button>
            </form>
            <ul class="nav navbar-nav navbar-right">

                <sec:authorize access="isAuthenticated()">
                    <li><a href="/profile"><sec:authentication property="principal.username" />
                        <sec:authorize access="isRememberMe()">
                            (by 'Remember me')
                        </sec:authorize>
                        <sec:authorize access="!isRememberMe()">
                            (by credentials)
                        </sec:authorize>
                    </a></li>
                    <li><a href="/logout">Log out</a></li>
                </sec:authorize>

                <sec:authorize access="!isAuthenticated()">
                    <li><a href="/registration">Sign up</a></li>
                    <li><a href="/login">Log in</a></li>
                </sec:authorize>

            </ul>
        </div>
    </div>
</nav>

