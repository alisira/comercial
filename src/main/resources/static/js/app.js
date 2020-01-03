'use strict';

var App = angular.module('myApp',['ngAnimate', 'ui.router', 'ngSanitize', 'ui.bootstrap', 'comun']);



//http interceptor to handle redirection to login on 401 response from API
App.service('authInterceptor', function($q, $location) {
    var service = this;

    service.responseError = function(response) {
    	if (response.status == 401){
    		//console.log(response);	
    		return $location.path("/");
        }
        //return $q.reject(response);
    };
}).config(function($httpProvider) {
    $httpProvider.interceptors.push('authInterceptor');
});
