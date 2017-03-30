'use strict';

App.controller('AdminProductControllerList', ['$scope', '$location', 'ProductService', 'CategoryService', function($scope, $location, ProductService, CategoryService) {
	var self = this;
	$scope.appTitle = "Administrador de Productos";
	$scope.products = {"perPage" : "10" , "count": 0, "list":null, "skip": 0};
	$scope.relativePath = '#!/' + $location.path().split('/').slice(1,2)[0];
	$scope.model = 'products';
	
	//console.log('AdminProductControllerList');
		
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
		
		
		//console.log("Dentro de findproducts :" + parseInt($scope.products.perPage) + '-' +  $scope.products.skip);
		
		
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
    	
    	    	
    	//console.log($scope.relativePath);
        $scope.actionCount();
        $scope.findProducts();
        $scope.findCategories();
        //console.log('fin');

        
    };
    $scope.init();
	
          

}]);


App.controller('AdminProductControllerNew', function($scope, $location, ProductService, ColorService, EnviromentService, PurposeService, CategoryService, StatusService, $rootScope, $timeout) {
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
        $scope.submitTitle = 'guardar';
        $scope.findColors();
        $scope.findEnviroments();
        $scope.findPurposes();
        $scope.findCategories();
        $scope.findStatus();
        //$scope.findProfileBusy = false;
        //if the datepicker is not seted, it resets the date to 01/01/1970 for default
        //$scope.adminNewborn.birthdate = moment(new Date()).format('YYYY-MM-DD');
    };
    
    $scope.findColors = function() {    	
    	
        var colorService = ColorService;
        
        colorService.findAll(0,0)	
	        .then(
	        		function(response) {
	        			//console.log(response);
	        			$scope.colors = response;
	        			//$scope.count = permission.permisos;
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
	        			//console.log(response);
	        			$scope.enviroments = response;
	        			//$scope.count = permission.permisos;
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
		console.log('borro los errores: ' + $rootScope.errors);
    }
	
	
	$scope.actionSubmit = function() {
		
		$timeout($scope.deleteErrors, 4000);
		
		/*if ($rootScope.errors){
			$rootScope.errors = null;
		}*/
		
		
		//console.log($scope.form);    
        //console.log($rootScope.errors);
        //$rootScope.errors = null;
        
        
		/*var isValid = true;

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
        }*/
    };
	

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

    $scope.actionSaveForm = function() {
        if (!$scope.isSaving) {
            $scope.isSaving = true;

            var adminNewborn = new Newborn();

            adminNewborn.data = {
                'name': $scope.adminNewborn.name,
                'ref_profile': $scope.adminNewborn.ref_profile._id,
                'ref_image': $scope.image._id,
                'birthdate': $scope.birthdate,
                'sex': $scope.adminNewborn.sex,
                'weight': $scope.adminNewborn.weight,
                'height': $scope.adminNewborn.height,
                'birth_place': $scope.adminNewborn.birth_place
            }

            adminNewborn.ready = $scope.actionSubmitReady;
            adminNewborn.add();
        }
    };

    $scope.actionSubmitReady = function(adminNewborn) {
        $location.path('admin-newborn/edit/' + adminNewborn._id);
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


