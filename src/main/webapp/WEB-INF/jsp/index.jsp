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
            <%--<%@include file='include/slide_bar.jsp' %>--%>

            <div class="row">
                <div class="col-md-2">
                    <div class="container url">
                        <div class="col-sm-3">
                            <h5>
                                <b><a href="/category">Categories</a></b>
                            </h5>
                            <hr>
                            <ul class="nav nav-stacked url">
                                <c:forEach var="c" items="${categories}">
                                    <li><a href="/category/${c.id}">
                                        <h5>
                                            <center><c:out value="${c.shortName}"/></center>
                                        </h5>
                                    </a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-10">
                    <div class="container">
                        <div id="carousel-example-generic" class="carousel slide"
                             data-ride="carousel" data-interval="3000">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic"
                                    data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic"
                                    data-slide-to="1"></li>
                            </ol>

                            <div class="carousel-inner" role="listbox">
                                <div class="item active">
                                    <img src="http://mcstore.ru/images/brimg_srchttpfdstarcomfdedatas200810211224573609music-not.gif"
                                         height="50" width="100%" alt="not found">

                                    <div class="carousel-caption">
                                        <p>Musical project 1

                                        <p><a class="btn btn-danger" href="/project/1">
                                            View project
                                        </a>
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="https://g-a.d-cd.net/24b150cs-960.jpg"
                                         height="50" width="100%" alt="not found">

                                    <div class="carousel-caption">
                                        <p>Musical testproject 2

                                        <p><a class="btn btn-danger" href="/project/22">
                                            View project
                                        </a>
                                    </div>
                                </div>
                            </div>

                            <!-- Controls -->
                            <a class="left carousel-control"
                               href="#carousel-example-generic" role="button"
                               data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"
                              aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="right carousel-control"
                               href="#carousel-example-generic" role="button"
                               data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"
                              aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
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