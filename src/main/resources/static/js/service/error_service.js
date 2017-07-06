'use strict';

App.factory('ErrorService', ['$rootScope','$timeout',  function($rootScope,$timeout){

	var errorService = {};
	
	errorService.set = function(responseError){

		//console.log(responseError);
		if (!$rootScope.errors){
			$rootScope.errors = [];	
		}
		
		for (var error in $rootScope.errors){
			if ($rootScope.errors[error] == "Disculpe las molestia, ocurrio el siguiente error: " +  responseError.data.message) 
				var sw = true;
		}
		
		if (!sw) $rootScope.errors.push("Disculpe las molestia, ocurrio el siguiente error: " +  responseError.data.message);
		
		$timeout(errorService.resetErrors, 9000);
		
	};
	
	
	errorService.setFormError = function(responseError){

		//console.log(responseError);
		if (!$rootScope.errors){
			$rootScope.errors = [];	
		}
		
		for (var error in $rootScope.errors){
			if ($rootScope.errors[error] == responseError) 
				var sw = true;
		}
		
		if (!sw) $rootScope.errors.push(responseError);
		
		$timeout(errorService.resetErrors, 9000);
		
	};
	
	
	$rootScope.closeAlert = function(index) {
		$rootScope.alerts.splice(index, 1);
	};
	
	errorService.get = function(param){
		return errors;
	};

	errorService.resetErrors = function() {
		$rootScope.errors = null;
    }

    return errorService;

}]);

