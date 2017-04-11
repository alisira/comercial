'use strict';

App.directive('pagingObject', function(){
	
	return {
    	restrict: 'AE',    	
    	replace: true,
    	templateUrl: 'html/pagination.html',
    	link: function(scope,  element, attrs){
    		
    		scope.pagination = function() {

    			scope.limitBorder = {"left":12, "right":12};
    			scope.numPage =  Math.ceil(scope.model.count / scope.model.perPage);
    			
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

    		};
    		
    		
            scope.goToPage = function(page, $event) {

            	element.find('.active').removeClass('active');
            	//$event.currentTarget.parentNode.className ='active'; //This is another way to set the class           	
            	angular.element($event.currentTarget).parent().addClass('active');
            	
            	scope.goToPageEvent = true;
        		scope.model.page = page;
        		scope.findModel();
        		
            };
    		
            //Evento que observa el cambio en la variable pero q la primera vez tiene el mismo valor averiguar por que
    		scope.$watch('model.perPage', function(perPage, perPageOld) {
            	//console.log(perPage + '-' + perPageOld + '-' + scope.model.count);
                if (perPage!= perPageOld) {
                	scope.model.page = 1;
                }
            	
            	if (perPage > 0 && scope.model.count > 0) {
            		//console.log('paginacion1');
            		//console.log(perPage + '-' + perPageOld + '-' + scope.products.count);
            		scope.findModel();
            		scope.pagination();
            	}
            	
            });
    		
    		scope.$watch('model.count', function(modelCount, modelCountOld) {
            	if (scope.model.perPage > 0 && modelCount > 0) {
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