App.directive('textToNumber', function(){
    return{
        restrict: 'A',
        require: 'ngModel',
        link: function(scope, element, attr, mCtrl){
        	mCtrl.$parsers.push(function(value){            	
            	value = Number(value);
            	return value;
            });
        	mCtrl.$formatters.push(function(value){            	
            	value = Number(value);
            	return value;
            });
        }
    };
});

