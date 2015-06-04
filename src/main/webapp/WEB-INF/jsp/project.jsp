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
        <div class="wrapper">
            <div class="container">

                <h3>
                    Category:
                    <a href="/category/<c:out value="${category.id}"/>"><c:out
                            value="${category.name}"/></a>
                    <br>
                    Project name:
                    <c:out value="${project.name}"/>
                </h3>
                <div>
                    <img src="/image/${project.id}" alt="No picture"/>
                    <br>
                    <br>
                </div>

                <c:choose>
                    <c:when test="${project.video == null}">
                    </c:when>
                    <c:when test="${project.video.isEmpty()}">
                    </c:when>
                    <c:otherwise>
                        <iframe width="560" height="315" src="${project.video}"/>
                        " frameborder="0" allowfullscreen></iframe>
                        <div><br></div>
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
                            <br>
                            ${project.description}

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
                                    <input type="text" name="text" required/>
                                    <input type="hidden" name="project_id"
                                           value="<c:out value="${project.id}"/>"/>
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
                                        <input type="text" name="text" required/>
                                        <input type="hidden" name="project"
                                               value="<c:out value="${project.name}"/>"/>
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
        <%-- /CONTENT --%>
    </div>
    <%@include file='include/footer.jsp' %>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
<%@include file='include/bottom_scripts.jsp' %>
</body>
</html>
