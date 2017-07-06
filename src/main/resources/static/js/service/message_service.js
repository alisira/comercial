'use strict';

App.factory('MessageService', ['$rootScope','$timeout',  function($rootScope, $timeout){

	var messageService = {};
	
	messageService.set = function(responseMessage){

		//console.log(responseMessage);
		$rootScope.alerts = [ { type: 'success', msg: responseMessage } ];		
		
	};
	
	messageService.resetMessages = function() {
		$rootScope.alerts = [];
    }

    return messageService;

}]);