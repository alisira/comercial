'use strict';

App.factory('EnviromentService', ['$http', '$q', function($http, $q){

	var model = 'enviroment';
	var enviromentService = {};
	
	//Constructor de EnviromentService
	function EnviromentService(){
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

		var param =  {};
		param.skip =skip;
		param.limit =limit;
		
		return $http.post(model+'/', param).then(
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

