'use strict';

App.controller('AdminProductControllerList', ['$scope', '$location', 'ProductService', 'CategoryService', function($scope, $location, ProductService, CategoryService) {
	var self = this;
	$scope.appTitle = "Administrador de Productos";
	$scope.products = {"perPage" : "25" , "count": 0, "list":null, "skip": 0};
	$scope.relativePath = '#!/' + $location.path().split('/').slice(1,2)[0];
	$scope.model = 'products';
	
	
		
	$scope.actionCount = function() {
		
        var productService = ProductService;
        
        productService.count()	
	        .then(
	        		function(response) {
	        			//console.log(response);
	        			$scope.products.count = parseInt(response.count);
	        			//$scope.count = permission.permisos;
	        		},
	        		function(errResponse){
	        			console.error('Error counting products');
	        		}
	        );
        	
        /*adminNewborn.params = {
            count: true
        };
        adminNewborn.ready = $scope.actionCountReady;
        adminNewborn.findAll();
        */
    }
	
	$scope.findCategories = function() {
		
        var categoryService = CategoryService;
        
        categoryService.findAll()	
	        .then(
	        		function(response) {
	        			//console.log(response);
	        			$scope.categories = response;
	        			//$scope.count = permission.permisos;
	        		},
	        		function(errResponse){
	        			console.error('Error counting products');
	        		}
	        );
       
    }
	
	$scope.findProducts = function() {
		
		
		console.log("Dentro de findproducts :" + parseInt($scope.products.perPage) + '-' +  $scope.products.skip);
		
		
		var productService = ProductService;
        
		productService.findAll(parseInt($scope.products.perPage), $scope.products.skip)
	        .then(
	        		function(response) {
	        			//console.log(response);
	        			$scope.products.list = response;
	        			//$scope.count = permission.permisos;
	        		},
	        		function(errResponse){
	        			console.error('Error counting products');
	        		}
	        );
       
	}
	
	
	/*$scope.actionCount = function() {

        var adminNewborn = new Newborn();
        adminNewborn.params = {
            count: true
        };
        adminNewborn.ready = $scope.actionCountReady;
        adminNewborn.findAll();
    };
    $scope.actionCountReady = function(count) {

        $scope.count = parseInt(count);
        $scope.actionFind();
    };

    $scope.actionFind = function() {	

        var adminNewborn = new Newborn();

        if (typeof $scope.search.name == 'undefined') {
            name = '';
        } else {
            name = $scope.search.name;
        }

        if (typeof $scope.search.full_name == 'undefined') {
            full_name = '';
        } else {
            full_name = $scope.search.full_name;
        }

        adminNewborn.params = {
            'fields': '_id, name, ref_image, ref_profile, sex, birthdate',
            'ref[image][fields]': 'image_original, image_name, image_small',
            'ref[profile][fields]': 'full_name',
            'ref[profile][search][match][full_name]': '*' + full_name + '*',
            'search[and][name]': '*' + name + '*',
            'sort': '-birthdate',
            'limit': false,
            'cache': true
        };

        adminNewborn.ready = $scope.actionFindReady;
        adminNewborn.findAll();
    };

    $scope.actionFindReady = function(aryAdminNewborn) {
        if (Array.isArray(aryAdminNewborn)) {
            $scope.aryAdminNewborn = aryAdminNewborn;
        } else {
            $scope.aryAdminNewborn = new Array(aryAdminNewborn);
        }
    };
    $scope.actionDelete = function() {
        var adminNewborn = new Newborn();
        adminNewborn.id = $scope.deleteId;
        adminNewborn.ready = $scope.actionDeleteReady;
        adminNewborn.delete();
    };
    $scope.actionDeleteReady = function(adminNewborn) {
        $scope.deleteId = '';
        $scope.init();
    };*/

    $scope.init = function() {
    	
    	    	
    	//console.log(relativePath);
        $scope.actionCount();
        $scope.findProducts();
        //$scope.findCategories();

        
    };
    $scope.init();
	
          

}]);

