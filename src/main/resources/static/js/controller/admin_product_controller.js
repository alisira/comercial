'use strict';

App.controller('AdminProductControllerList', ['$scope', '$location', '$rootScope', 'ProductService', 'CategoryService', '$timeout', function($scope, $location, $rootScope, ProductService, CategoryService, $timeout) {
	var self = this;
	$scope.appTitle = "Administrador de Productos";	
	$scope.products = {"list":null};
	$scope.relativePath = '#!/' + $location.path().split('/').slice(1,2)[0];
	$scope.model =	{"name" : "products" , "perPage" : "10", "page":1, "count": 0};
	var param =  {};
	$rootScope.errors = null;

	$scope.error = function(responseError) {
		if (!$rootScope.errors){
			$rootScope.errors = [];	
		}
		$rootScope.errors.push("Disculpe las molestia, ocurrio el siguiente error de sistema status=" + responseError.data.status + "-" + responseError.data.error + " en: " + responseError.data.path);
		//$timeout($scope.resetErrors, 6000);
	}

	$scope.resetErrors = function() {
		$rootScope.errors = [];
    }
	
	$scope.actionCount = function(param) {
        var productService = ProductService;        
        productService.count(param).then($scope.actionReadyCount, $scope.error);
    }

	$scope.actionReadyCount = function(response) {
		$scope.model.count = parseInt(response.count);
	}

	$scope.findCategories = function() {
        var categoryService = CategoryService;        
        categoryService.findAll()
	        .then(
        		function(response) {
        			$scope.categories = response;
        		},
        		$scope.error
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

		ProductService.findAll(param)
	        .then(
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


App.controller('AdminProductControllerNew', function($scope, $location, ProductService, ColorService, EnviromentService, PurposeService, CategoryService, StatusService, $rootScope, $timeout) {
	$scope.submitTitle = 'Guardar';
	$scope.appTitle = "Producto";
	$scope.relativePath = '#!/' + $location.path().split('/').slice(1,2)[0];	
	
	$scope.friendSkip = 0;
    $scope.friendLimit = 10;
    $scope.fileImage = '';
    $scope.image = {};
    $scope.image.url = 'http://placehold.it/200x200';
    $scope.adminNewborn = {};
    $scope.birthdate = new Date();
    $scope.adminNewborn.ref_profile = {};

    $scope.init = function() {
        
        $scope.findColors();
        $scope.findEnviroments();
        $scope.findPurposes();
        $scope.findCategories();
        $scope.findStatus();
        //$scope.adminNewborn.birthdate = moment(new Date()).format('YYYY-MM-DD');
    };
    
    $scope.findColors = function() {    	
    	
        var colorService = ColorService;
        
        colorService.findAll(0,0)	
	        .then(
	        		function(response) {
	        			$scope.colors = response;
	        		},
	        		function(errResponse){
	        			console.error('Error getting colors');
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
	        			console.error('Error counting Enviroment');
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
	        			console.error('Error counting Purpose');
	        		}
	        );
       
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
	
	$scope.findStatus = function() {
		
        var statusService = StatusService;
        
        statusService.findAll(0,0)	
	        .then(
	        		function(response) {
	        			//console.log(response);
	        			$scope.statuses = response;
	        			//$scope.count = permission.permisos;
	        		},
	        		function(errResponse){
	        			console.error('Error counting products');
	        		}
	        );
       
    }
	


	$scope.deleteErrors = function() {
		$rootScope.errors = false;
		//console.log('borro los errores: ' + $rootScope.errors);
    }

	$scope.actionSubmit = function() {
		
		if ($rootScope.errors){
			$timeout($scope.deleteErrors, 4000);
		}
		
    };
    
    $scope.actionSaveForm = function() {
    	
    	//console.log($scope.product);
    	ProductService.createProduct($scope.product).then(
        		function(response) {
        			//console.log(response);        			
        			//console.log($scope.relativePath + '/edit/'+ response.id);
        			$location.path($location.path().split('/').slice(1,2)[0] + '/edit/'+ response.id);
        			//$scope.statuses = response;
        			//$scope.count = permission.permisos;
        		},
        		function(errResponse){
        			console.error('Error saving product');
        		}
        );
    }
    
	

    /*$scope.isSaving = false;
     * 
     * 
     * 
     * 

    $scope.actionSubmit = function() {
        var isValid = true;

        if ($.trim($scope.adminNewborn.ref_profile.full_name) == '') {
            isValid = false;
        }

        if ($.trim($scope.adminNewborn.name) == '') {
            isValid = false;
        }

        if (isValid) {
            $scope.saveImage($scope.fileImage);
        } else {
            $.bootstrapGrowl('Por favor complete el formulario', {
                type: 'danger',
                allow_dismiss: false,
                offset: {
                    from: 'bottom',
                    amount: 20
                },
                align: 'left'
            });
        }
    };
    

    $scope.findProfileAction = function() {
        //Valida si no hay una busqueda en ejecucion
        if (!$scope.findProfileBusy) {
            if ($scope.adminNewborn.ref_profile.full_name.length > 0) {
                $scope.findProfileBusy = true;
                $scope.findProfile($scope.adminNewborn.ref_profile.full_name);
            }
        }
    };

    $scope.findProfile = function(fullName) {
        var profile = new Friend();
        if (fullName != undefined && fullName.length > 2) {
            profile.params = {
                'fields': '_id, full_name, ref_user, ref_image, anexo, area, position, total_friend, total_post,follow_always',
                'ref[user][fields]': 'google_email',
                'ref[image][fields]': 'image_original, image_name',
                'search[and][full_name]': '*' + fullName + '*',
                'limit': false,
                'search[and][active]': true,
                'cache': true
            };
            profile.ready = $scope.findProfileReady;
            profile.findAll();
        }

    };

    $scope.findProfileReady = function(aryProfile) {
        if (Array.isArray(aryProfile)) {
            $scope.aryProfile = aryProfile;
        } else {
            $scope.aryProfile = new Array(aryProfile);
        }

        $scope.findProfileBusy = false;

    };

    $scope.selectProfile = function(idProfile, fullName) {
        $scope.adminNewborn.ref_profile._id = idProfile;
        $scope.adminNewborn.ref_profile.full_name = fullName;
        $scope.aryProfile = null;
    }

    $scope.$on('uploader.add()', function(event, file) {

    });

    $scope.$on('uploader.progress()', function(event, file) {

    });

    $scope.$on('uploader.done()', function(event, file, isUploadingDone) {
        if (isUploadingDone) {
            $scope.fileImage = file;
            $scope.image = file;
        }

        $scope.$broadcast('croper.done()');
    });

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
        $scope.image = image;
        $scope.actionSaveForm();
    };

    $scope.changeGender = function() {
        if ($scope.fileImage == '' ||  $scope.fileImage.originalName == 'default') {
            var image_url = $scope.adminNewborn.sex == 0 ? 'img/default_girl.jpg' : 'img/default_boy.jpg';

            $scope.fileImage = {
                'url': image_url,
                'smallUrl': image_url,
                'mediumUrl': image_url,
                'largeUrl': image_url,
                'originalName': 'default'
            };
        }
    }*/

    $scope.init();
});

/**
 * Controller AdminProductControllerEdit
 * @param {scope} $scope DOM manipulation
 * @param {stateParams} $stateParams
 * @param {ProductService} ProductService factory
 */
App.controller('AdminProductControllerEdit', function($scope, $location, $stateParams, ProductService, ColorService, EnviromentService, PurposeService, CategoryService, StatusService, $rootScope, $timeout) {
	$scope.appTitle = "Administrador de Productos";
	$scope.submitTitle = 'Guardar';
	$scope.appTitle = "Producto";
	$scope.relativePath = '#!/' + $location.path().split('/').slice(1,2)[0];
    $scope.model =	{"name" : "products"};    
    $rootScope.errors = null;

	$scope.error = function(responseError) {
		//console.log(responseError);		
		if (!$rootScope.errors){
			$rootScope.errors = [];	
		}
		$rootScope.errors.push("Disculpe las molestia, ocurrio el siguiente error de sistema status=" + responseError.data.status + "-" + responseError.data.error + " en: " + responseError.data.path);
		//$timeout($scope.resetErrors, 6000);
	}

	$scope.resetErrors = function() {
		$rootScope.errors = [];
    }

    $scope.init = function() {

    	$scope.findProfileBusy = false;        
        $scope.findColors();
        $scope.findEnviroments();
        $scope.findPurposes();
        $scope.findCategories();
        $scope.findStatus();
        $scope.findProduct($stateParams.id);        

    };

	$scope.findProduct = function(id) {

		ProductService.findProduct(id).then(
        		function(response) {
        			$scope.product = response;
        			$scope.product.idColor = String(response.idColor.idColor);
        			$scope.product.idEnviroment = String(response.idEnviroment.idEnviroment);
        			$scope.product.idPurpose = String(response.idPurpose.idPurpose);
        			$scope.product.idCategory = String(response.idCategory.idCategory);
        			$scope.product.idStatus = String(response.status);        			
        		},
        		$scope.error
        );
    }

    $scope.findColors = function() {

        var colorService = ColorService;

        colorService.findAll(0,0)	
	        .then(
	        		function(response) {
	        			$scope.colors = response;
	        		},
	        		$scope.error
	        );
       
    }
    
	$scope.findEnviroments = function() {
		
        var enviromentService = EnviromentService;
        
        enviromentService.findAll(0,0)	
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
        
        purposeService.findAll(0,0)	
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
        
        categoryService.findAll()
        	.then(
	        		function(response) {
	        			$scope.categories = response;
	        		},
	        		$scope.error
	        )    
       
    }
	
	$scope.findStatus = function() {
		
        var statusService = StatusService;
        
        statusService.findAll(0,0)	
	        .then(
        		function(response) {
        			//console.log(response);
        			$scope.statuses = response;
        			//$scope.count = permission.permisos;
        		},
        		$scope.error
	        );
    }
	
	
	$scope.deleteErrors = function() {		        
		$rootScope.errors = false;
		//console.log('borro los errores: ' + $rootScope.errors);
    }

	$scope.actionSubmit = function() {
		
		if ($rootScope.errors){
			$timeout($scope.deleteErrors, 4000);
		}
		
    };
    
    $scope.actionSaveForm = function() {
    	
    	$scope.product.idCategory =  parseInt($scope.product.idCategory);
    	$scope.product.idColor = parseInt($scope.product.idColor);
		$scope.product.idEnviroment = parseInt($scope.product.idEnviroment);
		$scope.product.idPurpose = parseInt($scope.product.idPurpose);		
		$scope.product.idStatus = parseInt($scope.product.status);
		//$scope.product.createdAt  = moment(new Date()).local().format("YYYY-MM-DDTHH:mm:ss");
    	
    	ProductService.updateProduct($scope.product).then(
    		function(response) {
    			//console.log(response);
    			$scope.findProduct($stateParams.id);
    		},
    		function(errResponse){
    			console.error('Error saving product');
    		}
        );
    }
	
    

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


