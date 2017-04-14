'use strict';

App.controller('HomeController', ['$http', '$location', '$route', '$scope', '$rootScope', 'UserService', function($http, $location, $route, $scope, $rootScope, UserService) {
	
	$scope.appTitle = "Acceso Principal";
	
	$scope.authenticate = function() {

		UserService.isAuthenticated().then(
				function(response){										
					if (response) {
						UserService.getPermission($scope.setPermission);
						$scope.error = false;						
						$scope.getUserName();						
						
					}else{
						//$location.path("/login");
						//console.log('esta ejecuta');
						$scope.error = true;
						
					}
				}, 
				function(errResponse){
					//$location.path("/login");
					//console.log('o  es este');
					$scope.error = true;
				}
		);

	};
	
	$scope.setPermission = function(respuesta) {
		$rootScope.permission = respuesta.permisos;
		//console.log($rootScope.permission);
	}

	$scope.getUserName = function() {
		UserService.getUserName(function(resp) {
			$rootScope.userName = resp;
		});
	}
	

	$scope.logout = function() {

		UserService.logout().then(
				function(response){										

					$rootScope.permission = null;
					$rootScope.userName =  null;
					$rootScope.authenticated = false;
					$scope.error = false;
					$location.path("/");

				}, 
				function(errResponse){
					$location.path("/");
					$scope.error = true;
				}
		);
		
		
	}
	
	$scope.closeErrors = function() {
		$rootScope.errors = null;
	}
	
	$scope.authenticate();
	
	
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
      			//$scope.greeting = response.data;
      			console.log(response.data);
      			
      		});
      	})*/
          

}]);
