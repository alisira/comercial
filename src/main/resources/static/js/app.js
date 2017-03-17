'use strict';

var App = angular.module('myApp',['ngRoute']);


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
			
			$routeProvider
	        .when("/" +providerTemp + '/' + method, {
	            controller: ctr+'Controller'+method.charAt(0).toUpperCase()+ method.slice(1),
	            templateUrl: "html/"+providerTemp+ '/' + method+ ".html"
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
	
});
