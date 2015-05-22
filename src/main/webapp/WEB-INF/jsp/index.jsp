<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to our website!</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/signin.css" rel="stylesheet">
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="wrapper">
    <%@include file='header.jsp' %>
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="3000">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="http://cdn.pocket-lint.com/r/s/728x/images/dynamic/NEWS-34448-c74454d5269e294909a8e0c638a6a0ee.jpg"
                     height="50" width="100%" alt="not found">

                <div class="carousel-caption">
                    pic
                </div>
            </div>
            <div class="item">
                <img src="http://cdn.pocket-lint.com/r/s/728x/images/dynamic/NEWS-34448-e428785dd06ad453e403af71900ada23.jpg"
                     height="50" width="100%" alt="not found">

                <div class="carousel-caption">
                    one more pic
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
<%@include file='footer.jsp' %>
</body>
</html>