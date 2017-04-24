'use strict';

App.controller('HomeController', function($http, $location, $state, $scope, $rootScope, UserService, $stateParams, ErrorService) {
	
	$scope.appTitle = "Acceso Principal";
	
	//Cada vez q se cambia de vista se ejecuta esta funcion
	$scope.tab = function(route) {

		 //console.log($attrs);
		var temp = $state.current.url.split("/")[1];
		if ($state.current.url.split("/")[1]  == route)
			return true
		else
			return false;

	};

	$scope.isAuthenticated = function() {

		UserService.isAuthenticated().then(
				function(response){
					//console.log(response);
					if (response) {
						console.log(1);
						UserService.getPermission($scope.setPermission);
						$scope.error = false;
						$scope.getUserName();

					}else{
						console.log(2);
						$location.path("/login");//Enviar a Login solo en caso de no querer mostrar el home
						//console.log('esta ejecuta');

					}
				}, 
				function(errResponse){
					console.log(errResponse);
					$location.path("/login");

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
					$location.path("/");

				}, 
				function(errResponse){
					$location.path("/");
				}
		);
		
		
	}
	
	$scope.closeErrors = function() {		
		ErrorService.resetErrors();
	}
	
	$scope.isAuthenticated();

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
          

});

