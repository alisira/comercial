'use strict';

var App = angular.module('myApp',['ngAnimate', 'ui.router']);


App.config(function($httpProvider, $stateProvider, $urlRouterProvider){
	
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
	
	//var c=0;
	for (var i in aryProvider){
		
		var ctrTemp = aryProvider[i].split("_");
		var ctr = "";
		
		//converts admin_color to AdminColor
		for (var c in ctrTemp){
			ctr += ctrTemp[c].charAt(0).toUpperCase()+ ctrTemp[c].slice(1);
		}
		
		var providerTemp =  aryProvider[i];
		
		var aryMethod = ['index', 'list', 'new', 'view', 'edit'];
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
		        	url = '/' + providerTemp + '/edit/:id';
		        	templateUrl = 'html/' + providerTemp+ '/' + method + '.html'
		        	//url = '/' + provider + '/' + method + '/:id';
		          break;
		        case 'delete':
		        	url = '/' + providerTemp + '/delete/:id';
		        	templateUrl = null;
		          break;
			}
			
			//console.log(providerTemp + '->' +  'url:' + url + '- templateUrl:' + templateUrl + "- ctr:" + ctr+'Controller'+method.charAt(0).toUpperCase()+ method.slice(1));
			
			$stateProvider.state(ctr+'Controller'+method.charAt(0).toUpperCase()+ method.slice(1), {
		        url: url,
		        views:{
                    "mainView":{
                         templateUrl: templateUrl,
                         controller: ctr+'Controller'+method.charAt(0).toUpperCase()+ method.slice(1)
                    },
                    "menu": {
                        templateUrl: "html/navigation.html",
                        controller: 'HomeController'
                    }
		        
		        } 
		      });
			
			//console.log(url + ":" + ctr + ":" + "html/"+providerTemp+ '/' + method+ ".html");
			//console.log(ctr+'Controller'+method.charAt(0).toUpperCase()+ method.slice(1));
		}
		//c++;
	}
	
	$urlRouterProvider.otherwise('/home');
	
	$stateProvider
		.state('Principal', {
			url: "/",
			views:{
                "mainView":{
                	templateUrl: 'html/home.html',
        			controller: 'HomeController'
                },
                "menu": {
                    templateUrl: "html/navigation.html",
                    controller: 'HomeController'
                }     
	        }
		})
		.state('Home', {
			url: "/home",
			views:{
                "mainView":{
                	templateUrl: 'html/home.html',
        			controller: 'HomeController'
                },
                "menu": {

                    templateUrl: "html/navigation.html",
                    controller: 'HomeController'
                }	        
	        }
			
        })
        .state('LoginController', {
        	url: "/login",
        	views:{
                "mainView":{
                	templateUrl: 'html/login.html',
                    controller: 'LoginController'
                },
                "menu": {
                    templateUrl: "html/navigation.html",
                    controller: 'HomeController'
                }	        
	        }        	
        	
        })
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});



//http interceptor to handle redirection to login on 401 response from API
App.service('authInterceptor', function($q, $location) {
    var service = this;

    service.responseError = function(response) {
        
    	if (response.status == 401){
    		console.log(response);	
    		return $location.path("/");
        }
        //return $q.reject(response);
    };
}).config(function($httpProvider) {
    $httpProvider.interceptors.push('authInterceptor');
});
