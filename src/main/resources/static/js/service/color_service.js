'use strict';

App.factory('ColorService', ['$http', '$q', function($http, $q){

	var model = 'color';
	var colorService = {};
	
	//Constructor de ColorService
	function ColorService(){
        var model = 'color';
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
	
	colorService.count = function(){

		return $http.get(model+'/count/').then(
				function(response){					
					return response.data;
				},
				function(errResponse){
					return $q.reject(errResponse);
				}
		);
	};
	
	colorService.findAll = function(param){

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


    return colorService;

}]);

