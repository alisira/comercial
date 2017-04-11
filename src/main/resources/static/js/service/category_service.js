'use strict';

App.factory('CategoryService', ['$http', '$q', function($http, $q){

	var model = 'category';
	var categoryService = {};
	
	//Constructor de CategoryService
	function CategoryService(){
        var model = 'category';
        console.log(model);
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
	
	categoryService.count = function(param){

		return $http.get(model+'/count'+encodeUrl(param)).then(
			function(response){
				return response.data;
			},
			function(errResponse){
				return $q.reject(errResponse);
			}
		);
	};
	
	categoryService.findAll = function(param){

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

    return categoryService;

}]);

