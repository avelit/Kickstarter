<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
  <title><c:out value="${project.name}"/></title>
  <link href="/css/bootstrap.min.css" rel="stylesheet">
  <link href="/css/signin.css" rel="stylesheet">
  <script
    src="/js/jquery.min.js"></script>
  <script
    src="/js/bootstrap.min.js"></script>

    <script>$(document).ready(function () {
        /* Automagically jump on good tab based on anchor; for page reloads or links */
        if (location.hash) {
            $('a[href=' + location.hash + ']').tab('show');
        }
    })
    </script>
</head>
<body>
<div class="wrapper">
    <%@include file='header.jsp' %>
    <div class="container">

        <h3>
            Category:
            <a href="/category/<c:out value="${category.id}"/>"><c:out
                    value="${category.name}"/></a>
            <br>
            Project name:
            <c:out value="${project.name}"/>
        </h3>
<c:choose>
  <c:when test="${project.video == null}">
  </c:when>
  <c:when test="${project.video.isEmpty()}">
  </c:when>
  <c:otherwise>
      <iframe width="560" height="315" src="${project.video}"/>" frameborder="0" allowfullscreen></iframe>
  </c:otherwise>
</c:choose>
        <div role="tabpanel">
            <ul class="nav nav-tabs" role="tablist" id="tabs">
                <li role="presentation" class="active"><a href="#project"
                                                          aria-controls="project"
                                                          role="tab"
                                                          data-toggle="tab">Project</a>
                </li>
                <li role="presentation"><a href="#comments"
                                           aria-controls="comments" role="tab"
                                           data-toggle="tab">Comments</a></li>
                <li role="presentation"><a href="#blogposts"
                                           aria-controls="blogposts" role="tab"
                                           data-toggle="tab">Blog Posts</a></li>
            </ul>
        </div>

        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="project">
                <div class="col-md-12">

                    <br> Description:
                    <c:out value="${project.description}"/>

                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="comments">
                <div class="col-md-12">
                    <br>Comments:
                    <table class="table">
                        <c:forEach var="c" items="${comments}">
                            <tr>
                                <td><c:out
                                        value="${c.createdSimpleFormat}"/></td>
                                <td><c:out value="${c.text}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <div>
                        <form action="/comment/add" method="post">
                            <input type="text" name="text"/>
                            <input type="hidden" name="project_id"
                                   value="<c:out value="${project.id}"/>"/>
                            <input type="hidden" name="category"
                                   value="<c:out value="${category_name}"/>"/>
                            <input class="btn btn-default" type="submit" value="add comment"/>
                        </form>
                    </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="blogposts">
                <div class="col-md-12">
                    <br>Blog:
                    <table class="table">
                        <c:forEach var="blog" items="${blogs}">
                            <tr>
                                <td><c:out
                                        value="${blog.createdSimpleFormat}"/></td>
                                <td><c:out value="${blog.text}"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <br>
                    <div>
                        <c:if test="${showAddBlog}">
                            <form action="/blogpost/add" method="post">
                                <input type="text" name="text"/>
                                <input type="hidden" name="project"
                                       value="<c:out value="${project.name}"/>"/>
                                <input
                                        type="hidden" name="category"
                                        value="<c:out value="${category_name}"/>"/>
                                <input type="hidden" name="project_id"
                                       value="<c:out value="${project.id}"/>"/>
                                <input
                                        class="btn btn-default" type="submit" value="add post"/>
                            </form>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file='footer.jsp' %>
</body>
</html>
