'use strict';

(function () {

    var app = angular.module('kickstarter', ['ngRoute']);

    //app.config(['$routeProvider', '$locationProvider',
    //
    //    function ($routeProvider, $locationProvider) {
    //        $routeProvider
    //            .when('/html', {templateUrl: '/html/index.html'})
    //            .when('/html/category/:categoryId', {templateUrl: '/html/category.html'});
    //
    //        $locationProvider.html5Mode({enabled: true, requireBase: false});
    //
    //    }]);

    app.controller('CategoryListCtrl', ['$http', function ($http) {
        var ctrl = this;
        ctrl.list = [];
        $http.get('/webapi/category').success(function (data) {
            ctrl.list = data;
        });
    }]);

    app.directive('navMenu',function(){
        return{
            restrict: 'E',
            templateUrl:'/html/header.html'
        }
    })

})();
