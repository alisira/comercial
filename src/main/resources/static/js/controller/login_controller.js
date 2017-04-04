'use strict';

App.controller('LoginController', ['$http', '$location', '$route', '$scope', 'UserService', function($http, $location, $route, $scope, UserService) {	
	var self = $scope;

	self.tab = function(route) {
		//console.log($location);
		return $route.current && route === $route.current.controller;
	};

	self.credentials = {};
	$scope.login = function() {
		//console.log(self.credentials);
		var autentication = UserService.authenticate();
		//console.log(autentication);
		autentication.complete(self.credentials).then(
			function(response){
				//console.log(response);					
				if (response){
					$location.path("/home");
					self.error = false;	
				}else{
					//console.log("Usuario no Autorizado:"+response)
					$location.path("/login");
					$scope.userNoAuth = true
					self.error = true;	
				}
				
				//UserService.getPermission(self.setPermission);
			}, 
			function(errResponse){
				console.log("Login failed:"+errResponse)
				$location.path("/login");
				self.error = true;
			}
		);
		//console.log(445566);
		
	};
	

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
