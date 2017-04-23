'use strict';

App.factory('ProductService', ['$http', '$q','RelationatedProductService', function($http, $q, RelationatedProductService){

	var model = 'product';
	var productService = {};
	var listRelationatedProducts = [];

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
	
	function encodeUrlDetail(param){

		var strQuery = '';
		var str = Object.keys(param).map(function(key){
			//console.log("key:" + key + ", param[key]:" + param[key]);

			if (key=='param'){
				
				var subParam = param[key];
				
				subParam.forEach(function(item, index){
					
					if (item.column){
						strQuery += item.column+ '=' + item.value + '&';						
					}else{
						strQuery += 'conect=' + item.conect + '&';	
					}
					
					//console.log(strQuery);
				})

			}else{
				return encodeURIComponent(key) + '=' + encodeURIComponent(param[key]);	
			}
			
		}).join('&');
		
		
		str += strQuery;

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
		
		return $http.get(model,{params:param}).then(
				function(response){
					//console.log(response);
					return response.data;
				},
				function(errResponse){
					return $q.reject(errResponse);
				}
		);
	};
	
	productService.findAllWithArray = function(param){

		//console.log(encodeUrl2(param));
		
		return $http.get(model, {params: encodeUrlDetail(param)}).then(
				function(response){
					//console.log(response);
					return response.data;
				},
				function(errResponse){
					return $q.reject(errResponse);
				});
		
		
	};

	productService.createProduct = function(product){
		return $http.post(model, product)
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
	
	productService.findProductRelationated = function(id) {
		return $http.get(model+'/'+ id )
			.then(
					function(response){
						if (response.status != 200){
							return $q.reject(response);
						}else{
							response.data.relationatedProduct.forEach(function myFunction(item, index) {
							    	productService.findById(item.idProductRelation).then(
							        		function(response) {
							        			//console.log(response);
							        			//console.log(item);
							        			item.idProduct = parseInt(id);
							        			item.name = response.name;  
							        			item.code = response.code;
							        			
							        		},
							        		function(errResponse) {
							        			console.log(errResponse);
							        		}
							        );

							})
							
							return response.data;
						}	
							
					}, 
					function(errResponse){
						console.error('Error while searching product');
						return $q.reject(errResponse);
					}
			);
    }
	
	
	productService.findById = function(id) {
		return $http.get(model+'/'+ id )
			.then(
					function(response){
						//console.log(response);
						if (response.status != 200){
							return $q.reject(response);
						}else{
							return response.data;
						}

					}, 
					function(errResponse){
						console.error('Error while searching product');
						return $q.reject(errResponse);
					}
			);
    }


	productService.updateProduct = function(product){
		return $http.put(model, product)
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

