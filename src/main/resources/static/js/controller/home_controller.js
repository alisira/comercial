'use strict';

App.controller('HomeController', ['$http', '$location', '$route', '$scope', '$rootScope', 'UserService', function($http, $location, $route, $scope, $rootScope, UserService) {
	var self = this;
	self.appTitle = "Acceso Principal"
	
	self.authenticate = function() {

		UserService.isAuthenticated().then(
				function(response){										
					if (response) {
						UserService.getPermission(self.setPermission);
						self.error = false;	
					}else{
						$location.path("/login");
						self.error = true;
					}
				}, 
				function(errResponse){
					$location.path("/login");
					self.error = true;
				}
		);

	};
	
	self.setPermission = function(respuesta) {

		$rootScope.permission = respuesta.permisos;
		
		console.log($rootScope.permission);
		
	}
	
	self.authenticate();
	
	
	
      	/*
      	$http.get('/resource/').then(function(response) {
      		//console.log(response);
      		self.greeting = response.data;
      	})
      	
      	
      	$http.get('/token').then(function(response) {
      		
      		//console.log(response);
      		console.log(response.data.token);
      		
      		/*$http({
      			url : 'http://localhost:8080',
      			method : 'GET',
      			headers : {
      				'X-Auth-Token' : response.data.token
      			}
      		}).then(function(response) {
      			//self.greeting = response.data;
      			console.log(response.data);
      			
      		});
      	})*/
          

}]);
