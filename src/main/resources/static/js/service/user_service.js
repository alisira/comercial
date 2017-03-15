'use strict';

App.factory('UserService', ['$http', '$q', function($http, $q){

	var userService = {};	
	var token = '';
	var user={id:null,username:null,authenticated:false,email:''};
	
	//Constructor de User
	function UserService(){
        //this.model = 'user-role';
    }
	
	
	/*createUser: function(user){
		return $http.post('http://localhost:8080/user/', user)
				.then(
						function(response){
							return response.data;
						}, 
						function(errResponse){
							console.error('Error while creating user');
							return $q.reject(errResponse);
						}
				);
	},
	
	userService.isAuthenticated = function(){		
		return $http.get('/token').then(
				function(response) {
					callback(response.data.token);
					//console.log(response);
					console.log(response.data.token);
					user.authenticated = true;
					return user.authenticated;
				});
		

	}*/
	
	userService.isAuthenticated = function(){
		return $http.get('/user').then(
				function(response){
					console.log(response);
					return response.data;
				},
				function(errResponse){
					//console.error('Error Autenticando: ');
					//console.error(errResponse);
					//console.error(errResponse.status);
					return $q.reject(errResponse);
					//return false;
				}
		);
	};
	
	userService.getToken = function(){
		//console.log('Entro:'+token);
		
		token = response.data.token;
		return token;
	}
	
	userService.getUserName = function(){
		console.log('Entro:'+user.username);
		return user.username;
	}

	userService.getPermission = function(callback){
		
		var param= {idUser:1};
		return $http.post('http://localhost:8080/user_permission/', param)
			.then(
				function(response){
					//console.log(response.data);
					callback(response.data);					
					//return response.data;
				}, 
				function(errResponse){
					console.error('Error while get user permission');
					return $q.reject(errResponse);
				}
		);
	}

	userService.authenticate = function(credentials, callback) {

		var headers = credentials ? {
			authorization : "Basic "
					+ btoa(credentials.username + ":"
							+ credentials.password)
		} : {};

		$http.get('user', {
			headers : headers
		}).then(function(response) {
			
			console.log(response);
			
			if (response.data.name) {
				user.authenticated = true;
			} else {
				user.authenticated = false;
			}
			callback();
		}, function() {
			user.authenticated = false;
			login(false);
		});

	}	

	self.logout = function() {
		$http.post('logout', {}).finally(function() {
			$rootScope.authenticated = false;
			$location.path("/");
		});
	}

    return userService;

}]);

