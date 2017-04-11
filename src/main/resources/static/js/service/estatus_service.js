'use strict';

App.factory('StatusService', ['$http', '$q', function($http, $q){

	var model = 'status';
	var statusService = {};
	
	//Constructor de StatusService
	function StatusService(){
        var model = 'status';
        //console.log(model);
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
	
	statusService.findAll = function(limit, skip){
		
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


    return statusService;

}]);

