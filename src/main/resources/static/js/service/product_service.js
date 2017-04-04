'use strict';

App.factory('ProductService', ['$http', '$q', function($http, $q){

	var model = 'product';
	var productService = {};
	
	//Constructor de ProductService
	function ProductService(){
        var model = 'product';
        console.log(model);
    }
	
	productService.count = function(){
		
		return $http.get(model+'/count/').then(
				function(response){					
					return response.data;
				},
				function(errResponse){
					return $q.reject(errResponse);
				}
		);
	};
	
	productService.findAll = function(page, limit){
		
		//console.log(model);
		
		var param =  {};
		param.page =page;
		param.limit =limit;		
		//console.log(param);
		
		
		return $http.get(model+'/'+page+'/'+limit).then(
				function(response){
					//console.log(response);
					return response.data;
				},
				function(errResponse){
					return $q.reject(errResponse);
				}
		);
	};	

	productService.createProduct = function(product){
		return $http.post('http://localhost:8080/product/', product)
		.then(
				function(response){
					console.log(response.data);
					return response.data;
				}, 
				function(errResponse){
					console.error('Error while creating product');
					return $q.reject(errResponse);
				}
		);
	}
	
	/*userService.getUserName = function(callback){
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

    return productService;

}]);

