'use strict';

App.directive('relationatedProduct', ['ProductService', function(ProductService){
	
	return {
    	restrict: 'AE',
    	replace: false,
    	scope: {idProduct: '=',
    		listRelationatedProducts: '=listRelationatedProducts'
    		},
    	templateUrl: 'html/directive/relationated_products.html',
    	link: function(scope,  element, attrs){

    		scope.title = attrs.title;
    		scope.searchProducts = function() {

    			if (scope.productsToFind != ''){
    				var param =  {};
    				var arrayFind =  [];

    				arrayFind.push({"column": "code", "value": scope.productsToFind});
    				arrayFind.push({"conect": 'or'});
    				arrayFind.push({"column": "description", "value":  scope.productsToFind});
    				arrayFind.push({"conect": 'or'});
    				arrayFind.push({"column": "name", "value": scope.productsToFind});

    				param.page = 1;
    				param.perPage = 10;
    				param.param = arrayFind;

    				ProductService.findAllWithArray(param)
    			        .then(
    			        		function(response) {
    			        			scope.listSearchProducts = response;
    			        		},
    			        		function(errorResponse) {
    			        			console.log(errorResponse);
    			        		}
    			        );	
    			}else{
    				scope.listSearchProducts = '';
    			}

    		}

    	    scope.addRelaProduct = function (id) {

    	        for (var index in scope.listSearchProducts ){
    	        	if (scope.listSearchProducts[index].idProduct == id ){
    	        		var value = scope.listSearchProducts.splice( index, 1 )[0];
    	        		var sw = false;
    	        		for (var index in scope.listRelationatedProducts ){
    	                	if (scope.listRelationatedProducts[index].idProductRelation == value.idProduct ){
    	                		sw = true;
    	                	}
    	        		}

    	        		if (sw == false){
    	        			scope.listRelationatedProducts.push({"idProduct":parseInt(scope.idProduct), "idProductRelation": value.idProduct, "code": value.code, "name": value.name});
    	        		}

    	        	}
    	        }

    	    };

    	}
    }
}]);