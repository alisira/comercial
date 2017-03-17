'use strict';

App.controller('HomeController', ['$http', '$location', '$route', '$scope', '$rootScope', 'UserService', function($http, $location, $route, $scope, $rootScope, UserService) {
	var self = this;
	self.appTitle = "Acceso Principal";
	
	self.authenticate = function() {

		UserService.isAuthenticated().then(
				function(response){										
					if (response) {
						UserService.getPermission(self.setPermission);
						self.error = false;						
						self.getUserName();						
						
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
		//console.log($rootScope.permission);
	}

	self.getUserName = function() {
		UserService.getUserName(function(resp) {
			$rootScope.userName = resp;
		});
	}
	

	self.logout = function() {

		UserService.logout().then(
				function(response){										

					$rootScope.permission = null;
					$rootScope.userName =  null;
					$rootScope.authenticated = false;
					self.error = false;
					$location.path("/");

				}, 
				function(errResponse){
					$location.path("/");
					self.error = true;
				}
		);
		
		
	}
	
	
	self.authenticate();
	
	
	
      	/*
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
