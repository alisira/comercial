'use strict';

App.factory('PurposeService', ['$http', '$q', function($http, $q){

	var model = 'purpose';
	var purposeService = {};
	
	//Constructor de PurposeService
	function PurposeService(){
        var model = 'service';
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
	
	purposeService.count = function(){

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
	
	purposeService.findAll = function(param){
		
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


    return purposeService;

}]);

