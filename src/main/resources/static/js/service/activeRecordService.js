/**
 * Service activeRecordService
 * All Factories extends this Service
 * @param {http} $http module for HTTP/REST requests
 */
App.factory('activeRecordService', function($http, $q, ErrorService) {

	function encodeUrl(param){

		var str = Object.keys(param).map(function(key){
			return encodeURIComponent(key) + '=' + encodeURIComponent(param[key]);
		}).join('&');

		if (str){
			str = '?' + str;
		}

		return str;
	}
	
	
    function activeRecordService() {
        /**
         * Model name of the Factory
         * @type String 
         */
        this.model = '';
        /**
         * Database item ID
         * @type String
         */
        this.id = '';
        /**
         * Parameters to be used on GET requests
         * Methods "findAll" and "findById"
         * @example /post?search[title]=hello
         * @example params.search.title
         * @type Object
         */
        this.params = {};
        /**
         * Data to be used on the body part of POST and PUT requests
         * Methods "add" and "update"
         * @example params.search.title
         * @type Object
         */
        this.data = {};
        /**
         * Method used for Callback on sucess requests
         * @returns {Object/Array} mixed JSON objects
         */
        this.ready = function() {};
        /**
         * Method used for Callback on request errors
         * @returns {Object} JSON object
         */
        this.error = function() {};

        /**
         * Method findAll
         * @returns {Array} JSON array
         */
        
    	this.findAll = function(param){

    		return $http.get(this.model +  encodeUrl(param)).then(
    			function(response){
    				if (response.status == 500){
    					return $q.reject(response);
    				}else{

    					if (response.data.content)        				
    						return response.data.content;
            			else{
                			if (Array.isArray(response.data)) {
                				if (response.data.length == 1){
                					return response.data[0];
                				}else{
                					return response.data;
                				}
                			}else{
                				return response.data;
                			}
            				
            				
            			}        				
            				
    				}	
    					
    			},
    			function(errResponse){
    				return $q.reject(errResponse);
    			}
    		);
    	};
    	
    	this.count = function(param){
    		
    		return $http.get(this.model+'/count'+encodeUrl(param)).then(
    			function(response){
    				
    				if (response==undefined){
    					msg="Error de Aplicación Favor comunicarse con el administrador, gracias"
    					ErrorService.setFormError(msg);
    					return $q.rejectFormError(msg);
    				}else{    					
    					return response.data.count;
    				}
    				
    			},
    			function(errResponse){
    				//console.log(errResponse);
    				ErrorService.set(response);
    				return $q.reject(errResponse);
    			}
    		);
    	};
    	
    	
    	this.save = function(data){
    		//console.log(data);    		
    		return $http.post(this.model, data)
    		.then(
    				function(response){
    					console.log(response.data);
    					return response.data;
    				}, 
    				function(errResponse){
    					return $q.reject(errResponse);
    				}
    		);
    	}
    	
    	this.update2 = function(param){
    		return $http.put(this.model, param)
    		.then(
    				function(response){
    					//console.log(response.data);
    					return response.data;
    				}, 
    				function(errResponse){
    					console.error('Registrando XX');
    					return $q.reject(errResponse);
    				}
    		);
    	}
        
        
        this.findAll2 = function() {
            var rand = Math.random();
            var url = '/api/' + this.model + '?_cache=' + rand.valueOf();
            $http.get(url, {
                params: this.params
            }).success(this.ready).error(this.error);
        };

        this.findAllActive = function() {
            var rand = Math.random();
            this.params =   {
                'search[and][active]': true
            };
            var url = '/api/' + this.model + '?_cache=' + rand.valueOf();
            $http.get(url, {
                params: this.params
            }).success(this.ready).error(this.error);
        };

        this.findOne = function() {
            var rand = Math.random();
            var url = '/api/' + this.model + '?_cache=' + rand.valueOf();
            this.params.limit = 1;
            $http.get(url, {
                params: this.params
            }).success(this.ready).error(this.error);
        };

        this.findFirstOne = function() {
            var rand = Math.random();
            var url = '/api/' + this.model + '?_cache=' + rand.valueOf();
            this.params.limit = 1;
            this.params.sort = '_id';
            $http.get(url, {
                params: this.params
            }).success(this.ready).error(this.error);
        };

        this.findLastActiveOne = function() {
            var rand = Math.random();
            var url = '/api/' + this.model + '?_cache=' + rand.valueOf();
            this.params =   {
                'search[and][active]': true
            };
            this.params.limit = 1;
            this.params.sort = '-_id';
            $http.get(url, {
                params: this.params
            }).success(this.ready).error(this.error);
        };

        this.findLastOne = function() {
            var rand = Math.random();
            var url = '/api/' + this.model + '?_cache=' + rand.valueOf();
            this.params.limit = 1;
            this.params.sort = '-_id';
            $http.get(url, {
                params: this.params
            }).success(this.ready).error(this.error);
        };

        /**
         * Method findById
         * @returns {Object} JSON object
         */
        this.findById = function() {
            var rand = Math.random();
            var url = '/api/' + this.model + '/' + this.id + '?_cache=' + rand.valueOf();
            $http.get(url, {
                params: this.params
            }).success(this.ready).error(this.error);
        };

        /**
         * Method add
         * @returns {Object} JSON object
         */
        this.add = function() {
            var url = '/api/' + this.model;
            $http.post(url, this.data).success(this.ready).error(this.error);
        };

        /**
         * Method update
         * @returns {Object} JSON object
         */
        this.update = function() {

            var url = '/api/' + this.model + '/' + this.id;
            $http.put(url, this.data).success(this.ready).error(this.error);
        };

        /**
         * Method delete
         * @returns {Object} JSON object
         */
        this.delete = function() {

            var url = '/api/' + this.model + '/' + this.id;
            console.log(this.data);
            $http.delete(url, this.data).success(this.ready).error(this.error);
        };
    }

    return new activeRecordService();
});