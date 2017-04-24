'use strict';

App.directive('fileLoad', function($http, ErrorService){	
	return {
		restrict: 'A',
        link: function (scope, element, attributes) {
            element.bind("change", function (changeEvent) {
                
            	/*var reader = new FileReader();
                reader.onload = function (loadEvent) {
                    scope.$apply(function () {
                        scope.fileLoad = loadEvent.target.result;
                    });
                }
                reader.readAsDataURL(changeEvent.target.files[0]);
                */
            	
            	//console.log(changeEvent.target.files[0]);
            	//scope.uploadFile(changeEvent.target.files[0]);
            	
            	if (changeEvent.target.files[0] != undefined){
            		scope.uploadFile(changeEvent.target.files[0], changeEvent);
            	}
            	
            	
            	
            });
            
            
            scope.uploadFile = function(fileObject, changeEvent){

            	//console.log(angular.element('#upload_image')[0].files[0]);
            	//console.log(angular.element(document.querySelector('#upload_image').files[0]));            	
            	
                var formData=new FormData();
                formData.append("file", fileObject);
                
                $http.post('/file', formData, {
                    transformRequest: function(data, headersGetterFunction) {
                        return data;
                    },
                    headers: { 'Content-Type': undefined }
                    }).then(
            			function(response){
            				//console.log(response);
            				if (response.status != 200){
            					//Error de javascript element.context.files[0].name=null; resp:TypeError: Cannot assign to read only property 'name' of object '#<File>'            					
            					//return scope.error(response);
            					ErrorService.set(response)
            				}else
            					return scope.loadImage(response);
            			},
            			function(errResponse){
            				console.log(errResponse);
            				ErrorService.set(response)
            				//return scope.error(errResponse);
            				//return $q.reject(errResponse);
            			}
            		);
            	
            }
            
            
        }
    }    
});

