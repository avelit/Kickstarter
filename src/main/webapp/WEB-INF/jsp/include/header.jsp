<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header>
  <div class="navbar navbar-default navbar-static-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/"><span>Go</span>java 3.2</a>
      </div>
      <form class="navbar-form navbar-left" role="search" action="/search">
        <div class="form-group">
          <input name="search_text" type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Search</button>
      </form>

      <div class="navbar-collapse collapse ">
        <ul class="nav navbar-nav">

          <li class="active"><a href="/">Home</a></li>
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
  </div>
</header>