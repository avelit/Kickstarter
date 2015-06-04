'use strict';

(function () {

    var app = angular.module('kickstarter', ['ngRoute']);

    app.config(['$routeProvider', '$locationProvider',

        function ($routeProvider, $locationProvider) {
            $routeProvider
                .when('/html', {templateUrl: '/html/categories.html',controller:'CategoryListCtrl'})
                .when('/html/category/:categoryId', {templateUrl: '/html/category.html',controller:'CategoryCtrl'})
                .when('/html/project/:projectId', {templateUrl: '/html/project.html',controller:'ProjectCtrl'})
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

    app.controller('ProjectCtrl', function ($http,$routeParams) {
        this.projectId = $routeParams.projectId;
        var ctrl = this;
        $http.get('/webapi/project/' + this.projectId).success(function (data) {
            ctrl.data = data;
        });
    });

    app.directive('navMenu',function(){
        return{
            restrict: 'E',
            templateUrl:'/html/header.html'
        }
    })

})();
