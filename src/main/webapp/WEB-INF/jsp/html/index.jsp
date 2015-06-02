<!doctype html>
<html lang="en" ng-app="kickstarter">
<head>
  <meta charset="utf-8">
  <title>Kickstarter</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div id="wrapper">
  <div class="container">
    <div ng-controller="CategoryListCtrl as categories">
      <div class="row">
        <div class="col-sm-6 col-md-3" ng-repeat="category in categories.list">
          <a href="/category/{{category.id}}">{{category.name}}</a>
        </div>
      </div>
    </div>
  </div>
</div>

<script src="/html/angular.js"></script>
<script src="/html/angular-route.min.js"></script>
<script src="/html/app.js"></script>
</body>
</html>

