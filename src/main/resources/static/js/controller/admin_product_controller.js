'use strict';

App.controller('AdminProductControllerList', ['$scope', '$location', 'ProductService', 'Category', '$timeout', 'ErrorService', function($scope, $location, ProductService, Category, $timeout, ErrorService) {
	var self = this;
	$scope.appTitle = "Administrador de Productos";	
	$scope.products = {"list":null};
	$scope.relativePath = '#!/' + $location.path().split('/').slice(1,2)[0];
	$scope.model =	{"name" : "products" , "perPage" : "10", "page":1, "count": 0};
	var param =  {};
	
	$scope.actionCount = function(param) {
        var productService = ProductService;        
        productService.count(param).then($scope.actionReadyCount, $scope.error);
    }

	$scope.actionReadyCount = function(response) {
		$scope.model.count = parseInt(response.count);
	}

	$scope.findCategories = function() {
        
        var category =  new Category(); 
		var param =  {};
		param.page = 1;
		param.perPage = 100;
		param.order = 'denomination';
		
		category.findAll(param).then(
    		function(response) {
    			console.log(response);        			
    			$scope.categories = response;
    		}
        )
	        
     };
    
	
	$scope.findModel = function() {

		param =  {};

		if ($scope.code){
			param.code = $scope.code; 
		}
		if ($scope.description){
			param.description = $scope.description; 
		}
		if ($scope.name){
			param.name = $scope.name; 
		}		
		if ($scope.category){
			param.idCategory = $scope.category.idCategory; 
		}
		
		if ($scope.code || $scope.description || $scope.name || $scope.category){
			
			if (!$scope.goToPageEvent){
				param.page = $scope.model.page=1;
			}else{
				param.page = $scope.model.page;
			}
						 
		}else{
			param.page =parseInt($scope.model.page);
		}

		$scope.goToPageEvent =false;		
		param.perPage =parseInt($scope.model.perPage);
		//console.log(param);		

		ProductService.findAll(param).then(
    		function(response) {
    			$scope.model.list = response;
    			$scope.actionCount(param);
    		},
    		$scope.error
        );
	}

    $scope.init = function() {
        $scope.findCategories();
        $scope.findModel();       
    };

    $scope.init();

}]);


App.controller('AdminProductControllerNew', function($scope, $location, ProductService, Color, EnviromentService, PurposeService, Category, StatusService, $timeout, MessageService, ErrorService) {
	$scope.submitTitle = 'Guardar';
	$scope.appTitle = "Producto";
	$scope.relativePath = '#!/' + $location.path().split('/').slice(1,2)[0];
	$scope.listRelationatedProducts = [];

    $scope.image = {};
    $scope.image.url = 'https://dummyimage.com/300x300.png&text=Seleccione%20Imagen';

    $scope.init = function() {

        $scope.findColors();
        $scope.findEnviroments();
        $scope.findPurposes();
        $scope.findCategories();
        $scope.findStatus();
        //$scope.adminNewborn.birthdate = moment(new Date()).format('YYYY-MM-DD');
    };

    $scope.findColors = function() {

        var color = new Color();

        color.findAll({'page':1, 'perPage':100, 'order':'denomination'}).then(
    		function(response) {
    			$scope.colors = response;
    		},
    		function(errResponse){
    			ErrorService.setFormError('Error Obteniendo la lista de colores, favor comunicar al administrador');
    		}
        );

    }

	$scope.findEnviroments = function() {

        var enviromentService = EnviromentService;

        enviromentService.findAll(0,0)	
	        .then(
	        		function(response) {
	        			$scope.enviroments = response;
	        		},
	        		function(errResponse){
	        			ErrorService.setFormError('Error getting Enviroment');
	        		}
	        );

    }

	$scope.findPurposes = function() {
		
        var purposeService = PurposeService;
        
        purposeService.findAll(0,0)	
	        .then(
	        		function(response) {
	        			//console.log(response);
	        			$scope.purposes = response;

	        		},
	        		function(errResponse){
	        			//console.error('Error getting Purpose');
	        			ErrorService.setFormError('Error getting Purpose');
	        		}
	        );
       
    }
	
	$scope.findCategories = function() {
		
        var category = new Category();
        
        var param =  {};
		param.page = 0;
		param.perPage = 0;
		param.order = 'denomination';
        
        category.findAll(param)
	        .then(
        		function(response) {
        			//console.log(response);
        			$scope.categories = response;
        		},
        		function(errResponse){
        			//console.error('Error getting products');
        			ErrorService.setFormError('No Se Pudo Obtener el listado de Categorias');
        		}
	        );
       
    }

	$scope.findStatus = function() {
		
        var statusService = StatusService;
        
        statusService.findAll(0,0).then(
    		function(response) {
    			//console.log(response);
    			$scope.statuses = response;
    			//$scope.count = permission.permisos;
    		},
    		function(errResponse){
    			ErrorService.setFormError('Error getting products');
    		}
        );
       
    }

    $scope.actionSaveForm = function() {
    	
    	$scope.product.idCategory = parseInt($scope.product.idCategory);
    	$scope.product.relationatedProduct =  $scope.listRelationatedProducts;
    	
    	ProductService.createProduct($scope.product).then(
        		function(response) {
        			//console.log(response);        			
        			//console.log($scope.relativePath + '/edit/'+ response.id);
        			$location.path($location.path().split('/').slice(1,2)[0] + '/edit/'+ response.id);
        			//$scope.statuses = response;
        			//$scope.count = permission.permisos;
        			MessageService.set('Registro guardado satisfactoriamente');
        			
        		},
        		function(errResponse){
        			//console.error('Error saving product');
        			ErrorService.setFormError('Error Guardando el Producto favor revisar los datos o comunicarse con un administrador, gracias');
        		}
        );
    }
    
    $scope.loadImage = function(resp){
    	//console.log(resp);
    	$scope.image.url = resp.data.imageUrl;
    	$scope.image.idImage = resp.data.idImage;
    	$scope.product.idImage = $scope.image.idImage;
    	//console.log($scope.product);
    }
    
    $scope.OnUpload = function ($event) {
    	//$event.stopPropagation(); // <-- this is important
        $timeout(function() {
        	angular.element('#upload_image').trigger('click');
        }, 0);
    };
    
    $scope.removeRelaProduct = function (idProduct) {

        for (var index in $scope.listRelationatedProducts){
        	if ($scope.listRelationatedProducts[index].idProductRelation == idProduct ){
        		$scope.listRelationatedProducts.splice( index, 1 )[0];
        	}
        }

    };

    $scope.init();
});

/**
 * Controller AdminProductControllerEdit
 * @param {scope} $scope DOM manipulation
 * @param {stateParams} $stateParams
 * @param {ProductService} ProductService factory
 */
App.controller('AdminProductControllerEdit', function($scope, $location, $stateParams, $timeout, ProductService, ColorService, EnviromentService, PurposeService, CategoryService, StatusService, ErrorService, FileService, MessageService ) {
	$scope.appTitle = "Administrador de Productos";
	$scope.submitTitle = 'Guardar';
	$scope.appTitle = "Producto";
	$scope.relativePath = '#!/' + $location.path().split('/').slice(1,2)[0];
    $scope.model =	{"name" : "products"};
    $scope.image = {};
    $scope.listRelationatedProducts = [];

    $scope.init = function() {

    	$scope.findProfileBusy = false;        
        $scope.findColors();
        $scope.findEnviroments();
        $scope.findPurposes();
        $scope.findCategories();
        $scope.findStatus();
        $scope.findProductById($stateParams.id);

    };

	$scope.findProductById = function(id) {

		ProductService.findProductRelationated(id).then(
    		function(response) {
    			//console.log(response);
    			$scope.product = response;
    			$scope.product.idColor = String(response.idColor.idColor);
    			$scope.product.idEnviroment = String(response.idEnviroment.idEnviroment);
    			$scope.product.idPurpose = String(response.idPurpose.idPurpose);
    			$scope.product.idCategory = String(response.idCategory.idCategory);
    			$scope.product.idStatus = String(response.idStatus);
    			if (response.idImage != undefined){
    				$scope.image.url =  FileService.storagePath() + response.idImage.imagefile;
    				$scope.product.idImage = response.idImage.idImage;
    			}
    				
    			$scope.listRelationatedProducts = response.relationatedProduct;

    		},
    		function(response) {
    			ErrorService.set(response);
    			//Aqui redirigir;
    			//console.log($location.path().split('/').slice(1,2)[0]+'/list');
    			$location.path($location.path().split('/').slice(1,2)[0]+'/list');
    		}
        );
    }
	


    $scope.findColors = function() {

        var colorService = ColorService;

        colorService.findAll({})	
	        .then(
	        		function(response) {
	        			$scope.colors = response;
	        		},
	        		$scope.error
	        );
       
    }
    
	$scope.findEnviroments = function() {
		
        var enviromentService = EnviromentService;
        
        var param =  {};
		param.page = 0;
		param.perPage = 0;
        
        enviromentService.findAll(param)
	        .then(
	        		function(response) {
	        			//console.log(response);
	        			$scope.enviroments = response;
	        		},
	        		$scope.error
	        );
       
    }
	
	$scope.findPurposes = function() {
		
        var purposeService = PurposeService;
        
        var param =  {};
		param.page = 0;
		param.perPage = 0;
        
        purposeService.findAll(param)
	        .then(
	        		function(response) {
	        			//console.log(response);
	        			$scope.purposes = response;

	        		},
	        		$scope.error
	        );
       
    }
	
	$scope.findCategories = function() {
		
        var categoryService = CategoryService;
        
        var param =  {};
		param.page = 0;
		param.perPage = 0;
		
        categoryService.findAll(param)
        	.then(
	        		function(response) {
	        			$scope.categories = response;
	        		},
	        		$scope.error
	        )
    }
	
	$scope.findStatus = function() {
		
        var statusService = StatusService;
        
        var param =  {};
		param.page = 0;
		param.perPage = 0;
        
        statusService.findAll(param)
	        .then(
        		function(response) {
        			//console.log(response);
        			$scope.statuses = response;
        			//$scope.count = permission.permisos;
        		},
        		$scope.error
	        );
    }

    $scope.actionSaveForm = function() {

    	$scope.product.idCategory =  parseInt($scope.product.idCategory);
    	$scope.product.idColor = parseInt($scope.product.idColor);
		$scope.product.idEnviroment = parseInt($scope.product.idEnviroment);
		$scope.product.idPurpose = parseInt($scope.product.idPurpose);
		$scope.product.idStatus = parseInt($scope.product.idStatus);
		$scope.product.relationatedProduct =  $scope.listRelationatedProducts;

    	ProductService.updateProduct($scope.product).then(
    		function(response) {
    			//console.log(response);
    			$scope.findProductById($stateParams.id);
    			MessageService.set('Registro guardado satisfactoriamente');
    		},
    		function(errResponse){
    			console.error('Error saving product');
    		}
        );
    }
    
    $scope.loadImage = function(resp){
    	//console.log(resp);
    	$scope.image.url = resp.data.imageUrl;
    	$scope.image.idImage = resp.data.idImage;
    	$scope.product.idImage = $scope.image.idImage;
    	//console.log($scope.product);
    }
    
    $scope.OnUpload = function ($event) {
    	//$event.stopPropagation(); // <-- this is important
        $timeout(function() {
        	angular.element('#upload_image').trigger('click');
        }, 0);
    };

    $scope.removeRelaProduct = function (idProduct) {

        for (var index in $scope.listRelationatedProducts){
        	if ($scope.listRelationatedProducts[index].idProductRelation == idProduct ){
        		$scope.listRelationatedProducts.splice( index, 1 )[0];
        	}
        }

    };

    //$scope.listRelationatedProducts = ProductService.getRelationatedProducts();

    /*

    $scope.actionSubmit = function() {
        if ($scope.imageChanged) {
            $scope.saveImage($scope.image);
        } else {
            $scope.actionSaveForm();
        }
    };

    $scope.saveImage = function(fileImage) {
        var image = new Image();
        image.data = {
            'image_original': fileImage.url,
            'image_small': fileImage.smallUrl,
            'image_medium': fileImage.mediumUrl,
            'image_large': fileImage.largeUrl,
            'image_name': fileImage.originalName
        };
        image.ready = $scope.saveImageReady;
        image.add();
    };

    $scope.saveImageReady = function(image) {
        $scope.imageChanged = false;
        $scope.image._id = image._id;
        $scope.actionSaveForm();
    };

    $scope.$on('uploader.add()', function(event, file) {

    });

    $scope.$on('uploader.progress()', function(event, file) {

    });

    $scope.$on('uploader.done()', function(event, file, isUploadingDone) {
        if (isUploadingDone) {
            $scope.imageChanged = true;
            $scope.image = file;
        }

        $scope.$broadcast('croper.done()');
    });*/

    $scope.init();
});



