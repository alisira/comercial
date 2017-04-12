'use strict';

App.factory('EnviromentService', ['$http', '$q', function($http, $q){

	var model = 'enviroment';
	var enviromentService = {};
	
	//Constructor de EnviromentService
	function EnviromentService(){
        var model = 'enviroment';
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
	
	
	enviromentService.count = function(){

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
	
	enviromentService.findAll = function(param){

		return $http.get(model + '/list' + encodeUrl(param)).then(
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

    return enviromentService;

}]);

