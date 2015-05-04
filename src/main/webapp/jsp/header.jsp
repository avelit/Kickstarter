<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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

<!--
 <script>
  (function() {
    var cx = '014356314791577599297:apyzhozly5e';
    var gcse = document.createElement('script');
    gcse.type = 'text/javascript';
    gcse.async = true;
    gcse.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') +
        '//cse.google.com/cse.js?cx=' + cx;
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(gcse, s);
  })();
</script>
<div width:150px><gcse:search></gcse:search></div>
-->
            <form class="navbar-form navbar-left" role="search" action="/search">
                <div class="form-group">
                    <input name="search_text" type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Search</button>
            </form>


            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${user == null}">
                        <li><a href="/registration_page">Sign up</a></li>
                        <li><a href="/login_page">Log in</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/profile"><c:out value="${user.name}" /></a></li>
                        <li><a href="/logout">Log out</a></li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
    </div>
</nav>

