<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to our website!</title>
    <link href="/resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resource/css/signin.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script
            src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="wrapper" id="wrapper">
    <%@include file='header.jsp' %>
    <div class="container">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="3000">
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
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
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    </div>




<div class="container">
<h4>Categories</h4>
<hr>
<dl>
    <c:forEach var="c" items="${categories}">
                 <dt><a href="/category/<c:out value="${c.id}"/>"><h4><c:out value="${c.name}"/></h4></a></dt>
    </c:forEach>
</dl>
</div>
</div>

<%@include file='footer.jsp' %>

</body>
</html>