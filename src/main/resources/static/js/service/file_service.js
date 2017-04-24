'use strict';

App.factory('FileService', ['$http', '$q', function($http, $q){

	var model = 'file';
	var fileService = {};
	
	//Constructor de FileService
	function FileService(){
        var model = 'file';
    }
	
	fileService.storagePath = function(){
		return '/file/';
	};

    return fileService;

}]);

