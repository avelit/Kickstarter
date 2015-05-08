<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
  <title><c:out value="${project.name}"/></title>
  <%@include file='header.jsp' %>
  <link href="/css/bootstrap.min.css" rel="stylesheet">
  <link href="/css/signin.css" rel="stylesheet">
  <script
    src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
  <script
    src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

  <script>$(document).ready(function () {
    /* Automagically jump on good tab based on anchor; for page reloads or links */
    if (location.hash) {
      $('a[href=' + location.hash + ']').tab('show');
    }
  })
  </script>
</head>
<body>
<div class="container">

  <h3>
    Category:
    <a href="/category/<c:out value="${category.id}"/>" ><c:out value="${category.name}"/></a>
    <br>
    Project name:
    <c:out value="${project.name}"/>
  </h3>


  <div role="tabpanel">
    <ul class="nav nav-tabs" role="tablist" id="tabs">
      <li role="presentation" class="active"><a href="#project" aria-controls="project"
                                                role="tab" data-toggle="tab">Project</a>
      </li>
      <li role="presentation"><a href="#comments" aria-controls="comments" role="tab"
                                 data-toggle="tab">Comments</a></li>
      <li role="presentation"><a href="#blogposts" aria-controls="blogposts" role="tab"
                                 data-toggle="tab">Blog Posts</a></li>
    </ul>
  </div>


  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="project">
      <div class="col-md-6">
        Project name:
        <c:out value="${project.name}"/>
        <br> Category:
        <c:out value="${category.name}"/>
      </div>
    </div>

    <div role="tabpanel" class="tab-pane" id="comments">
      <div class="col-md-6">
        <br>Comments:
        <c:forEach var="c" items="${comments}">
          <div class="comments">
            <c:out value="${c}"/>
          </div>
        </c:forEach>
        <br>

        <div>
          <form action="/categories/addProjectComment" method="post">
            <input type="text" name="comment"/>
            <input type="hidden" name="project_id"
                   value="<c:out value="${project.id}"/>"/>
            <input type="hidden" name="category"
                   value="<c:out value="${category_name}"/>"/>
            <input class="btn btn-default" type="submit" title="add comment"/>
          </form>
        </div>
      </div>

    </div>

    <div role="tabpanel" class="tab-pane" id="blogposts">
      <div class="col-md-6">
        <br>Blog:
        <c:forEach var="c" items="${blogs}">
          <div class="comments">
            <c:out value="${c}"/>
          </div>
        </c:forEach>
        <br>

        <div>
          <form action="/categories/addProjectBlog" method="post">
            <input type="text" name="comment"/> <input type="hidden"
                                                       name="project"
                                                       value="<c:out value="${project.name}"/>"/>
            <input
              type="hidden" name="category"
              value="<c:out value="${category_name}"/>"/> <input
            class="btn btn-default" type="submit" title="add comment"/>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
