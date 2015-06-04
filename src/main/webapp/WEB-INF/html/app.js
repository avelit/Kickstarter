'use strict';

(function () {

    var app = angular.module('kickstarter', ['ngRoute']);

    app.config(['$routeProvider', '$locationProvider',

        function ($routeProvider, $locationProvider) {
            $routeProvider
                .when('/html', {templateUrl: '/html/categories.html',controller:'CategoryListCtrl'})
                .when('/html/category/:categoryId', {templateUrl: '/html/category.html',controller:'CategoryCtrl'})
                .otherwise({redirectTo: '/html'});

            $locationProvider.html5Mode({enabled: true, requireBase: false});

        }]);

    app.controller('CategoryListCtrl', function ($http) {
        var ctrl = this;
        ctrl.list = [];
        $http.get('/webapi/category').success(function (data) {
            ctrl.list = data;
        });
    });

    app.controller('CategoryCtrl', function ($http,$routeParams) {
        this.categoryId = $routeParams.categoryId;
        var ctrl = this;
        ctrl.projects = [];
        $http.get('/webapi/category/' + this.categoryId).success(function (data) {
            ctrl.name = data.name;
            ctrl.description = data.description;
        });
        $http.get('/webapi/category/' + this.categoryId + '/projects_list').success(function (data) {
            ctrl.projects = data;
        });
    });

    app.directive('navMenu',function(){
        return{
            restrict: 'E',
            templateUrl:'/html/header.html'
        }
    })

})();
