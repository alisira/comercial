'use strict';

App.factory('StatusService', ['$http', '$q', function($http, $q){

	var model = 'status';
	var statusService = {};
	
	//Constructor de StatusService
	function StatusService(){
        var model = 'status';
        //console.log(model);
    }
	
	function encodeUrl(param){

		var str = Object.keys(param).map(function(key){
			return encodeURIComponent(key) + '=' + encodeURIComponent(param[key]);
		}).join('&');

		if (str){
			str = '?' + str;
		}

		return str;
	}
	
	statusService.count = function(){

		//console.log(model);

		return $http.get(model+'/count/').then(
				function(response){					
					return response.data;
				},
				function(errResponse){
					return $q.reject(errResponse);
				}
		);
	};
	
	statusService.findAll = function(param){
		
		return $http.get(model +  encodeUrl(param)).then(
				function(response){	
					if (response.status == 500)
						return $q.reject(response);
					else
						return response.data;
				},
				function(errResponse){
					return $q.reject(errResponse);
				}
		);
		
	};	


    return statusService;

}]);

