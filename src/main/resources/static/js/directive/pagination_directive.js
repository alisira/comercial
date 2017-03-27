'use strict';

App.directive('pagingObject', function(){
	
	return {
    	restrict: 'AE',    	
    	replace: true,
    	templateUrl: 'html/pagination.html',
    	link: function(scope,  element, attrs){
    		
    		scope.color = attrs.colorInicial;
    		
    		scope.pagination = function() {
    			//console.log(attrs.color);
    			//scope.color = attrs.color;
    			
    			var numPage =  scope.products.count / scope.products.perPage;
    			
    			console.log(numPage);
    			
    			if (numPage > 1){
    				element.find('.prev').removeClass('hidden');
    				element.find('.next').removeClass('hidden');
    			}else{
    				element.find('.prev').addClass('hidden');
    				element.find('.next').addClass('hidden');
    			}
    			
    			
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
    		scope.$watch('products.perPage', function(perPage, perPageOld) {
            	//console.log(perPage + '-' + perPageOld + '-' + scope.products.count);
                /*if (perPage!= perPageOld) {
                	//console.log('diferete');
                    //scope.pagination();
                }*/
            	
            	if (perPage > 0 && scope.products.count > 0) {
            		console.log('paginacion1');
            		//console.log(perPage + '-' + perPageOld + '-' + scope.products.count);
            		scope.pagination();
            	}
            	
            	
            	//scope.pagination();
            	
            });
    		
    		scope.$watch('products.count', function(productsCount, productsCountOld) {
            	//console.log(productsCount + '-' + productsCountOld + '-' + scope.products.perPage  );
                /*if (perPage!= perPageOld) {
                	//console.log('diferete');
                    //scope.pagination();
                }*/
            	
            	//scope.pagination();
            	
            	if (scope.products.perPage > 0 && productsCount > 0) {
            		console.log('paginacion2');
            		//console.log(productsCount + '-' + productsCountOld + '-' + scope.products.perPage  );
            		scope.pagination();
            	}
            	
            	
            });    		
    		
            
            //Metodo q funciona cuando inluyo el atributo per-page ="{{products.perPage}}" dentro de la etiqueta <paging-object></paging-object> 
            //me parece un poco mas invasivo pero se ejecuta primero que el watch 
            /*attrs.$observe('perPage', function(values){
            	console.log(values);
            });
            */
            
    		
    	}
    }
});