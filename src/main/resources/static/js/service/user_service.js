'use strict';

App.factory('UserService', ['$http', '$q', function($http, $q){

	var userService = {};	
	var token = '';
	var user={id:null,username:'Ali Sira',address:'',email:''};
	
	//Constructor de User
	function UserService(){
        //this.model = 'user-role';
    }
	
	
	userService.getToken = function(){
		//console.log('Entro:'+token);
		return token;
	}
	
	userService.getUserName = function(){
		console.log('Entro:'+user.username);
		return user.username;
	}

	userService.getPermission = function(idUser){
		
		var param= {idUser:idUser};
		return $http.post('http://localhost:8080/user_permission/', param)
			.then(
				function(response){					
					return response.data;
				}, 
				function(errResponse){
					console.error('Error while get user permission');
					return $q.reject(errResponse);
				}
		);
	}    

    return userService;
	
	
	

}]);
