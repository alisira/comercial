'use strict';

App.directive('validateForm',['ErrorService', '$location', '$anchorScroll', function(ErrorService, $location, $anchorScroll){
	return {
    	restrict: 'A',
    	link: function(scope,  element, attrs){

    		scope.$watch('form.$submitted', function(obj, objOld) {
            	if (scope.form.$submitted){
            		if (scope.form.$valid) {
	                	scope.actionSaveForm();
	                }else{
	                	var elements = scope.form.$$controls;
	                    var errors = [];
	                    angular.forEach(elements, function(element, key) {
	                    	//console.log(element.$$attr.validateName + '-' + element.$$attr.required + '-' + element.$invalid  + '-' + element.$pristine);
	                    	if (element.$$attr.required){
	                    		if (element.$invalid){
	                    			if (element.$$attr.validateName ){
	                    				if (element.$$attr.ngOptions || element.$$element.context.type == 'select-one' ){
	                    					//errors.push('Favor Seleccionar el campo ' +  element.$$attr.validateName );
	                    					ErrorService.setFormError('Favor Seleccionar el campo ' +  element.$$attr.validateName)
	                    				}else{
	                    					ErrorService.setFormError('Favor llenar el campo ' +  element.$$attr.validateName );
	                    				}

	                    			}else{
	                    				//console.log(element.$$attr);
	                    				if (element.$$attr.placeholder)
	                    					ErrorService.setFormError(element.$$attr.placeholder);
	                    			}
	                    		}
	                    	}

	                    });

	                }
	            	scope.form.$submitted = false;
	        		$location.hash();
	                $anchorScroll();
            	}
            });
    	}
    }
}]);

