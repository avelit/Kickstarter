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
        <div class="col-sm-3">
            <h3>Admin menu</h3>
            <hr>
            <ul class="nav nav-stacked">
                <li><a href="/admin/edit_category"><h4>Add category</h4></a>
                </li>
                <li><a href="/admin/edit_project"><h4>Add project</h4></a>
                </li>
                <li><a href="/change_password?token=${token}&email=${email}"><h4>Change password</h4></a></li>
            </ul>
        </div>
        <h3>Your projects:</h3>

        <div class="col-sm-9">
            <c:forEach var="c" items="${projects}">
                <div class="row">
                    <div class="thumbnail">
                            <div class="caption">
                                <h3>
                                    <a href="/project/<c:out value="${c.id}"/>"><c:out
                                            value="${c.name}, category ${c.category.name}"/></a>
                                    <form>
                                    <button class="btn btn-xs btn-primary"
                                            formmethod="get"
                                            formaction="/project/<c:out value="${c.id}"/>/edit"
                                            type="submit">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                    <button class="btn btn-xs btn-danger"
                                            formmethod="post"
                                            formaction="/project/<c:out value="${c.id}"/>/delete"
                                            type="submit">
                                        <span class="glyphicon glyphicon-trash"></span>
                                    </button>
                                    </form>
                                </h3>
                            </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <%-- /CONTENT --%>
    </div>
    <%@include file='include/footer.jsp' %>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
<%@include file='include/bottom_scripts.jsp' %>
</body>
</html>