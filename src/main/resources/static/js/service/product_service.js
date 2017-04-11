'use strict';

App.factory('ProductService', ['$http', '$q', function($http, $q){

	var model = 'product';
	var productService = {};

	//Constructor de ProductService
	function ProductService(){
        var model = 'product';
        console.log(model);
    }

	function encodeUrl(param){

		var str = Object.keys(param).map(function(key){
			return encodeURIComponent(key) + '=' + encodeURIComponent(param[key]);
		}).join('&');

		if (str){
			str = '?' + str;
		}

		return str;
	}

	productService.count = function(param){

		return $http.get(model+'/count'+encodeUrl(param)).then(
				function(response){					
					return response.data;
				},
				function(errResponse){
					return $q.reject(errResponse);
				}
		);
	};
	
	productService.findAll = function(param){
		
		return $http.get(model+'/list'+encodeUrl(param)).then(
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
		return $http.post(model+'/', product)
		.then(
				function(response){
					//console.log(response.data);
					return response.data;
				}, 
				function(errResponse){
					console.error('Error while creating product');
					return $q.reject(errResponse);
				}
		);
	}
	
	productService.findProduct = function(id) {
		return $http.get(model+'/'+ id )
			.then(
					function(response){
						//console.log(response);
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while creating product');
						return $q.reject(errResponse);
					}
			);
    }
	
	productService.updateProduct = function(product){
		return $http.put(model+'/', product)
		.then(
				function(response){
					//console.log(response.data);
					return response.data;
				}, 
				function(errResponse){
					console.error('Error while creating product');
					return $q.reject(errResponse);
				}
		);
	}

    return productService;

}]);

