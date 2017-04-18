'use strict';

App.controller('HomeController', function($http, $location, $state, $scope, $rootScope, UserService, $stateParams) {
	
	$scope.appTitle = "Acceso Principal";
	$rootScope.errors = '';		
	
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
					if (response) {
						UserService.getPermission($scope.setPermission);
						$scope.error = false;						
						$scope.getUserName();						
						
					}else{
						$location.path("/login");//Enviar a Login solo en caso de no querer mostrar el home
						//console.log('esta ejecuta');
						$scope.error = true;
						
					}
				}, 
				function(errResponse){
					$location.path("/login");
					//console.log('o  es este');					
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
		$rootScope.errors = '';
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

