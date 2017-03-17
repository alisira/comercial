'use strict';

App.controller('LoginController', ['$http', '$location', '$route', '$scope', 'UserService', function($http, $location, $route, $scope, UserService) {	
	var self = this;

	self.tab = function(route) {
		//console.log($location);
		return $route.current && route === $route.current.controller;
	};

	self.credentials = {};
	self.login = function() {
		//console.log(self.credentials);
		
		UserService.authenticate(self.credentials, function() {
			
			
			UserService.isAuthenticated().then(
					function(response){
						//console.log("Login succeeded:"+response);
						$location.path("/home");
						self.error = false;				
						//UserService.getPermission(self.setPermission);
					}, 
					function(errResponse){
						console.log("Login failed:"+errResponse)
						$location.path("/login");
						self.error = true;
					}
				);
			
			
			/*if (UserService.isAuthenticated()) {
				console.log("Login succeeded")
				$location.path("/home");
				self.error = false;				
				//UserService.getPermission(self.setPermission);
				
				
			} else {
				console.log("Login failed")
				$location.path("/login");
				self.error = true;				
			}*/
			
			
		})
	};
	

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
