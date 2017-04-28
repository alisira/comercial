'use strict';

App.controller('HomeController', function($http, $location, $state, $scope, UserService, $stateParams, ErrorService, MessageService) {
	
	$scope.appTitle = "Acceso Principal";

	$scope.tab = function(route) {

		//console.log(route);
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
						//console.log(1);
						UserService.getPermission($scope.setPermission);
						$scope.error = false;
						$scope.getUserName();

					}else{
						//console.log(2);
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
		$scope.permission = respuesta.permisos;
	}

	$scope.getUserName = function() {
		UserService.getUserName(function(resp) {
			$scope.userName = resp;
		});
	}
	

	$scope.logout = function() {

		UserService.logout().then(
				function(response){

					$scope.permission = null;
					$scope.userName =  null;
					$scope.authenticated = false;
					$location.path("/");

				}, 
				function(errResponse){
					$location.path("/");
				}
		);


	}

	$scope.resetMessage = function() {
		ErrorService.resetErrors();
		MessageService.resetMessages();
	}

	$scope.resetMessage();
	$scope.isAuthenticated();

      	/*
      	$http.get('/token').then(function(response) {
      		
      		//console.log(response);
      		console.log(response.data.token);
      		
      		/*$http({
      			url : '/',
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

