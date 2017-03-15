'use strict';

App.controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
          var self = this;
          self.user={id:null,username:'',address:'',email:''};
          self.users=[];
          self.permission = {};
          $scope.token='';
          
          self.fetchUserPermission = function(){
        	  
              UserService.getPermission(1)
                  .then(
      					       function(permission ) {      						      
      					    	   $scope.permission = permission.permisos;
      						      
      					       },
            					function(errResponse){
            						console.error('Error while fetching permissions');
            					}
      			       );
          };
          
          
          $scope.getToken = function(){
        	  $scope.token = UserService.getToken();
          };
          
          
          $scope.getUserName = function(){
        	  return UserService.getUserName();
          };  
              
          
          //$scope.getToken();
          //self.fetchUserPermission();

      }]);
