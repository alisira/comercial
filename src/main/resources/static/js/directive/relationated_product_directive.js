'use strict';

App.directive('relationatedProduct', function(){
	
	return {
    	restrict: 'AE',    	
    	replace: false,
    	templateUrl: 'html/directive/relationated_products.html',
    	link: function(scope,  element, attrs){
    		
    		element.bind("click", function (changeEvent) {

            	//console.log('deploy');
            });
    		




    	}
    }
});