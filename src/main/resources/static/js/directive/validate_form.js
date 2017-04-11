'use strict';

App.directive('validateForm', function($rootScope){	
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
	                    			errors.push('Favor llenar el campo ' +  element.$$attr.validateName );

	                    		}
	                    	}

	                    });

	                    $rootScope.errors = errors;

	                }
            	}
            	scope.form.$submitted = false;
            });

    	}
    }
});

