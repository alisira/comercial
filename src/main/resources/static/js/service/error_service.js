'use strict';

App.factory('ErrorService', ['$rootScope','$timeout',  function($rootScope, $timeout){

	var errorService = {};
	
	errorService.set = function(responseError){

		//console.log(responseError);
		errorMessage = "Disculpe las molestia, ocurrio el siguiente error: " +  responseError.data.message;		
		$rootScope.alerts = [ { type: 'danger', msg: errorMessage } ];

		//$timeout(errorService.resetErrors, 9000);

	};

	errorService.setFormError = function(responseError){

		$rootScope.alerts = [ { type: 'danger', msg: responseError } ];

		//$timeout(errorService.resetErrors, 9000);

	};

	$rootScope.closeAlert = function(index) {
		$rootScope.alerts.splice(index, 1);
	};

	errorService.resetErrors = function() {
		$rootScope.alerts = [];
    }

    return errorService;

}]);

