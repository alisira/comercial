'use strict';

App.factory('CategoryService', ['$http', '$q', function($http, $q){

	var model = 'category';
	var categoryService = {};
	
	//Constructor de CategoryService
	function CategoryService(){
        var model = 'category';
        console.log(model);
    }
	
	categoryService.count = function(){		

		//console.log(model);

		return $http.get(model+'/count/').then(
				function(response){					
					return response.data;
				},
				function(errResponse){
					return $q.reject(errResponse);
				}
		);
	};
	
	categoryService.findAll = function(){

		return $http.get(model+'/').then(
				function(response){
					if (response.status == 500)
						return $q.reject(response);
					else
						return response.data;
				},
				function(errResponse){
					return $q.reject(errResponse);
				}
		);
	};	
	
	/*userService.logout = function() {
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

	userService.authenticate = function(credentials, callback) {

		var headers = credentials ? {
			authorization : "Basic "
					+ btoa(credentials.username + ":"
							+ credentials.password)
		} : {};

		$http.get('user', {
			headers : headers
		}).then(function(response) {
			
			//console.log(response);
			user = {};
			if (response.data) {
				user =  response.data.principal;
				user.authenticated = true;
				//console.log(user);
			} else {
				user = {};
				user.authenticated = false;
			}
			callback();
		}, function() {
			user.authenticated = false;
			login(false);
		});

	}*/

    return categoryService;

}]);

