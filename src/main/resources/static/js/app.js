'use strict';

var App = angular.module('myApp',['ngRoute','ngAnimate']);


App.config(function($routeProvider, $httpProvider){
	
	//console.log($httpProvider);	
	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
	
	var aryProvider = ['admin_product',
		'admin_color',
		'admin_offer',
		'admin_discount',
		'admin_category',
		'admin_enviroment',
		'admin_user',
		'admin_order',
		'admin_store',
		'admin_ship_cost',
		'admin_report'
	];
	
	for (var i in aryProvider){
		
		var ctrTemp = aryProvider[i].split("_");
		var ctr = "";
		
		for (var c in ctrTemp){
			ctr += ctrTemp[c].charAt(0).toUpperCase()+ ctrTemp[c].slice(1);
		}
		
		var providerTemp =  aryProvider[i];
		
		var aryMethod = ['index', 'list', 'new', 'view', 'edit', 'delete'];
		for (var x in aryMethod) {
			var method = aryMethod[x];
			
			var url='';
			var templateUrl ='';
			
			switch (method) {
	        
		        case 'index':
		          //url = '/' + provider + '?search';
		          //url = '/' + provider + '/' + method;
		          url = '/' + providerTemp + '/' + method
		          templateUrl = 'html/' + providerTemp+ '/list.html';
		          break;
		        case 'menu':
		          //url = '/' + provider + '/' + method;
		          break;
		        case 'search':
		          //url = '/' + provider + '/' + method + '?item';
		          break;
		        case 'member':
		          //url = '/' + provider + '/' + method;
		          break;
		        case 'list':
		          url = '/' + providerTemp + '/' + method;
		          templateUrl = 'html/' + providerTemp+ '/' + method + '.html'
		          break;
		        case 'view':
		          url = '/' + providerTemp + '/view/:id';
		          templateUrl = 'html/' + providerTemp+ '/' + method + '.html'
		          break;
		        case 'new':
		          //url = '/' + provider + '/' + method;
		        	url = '/' + providerTemp + '/new';
			        templateUrl = 'html/' + providerTemp+ '/' + method + '.html';
		          break;
		        case 'edit':
		          //url = '/' + provider + '/' + method + '/:id';
		          break;
		        case 'delete':
		          //url = '/' + provider + '/' + method + '/:id';
		          break;
	      }
			
			//console.log(providerTemp + '->' +  'url:' + url + '- templateUrl:' + templateUrl);
			
			
			
			$routeProvider
	        .when(url, {
	            controller: ctr+'Controller'+method.charAt(0).toUpperCase()+ method.slice(1),
	            templateUrl: templateUrl
	        });
			
			//console.log(providerTemp + ":" + ctr + ":" + "html/"+providerTemp+ '/' + method+ ".html");
			//console.log(ctr+'Controller'+method.charAt(0).toUpperCase()+ method.slice(1));
		}
		
	}
	
	
	$routeProvider
    .when("/", {
    	controller : 'HomeController',    
		templateUrl : 'html/home.html',
		controllerAs: "controller"
    }).when("/home", {
    	controller : 'HomeController',    
		templateUrl : 'html/home.html',
		controllerAs: "controller"
    }).when('/login', {
    	controller : 'LoginController',    
		templateUrl : 'html/login.html',
		controllerAs: "controller"
    });
	
	
	$routeProvider.otherwise({
        controller: "Test2",
        controllerAs: "test2",
        template: "<h1>En el Otherwise</h1>"
    });
	
}).config(function($httpProvider) {
    $httpProvider.interceptors.push('httpResponseInterceptor');
});



//http interceptor to handle redirection to login on 401 response from API
App.factory('httpResponseInterceptor', ['$q', '$rootScope', '$location', function($q, $rootScope, $location) {
    return {
    	
    	response: function(resp) {
    		//console.log(rejection);
    		
            /*if (resp.status === 401) {
                // Something like below:
            	console.log('111');
                $location.path('/login');
            }*/
            return resp;
        },    	
    
        responseError: function(rejection) {
            if (rejection.status === 401) {                
                $location.path('/login');
            }
            return rejection;
        }
    };
}]);
