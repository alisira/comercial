'use strict';

App.controller('AdminColorControllerList', ['$scope', '$location', 'Color', '$http', function($scope, $location, Color, $http) {
	var self = this;
	$scope.appTitle = "Administrador de Colores";	
	$scope.products = {"list":null};
	$scope.relativePath = $location.path().split('/').slice(1,2)[0];
	$scope.model =	{"perPage" : "10", "page":1, "count": 0, "order":"denomination"};
	var param =  {};

	$scope.actionCount = function(param) {
        var color = new Color();
        color.count(param).then($scope.actionReadyCount, color.error);
    }

	$scope.actionReadyCount = function(response) {
		$scope.model.count = parseInt(response);
	}

	$scope.findModel = function() {

		var color = new Color();
		param =  {};

		if ($scope.denomination)
			param.denomination = $scope.denomination;

		if ($scope.denomination || $scope.denomination)
			param.page = $scope.model.page;
		else
			param.page =parseInt($scope.model.page);

		param.perPage =parseInt($scope.model.perPage);
		param.order = $scope.model.order;

		color.findAll(param).then(
			function(response) {
				//console.log(response);
				$scope.model.list = response;
				$scope.actionCount(param);
			},
			function(errResponse) {
				//console.log(errResponse);		
				//throw { message: 'error message' };
			}
		);
	}
	
	
	$scope.pdf = function() {		
		
		/*return $http.get(model+'/count/').then(
				function(response){					
					return response.data;
				},
				function(errResponse){
					return $q.reject(errResponse);
				}
		);*/		
		
		return $http.get('color/print',	null).then(function(response) {
					if (response) {
						$scope.pdfOut = response.data;

						var fileName = $scope.selectedRow;
						var a = document.createElement("a");
						document.body.appendChild(a);
						a.style = "display: none";

//						var fileContent = base64.decode($scope.pdfOut.pdf);
						/*var myBlob = $scope.b64toBlob($scope.pdfOut.pdf, 'application/pdf', 512);
						var blobURL = ($window.URL || $window.webkitURL).createObjectURL(myBlob);
						a.download = fileName;
						a.href = blobURL;
						document.body.appendChild(a);
						a.click();
						document.body.removeChild(a);
						*/
						console.log(response);

					}
				});
	};
	
	

    $scope.init = function() {
        $scope.findModel();
    };

    $scope.init();

}]);


App.controller('AdminColorControllerNew', function($scope, $location, Color, Status, MessageService, ErrorService) {
	$scope.submitTitle = 'Guardar';
	$scope.appTitle = "Color";
	$scope.relativePath = $location.path().split('/').slice(1,2)[0];
	$scope.listRelationatedProducts = [];
	var param =  {};

    $scope.init = function() {
        $scope.findStatus();
    };

	$scope.findStatus = function() {
		
        var status = new Status();
        
        param =  {};
		param.table_ = 'generic';

		status.findAll(param)
	        .then(
	        		function(response) {
	        			//console.log(response);
	        			$scope.statuses = response;
	        		},
	        		$scope.error
	        	);

    }

    $scope.actionSaveForm = function() {

    	var color = new Color();

    	color.save($scope.color).then(
        		function(response) {
        			console.log(response);        			
        			//console.log($scope.relativePath + '/edit/'+ response.id);
        			$location.path($scope.relativePath + '/edit/'+ response.id);
        			//$scope.statuses = response;
        			//$scope.count = permission.permisos;
        			MessageService.set('Registro guardado satisfactoriamente');

        		},
        		function(errResponse){
        			if (errResponse.data)
        				ErrorService.set(errResponse);
        			else{
        				ErrorService.setFormError('Error Guardando el Color favor revisar los datos o comunicarse con un administrador, gracias');
        				console.error(errResponse);
        			}
        				
        			/*console.error(errResponse);
        			console.error('Error saving Color');
        			ErrorService.set(errResponse);
        			*/
        			//
        		}
        );
    }

    $scope.init();
});

/**
 * Controller AdminColorControllerEdit
 * @param {scope} $scope DOM manipulation
 * @param {stateParams} $stateParams
 * @param {Color} Color factory
 */
App.controller('AdminColorControllerEdit', function($scope, $location, $stateParams, Color, Status, ErrorService, MessageService ) {	
	$scope.submitTitle = 'Guardar';
	$scope.appTitle = "Color";
	$scope.relativePath = $location.path().split('/').slice(1,2)[0];
	var param =  {};

    $scope.init = function() {
        $scope.findStatus();
        $scope.findColorById($stateParams.id);
    };

	$scope.findColorById = function(id) {
		
		var color = new Color();

		color.findAll({"idColor":id}).then(
    		function(response) {
    			
    			$scope.color = response;
    			
    			console.log(response);
    			
    			$scope.color.idStatus = String(response.idStatus);

    		},
    		function(response) {
    			ErrorService.set(response);
    			$location.path($location.path().split('/').slice(1,2)[0]+'/list');
    		}
        );
    }

	$scope.findStatus = function() {

        var status = new Status();

        param =  {};
		param.table_ = 'generic';

		status.findAll(param)
	        .then(
	        		function(response) {
	        			console.log(response);
	        			$scope.statuses = response;
	        		},
	        		$scope.error
	        	);
    }

    $scope.actionSaveForm = function() {

		$scope.color.idStatus = parseInt($scope.color.idStatus);

		var color = new Color();

		color.update2($scope.color).then(
    		function(response) {
    			console.log(response);
    			$scope.findColorById($stateParams.id);
    			MessageService.set('Registro guardado satisfactoriamente');
    		},
    		function(errResponse){
    			console.error(errResponse);
    			console.error('Error Guardando Color');
    		}
        );
    }


    $scope.init();
});



