'use strict';

App.directive('pagingObject', function(){
	
	return {
    	restrict: 'AE',    	
    	replace: true,
    	templateUrl: 'html/pagination.html',
    	link: function(scope,  element, attrs){
    		
    		scope.pagination = function() {
    			//console.log(attrs.color);
    			//scope.color = attrs.color;
    			scope.limitBorder = {"left":12, "right":12};
    			
    			scope.numPage =  Math.ceil(scope.model.count / scope.model.perPage);
    			
    			//console.log(scope.numPage);
    			
    			if (scope.numPage > 1){
    				element.find('.prev').removeClass('hidden');
    				element.find('.next').removeClass('hidden');
    			}else{
    				element.find('.prev').addClass('hidden');
    				element.find('.next').addClass('hidden');
    			}
    			
    			scope.aryPagination = [];
    			
    			for (var i=1;i<=scope.numPage;i++) {
    				scope.aryPagination.push(i);
    			}    			
    			
    			scope.findModel();

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
    		
    		
            scope.goToPage = function(page) {

                /*if (scope.params.limit > scope.count) {
                    scope.params.skip = 0;
                } else {
                    scope.params.skip = (page * scope.params.limit) - scope.params.limit;
                }

                scope.actionFind();
                */
            	console.log(page);
            };
    		
            //Evento que observa el cambio en la variable pero q la primera vez tiene el mismo valor averiguar por que
    		scope.$watch('model.perPage', function(perPage, perPageOld) {
            	//console.log(perPage + '-' + perPageOld + '-' + scope.model.count);
                /*if (perPage!= perPageOld) {
                	//console.log('diferete');
                    //scope.pagination();
                }*/
            	
            	if (perPage > 0 && scope.model.count > 0) {
            		//console.log('paginacion1');
            		//console.log(perPage + '-' + perPageOld + '-' + scope.products.count);            		
            		scope.pagination();
            	}
            	
            	
            	//scope.pagination();
            	
            });
    		
    		scope.$watch('model.count', function(modelCount, modelCountOld) {
            	//console.log(modelCount + '-' + modelCountOld + '-' + scope.model.perPage);
                /*if (perPage!= perPageOld) {
                	//console.log('diferete');
                    //scope.pagination();
                }*/
            	
            	//scope.pagination();
            	
            	if (scope.model.perPage > 0 && modelCount > 0) {
            		console.log('paginacion2');
            		//console.log(modelCount + '-' + modelCountOld + '-' + scope.model.perPage  );
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