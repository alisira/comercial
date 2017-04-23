'use strict';

App.directive('relationatedProduct', function(ProductService){
	
	return {
    	restrict: 'AE',    	
    	replace: false,
    	scope: {idProduct: '='},
    	templateUrl: 'html/directive/relationated_products.html',
    	link: function(scope,  element, attrs){
    		
    		element.bind("click", function (changeEvent) {

            	//console.log('deploy');
            });    		

    		scope.title = attrs.title;
    		var pp = [];
    		
    		scope.searchProducts = function() {
    			//console.log(scope.productsToFind);
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
    				//console.log(paramFinal);	

    				ProductService.findAllWithArray(param)
    			        .then(
    			        		function(response) {
    			        			scope.listSearchProducts = response;
    			        		},
    			        		scope.error
    			        );	
    			}else{
    				scope.listSearchProducts = '';
    			}
    			
    		}

    	    scope.addRelaProduct = function (id) {
    	        //console.log(id);
    	        for (var index in scope.listSearchProducts ){
    	        	if (scope.listSearchProducts[index].idProduct == id ){
    	        		var value = scope.listSearchProducts.splice( index, 1 )[0];
    	        		var sw = false;
    	        		for (var index in ProductService.getRelationatedProducts() ){
    	                	if (ProductService.getRelationatedProducts()[index].idProductRelation == value.idProduct ){
    	                		sw = true;
    	                	}
    	        		}

    	        		if (sw == false){    	        			
    	        			pp = ProductService.getRelationatedProducts();
    	        			pp.push({"idProduct":parseInt(attrs.product), "idProductRelation": value.idProduct, "code": value.code, "name": value.name});
    	        			ProductService.setRelationatedProducts(pp);
    	        		}
    	        			//ProductService.addRelationatedProducts({"idProduct":parseInt(attrs.product), "idProductRelation": value.idProduct, "code": value.code, "name": value.name});    	        			

    	        	}
    	        }
    	        
    	        //console.log(ProductService.getRelationatedProducts());

    	    };


    	}
    }
});