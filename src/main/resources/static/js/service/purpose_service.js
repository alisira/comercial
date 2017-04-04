'use strict';

App.factory('PurposeService', ['$http', '$q', function($http, $q){

	var model = 'purpose';
	var enviromentService = {};
	
	//Constructor de PurposeService
	function PurposeService(){
        var model = 'enviroment';
        //console.log(model);
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
	
	enviromentService.findAll = function(limit, skip){

		//console.log(model);		
		//console.log(model);
		
		var param =  {};
		param.skip =skip;
		param.limit =limit;
		
		return $http.post(model+'/', param).then(
				function(response){					
					return response.data;
				},
				function(errResponse){
					return $q.reject(errResponse);
				}
		);
		
	};	


    return enviromentService;

}]);

