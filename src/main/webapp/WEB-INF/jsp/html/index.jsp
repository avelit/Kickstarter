<!doctype html>
<html lang="en" ng-app="kickstarter">
<head>
  <meta charset="utf-8">
  <title>Kickstarter</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
  <title>Kickstarter</title>
  <%@include file='/WEB-INF/jsp/include/head.jsp' %>
</head>
<body>
<%@include file='/WEB-INF/jsp/include/header.jsp' %>
<div ng-view></div>
<%@include file='/WEB-INF/jsp/include/footer.jsp' %>
<script src="/html/angular.js"></script>
<script src="/html/angular-route.min.js"></script>
<script src="/html/app.js"></script>
</body>
</html>

