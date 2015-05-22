<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit project</title>
    <link href="/css/signin.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="wrapper">
    <%@include file='header.jsp' %>
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <h1>Add project:</h1>
                <hr>
                <form name="add_project" action="/project/add" method="post">

                    <c:choose>
                        <c:when test="${project == null}">
                            <input type="hidden" name="project_id" value="">
                            <h4>Category:</h4>
                            <select name="category_id" class="form-control">
                                <c:forEach var="category" items="${categories}">
                                    <option value="<c:out value="${category.id}"/>">
                                        <c:out value="${category.name}"/></option>
                                </c:forEach>
                            </select>

                            <h4>Project name: </h4>
                            <input type="text" name="project_name" class="form-control"
                                   placeholder="Name" width="30%">

                            <h4>Description:</h4>
                            <input type="text" name="project_description"
                                   class="form-control" placeholder="Description"
                                   width="30%">
                            <br>
                            <h4>Video:</h4>
                            <input type="text" name="video_url"
                                   class="form-control" placeholder="Link to video"
                                   width="30%">
                        </c:when>
                        <c:otherwise>
                            <input type="hidden" name="project_id" value="<c:out value="${project.id}"/>">
                            <h4>Category:</h4>
                            <select name="category_id" class="form-control">
                                <c:forEach var="category" items="${categories}">
                                    <option value="<c:out value="${category.id}" />">
                                        <c:out value="${category.name}"/></option>
                                </c:forEach>
                            </select>

                            <h4>Project name: </h4>
                            <input type="text" name="project_name" class="form-control"
                                   placeholder="Name" width="30%" value="<c:out value="${project.name}"/>">

                            <h4>Description:</h4>
                            <input type="text" name="project_description"
                                   class="form-control" placeholder="Description"
                                   width="30%" value="<c:out value="${project.description}"/>">
                            <br>
                            <h4>Video:</h4>
                            <input type="text" name="video_url"
                                   class="form-control" placeholder="Link to video"
                                   width="30%" value="<c:out value="${project.video}"/>">
                        </c:otherwise>
                    </c:choose>
                    <br>
                    <input type="submit" class="btn btn-success" value="Submit">
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file='footer.jsp' %>
</body>
</html>
