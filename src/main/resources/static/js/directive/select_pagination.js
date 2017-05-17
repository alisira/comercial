'use strict';

App.directive('selectPagination', [function(){
	
	var html =  '<select class="form-control" ng-model="model"><option value=5>5</option>';
	html += '<option value=10>10</option>';
	html += '<option value=25 selected>25</option>';
	html += '<option value=50>50</option>';
	html += '<option value=75>75</option>';
	html += '<option value=100>100</option>';
	html += '</select>';
	
	return {
    	restrict: 'AE',    	
    	replace: true,
    	template: html ,
    	link: function(scope,  element, attrs){
    		
    		scope.color = attrs.colorInicial;
    		
    		scope.pagination = function() {
    			//console.log(attrs.color);
    			//scope.color = attrs.color;
    			
    			/*var numPage =  scope.products.count / scope.products.perPage;
    			
    			console.log(numPage);
    			
    			if (numPage > 1){
    				element.find('.prev').removeClass('hidden');
    				element.find('.next').removeClass('hidden');
    			}else{
    				element.find('.prev').addClass('hidden');
    				element.find('.next').addClass('hidden');
    			}*/
    			
    			
    			/*if (skip > 0) {
                    element.find('.prev').removeClass('hidden');
                } else {
                    element.find('.prev').addClass('hidden');
                }

                var nextSkip = parseInt(scope.params.skip) + parseInt(scope.params.limit);

                if (nextSkip >= scope.count) {
                    element.find('.next').addClass('hidden');
                } else {
                    element.find('.next').removeClass('hidden');
                }*/
    			
    			
    		};
    		
            //Evento que observa el cambio en la variable pero q la primera vez tiene el mismo valor averiguar por que
    		scope.$watch('model', function(model, modelOld) {
            	console.log(model);
            	
            });
  		
    		
            
            //Metodo q funciona cuando inluyo el atributo per-page ="{{products.perPage}}" dentro de la etiqueta <paging-object></paging-object> 
            //me parece un poco mas invasivo pero se ejecuta primero que el watch 
            /*attrs.$observe('perPage', function(values){
            	console.log(values);
            });
            */
            
    		
    	}
    }
}]);