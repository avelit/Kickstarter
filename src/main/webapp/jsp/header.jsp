<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="/css/header.css" rel="stylesheet">

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/"><img class="logo" src="/resource/Kickstarter-logo-light.png"> </a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/categories/">Discover</a></li>
            </ul>
            <form class="navbar-form navbar-left" role="search" action="/search">
                <div class="form-group">
                    <input name="search_text" type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Search</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/registration_page">Sign up</a></li>
                <li><a href="/login_page">Log in</a></li>
            </ul>
        </div>
    </div>
</nav>

