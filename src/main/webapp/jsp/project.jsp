<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
  <title><c:out value="${project.name}"/></title>
  <%@include file='header.jsp' %>
  <link href="/css/bootstrap.min.css" rel="stylesheet">
  <link href="/css/signin.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <div class="category-container">
    <h3>
      Project name:
      <c:out value="${project.name}"/>
      <br> Category:
      <c:out value="${category_name}"/>
    </h3>


    <div class="row">
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
