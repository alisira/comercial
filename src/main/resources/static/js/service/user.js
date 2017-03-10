'use strict';

App.factory('User', function(){
	
	var user = {};
	
	var token = '';
	
	
	//Constructor de User
	function User(){
        //this.model = 'user-role';
    }

	user.setToken = function(_token){
		token = _token;
	}

	user.getToken = function(){
		return token;
	}
    

    return user;

});
