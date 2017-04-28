'use strict';

App.factory('MessageService', ['$rootScope','$timeout',  function($rootScope,$timeout){

	var messageService = {};
	
	messageService.set = function(responseMessage){

		//console.log(responseMessage);
		if (!$rootScope.messages){
			$rootScope.messages = [];	
		}
		
		for (var message in $rootScope.messages){
			if ($rootScope.messages[message] == responseMessage) 
				var sw = true;
		}
		
		if (!sw) $rootScope.messages.push(responseMessage);
		
		$timeout(messageService.resetMessages, 9000);
		
	};	
	
	messageService.get = function(param){
		return messages;
	};
	
	messageService.resetMessages = function() {
		$rootScope.messages = null;
    }

    return messageService;

}]);

