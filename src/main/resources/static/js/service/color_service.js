'use strict';

App.factory('ColorService', ['$http', '$q', function($http, $q){

	var model = 'color';
	var colorService = {};
	
	//Constructor de ColorService
	function ColorService(){
        var model = 'color';
        //console.log(model);
    }
	
	colorService.count = function(){

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
	
	colorService.findAll = function(limit, skip){

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


    return colorService;

}]);

