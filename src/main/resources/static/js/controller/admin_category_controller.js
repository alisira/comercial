'use strict';

App.controller('AdminCategoryControllerList', ['$scope', '$location', 'Category', '$http', function($scope, $location, Category, $http) {
	var self = this;
	$scope.appTitle = "Administrador de Categorias";	
	$scope.products = {"list":null};
	$scope.relativePath = $location.path().split('/').slice(1,2)[0];
	$scope.model =	{"perPage" : "10", "page":1, "count": 0};
	var param =  {};

	$scope.actionCount = function(param) {
        var category = new Category();
        category.count(param).then($scope.actionReadyCount, category.error);
    }

	$scope.actionReadyCount = function(response) {
		$scope.model.count = parseInt(response);
	}

	$scope.findModel = function() {

		var category = new Category();
		param =  {};

		if ($scope.denomination)
			param.denomination = $scope.denomination;

		if ($scope.denomination || $scope.denomination)
			param.page = $scope.model.page;
		else
			param.page =parseInt($scope.model.page);

		param.perPage =parseInt($scope.model.perPage);

		category.findAll(param)
	        .then(
	        		function(response) {
	        			//console.log(response);
	        			$scope.model.list = response;
	        			$scope.actionCount(param);
	        		},
	        		$scope.error
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
		
		return $http.get('category/print',	null).then(function(response) {
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


App.controller('AdminCategoryControllerNew', function($scope, $location, Category, Status, MessageService, ErrorService) {
	$scope.submitTitle = 'Guardar';
	$scope.appTitle = "Category";
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

    	var category = new Category();

    	category.save($scope.category).then(
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
        			else
        				ErrorService.setFormError('Error Guardando el Category favor revisar los datos o comunicarse con un administrador, gracias');
        			/*console.error(errResponse);
        			console.error('Error saving Category');
        			ErrorService.set(errResponse);
        			*/
        			//
        		}
        );
    }

    $scope.init();
});

/**
 * Controller AdminCategoryControllerEdit
 * @param {scope} $scope DOM manipulation
 * @param {stateParams} $stateParams
 * @param {Category} Category factory
 */
App.controller('AdminCategoryControllerEdit', function($scope, $location, $stateParams, Category, Status, ErrorService, MessageService ) {	
	$scope.submitTitle = 'Guardar';
	$scope.appTitle = "Category";
	$scope.relativePath = $location.path().split('/').slice(1,2)[0];
	var param =  {};

    $scope.init = function() {
        $scope.findStatus();
        $scope.findCategoryById($stateParams.id);
    };

	$scope.findCategoryById = function(id) {
		
		var category = new Category();

		category.findAll({"idCategory":id}).then(
    		function(response) {
    			
    			$scope.category = response;
    			$scope.category.idStatus = String(response.idStatus);

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
	        			//console.log(response);
	        			$scope.statuses = response;
	        		},
	        		$scope.error
	        	);
    }

    $scope.actionSaveForm = function() {

		$scope.category.idStatus = parseInt($scope.category.idStatus);

		var category = new Category();

		category.update2($scope.category).then(
    		function(response) {
    			//console.log(response);
    			$scope.findCategoryById($stateParams.id);
    			MessageService.set('Registro guardado satisfactoriamente');
    		},
    		function(errResponse){
    			console.error('Error Guardando Category');
    		}
        );
    }


    $scope.init();
});



