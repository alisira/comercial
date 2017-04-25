'use strict';

App.controller('LoginController', ['$http', '$location', '$scope', '$rootScope', 'UserService', 'ErrorService', function($http, $location, $scope, $rootScope, UserService, ErrorService) {	
	var self = $scope;
	$scope.userAuth = false;
	self.credentials = {};
	
	$scope.login = function() {

		UserService.authenticate(self.credentials).then(
			function(response){
				//console.log(response);					
				if (response){
					$scope.userAuth = true;
					$location.path("/home");
				}else{
					//console.log("Usuario no Autorizado:"+response)
					response = "Usuario no Autorizado";					
					//console.log("Usuario no Autorizado:"+response);
					$location.path("/login");
					$scope.userAuth = false;
					$scope.error(response.data.error);
					ErrorService.setFormError(response);
				}


			}, 
			function(errResponse){
				$location.path("/login");
				//console.log(errResponse);
				ErrorService.setFormError(errResponse);
				$scope.userAuth = false;

			}
		);

	};

	$scope.init = function() {

		UserService.isAuthenticated().then(
			function(response){	

				if (response){
					$scope.userAuth = true;
					//console.log('ir al home');
					$location.path("/home");
				}else{
					//console.log('ir a login sin error');
					$location.path("/login");
				}
			},
			function(errResponse){
				console.log('ir a login');
				$location.path("/login");
			}
		);
    };

    $scope.init();
	

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
