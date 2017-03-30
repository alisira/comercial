'use strict';

App.factory('UserService', ['$http', '$q', function($http, $q){

	var userService = {};	
	var token = '';
	var user={};
	
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
	
*/
	
	userService.isAuthenticated = function(){
		return $http.get('/user').then(
				function(response){					
					//console.log(response);
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
	
	userService.logout = function() {
		return $http.post('logout', {}).then(
				function(response){					
					user={};
					return true;
				},
				function(errResponse){
					//console.error('Error Autenticando: ');
					//console.error(errResponse);
					//console.error(errResponse.status);
					return $q.reject(errResponse);
					//return false;
				}
		);
		
	}
	
	
	userService.getToken = function(){
		//console.log('Entro:'+token);		
		token = response.data.token;
		return token;
	}
	
	
	userService.getUserName = function(callback){
		//console.log(user);
		
		 if (!user.userName){
			
			return userService.isAuthenticated().then(
				function(response){
					user = {};
					if (response){
						//console.log("No Nulo:" + response);
						
						user =  response.principal;
						user.authenticated = true;						
						callback(response.principal.userName);
						
					}else{
						//console.log("Nulo:" + response);
						user = {};
						user.authenticated = false;
						callback(null);
					}
					
					//user =  response.principal;
					//user.authenticated = true;
					//return user.userName;
					
				},
				function(errResponse){
					return $q.reject(errResponse);
				}
			);
			
		}else{
			//console.log('No Nulo');
			//console.log('Entro:'+user.userName);
			callback(user.userName);
		}
		
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

	
	
	userService.authenticate = function (){
		
		var self = this;
		
		var y = new userService.authenticate2();
		
		return y;
		
	}
	
	userService.authenticate2 = function (){

	    var self = this;
	    var thenCallback = null;

	    self.then = function(callback){
	    	//console.log(3);
	        thenCallback = callback;
	  
	    };

	    self.complete = function(credentials){
	    	//Debe ser una funcion asincrona obligatoriamente con un callback
			
			var headers = credentials ? {
				authorization : "Basic "
						+ btoa(credentials.username + ":"
								+ credentials.password)
			} : {};

			$http.get('user', {
				headers : headers
			}).then(function(response) {
				
				user = {};
				if (response.data) {
					user =  response.data.principal;
					user.authenticated = true; 
				} else {
					user = {};
					user.authenticated = false;
				}
				
				if (thenCallback && typeof thenCallback === 'function'){
		            //console.log(response.data);
					thenCallback(response.data);
		        }				

			}, function() {
				user.authenticated = false;
				login(false);
			});

	        return this;
	    };

	}
	
	


    return userService;

}]);

