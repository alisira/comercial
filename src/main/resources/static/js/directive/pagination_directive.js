'use strict';

App.directive('pagingObject', [ function(){
	
	return {
    	restrict: 'AE',    	
    	replace: true,
    	templateUrl: 'html/directive/pagination.html',
    	link: function(scope,  element, attrs){
    		
    		scope.init = 1;
    		scope.longGroup = 9;
    		
    		scope.pagination = function() {

    			scope.limitBorder = {"left":10, "right":10};
    			scope.numPage =  Math.ceil(scope.model.count / scope.model.perPage);    			
    			
    			scope.aryPagination = [];
    			
    			for (var i=1;i<=scope.numPage;i++) {
    				scope.aryPagination.push(i);
    			}
    			
    			scope.aryPagination2 = [];
    			var pagina = {};
    			    			
    			var init = (Math.ceil(scope.model.page / scope.longGroup) - 1) * scope.longGroup + 1;

    			for (var i=init; i < init + scope.longGroup && i * scope.model.perPage <= scope.numPage * scope.model.perPage;i++) {    				
    				scope.aryPagination.push({"indice": i, "type":"number", "active": i==scope.model.page?true:false});
    			}    			
    			
    			
    			/*for (var i=scope.init;i<=scope.numPage;i++) {
    				
    				//scope.aryPagination.push(i);
    				if (i < 7 && scope.model.page < 7){
    					if (scope.numPage < 10){
    						scope.aryPagination2.push({"indice": i, "type":"number", "active": i==scope.model.page?true:false});
    					}else{
    						if ( i <  3 ){
    							scope.aryPagination2.push({"indice": i, "type":"number", "active": i==scope.model.page?true:false});
    						}else{
    							if (i==3){
    								scope.aryPagination2.push({"indice": i, "type":"button", "active": false});
    							}else{
    								continue;
    							}		
    						}	
    					}
    				}else{
    					//console.log(i);
    					
    					if (scope.numPage - 7 > 7 ){
    						
    						var half = Math.round(scope.numPage / 2);
        					
    						var x = i;
    						var a = half-3;
    						var b = half+3;
    						
    						//console.log(half);
    						
        					if (i >= half-3  && i <= half+3){
        						//scope.aryPagination2.push({"indice": i, "type":"number", "active": i==scope.model.page?true:false});
        						//console.log('en rango:' + i);
        						scope.aryPagination2.push({"indice": i, "type":"number", "active": i==scope.model.page?true:false});
        					}else{
        						
        						
        						if (i == scope.numPage - 2){
        							scope.aryPagination2.push({"indice": i, "type":"button", "active": false});
        						}else if (i > scope.numPage - 2){
        							scope.aryPagination2.push({"indice": i, "type":"number", "active": i==scope.model.page?true:false});
        						}else
        							continue;
        						
        						
        						//console.log('fuera de rango:' + i);
        					}
        					
    					}
    					
    				}
    				
    			}*/
    			
    			
    			
    			
    			

    		};

            scope.goToPage = function(page, $event) {

            	element.find('.active').removeClass('active');
            	//$event.currentTarget.parentNode.className ='active'; //This is another way to set the class           	
            	angular.element($event.currentTarget).parent().addClass('active');
            	
            	scope.goToPageEvent = true;
        		scope.model.page = page;
        		scope.findModel();
        		scope.pagination();
        		
            };
            
            scope.backPage = function() {
            	
            	if (scope.model.page > 1){
            		scope.goToPageEvent = true; 
            		scope.model.page--;
            		scope.findModel();
            		scope.pagination();
            	}
        		
            };            
            
            scope.nextPage = function() {

            	if (scope.model.page * scope.model.perPage < scope.numPage * scope.model.perPage){
            		scope.goToPageEvent = true;
            		scope.model.page++;
            		scope.findModel();
            		scope.pagination();
            	}
        		
            };
            
    		
            //Evento que observa el cambio en la variable pero q la primera vez tiene el mismo valor averiguar por que
    		scope.$watch('model.perPage', function(perPage, perPageOld) {
            	//console.log(perPage + '-' + perPageOld + '-' + scope.model.count);
                if (perPage!= perPageOld) {
                	scope.model.page = 1;
                	//scope.model.pagePerGroup = 1;
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
}]);