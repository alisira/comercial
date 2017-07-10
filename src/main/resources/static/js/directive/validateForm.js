angular.module('comun').directive('validateForm', function($location, $anchorScroll, $timeout){
	return {
		restrict: 'A',
		require: 'ngModel',
		link: function(scope,  element, attrs, model){
			
			scope.closeAlert = function(index) {
				scope.alerts.splice(index, 1);
			};

			scope.$watch('formSubmitted', function(obj, objOld) {
				
				if (scope.formSubmitted){
					var myForm = scope.form;
					
					if (myForm.$valid) {
						
						scope.alerts = [		    
						    { type: 'danger', msg: 'Se procede a guardar el registro, favor esperar, gracias' }
						];
						
						$timeout(function myFunction() {
							model.$viewValue();
						},700);
					}else{
						var sw=true;
						
						angular.forEach(myForm, function(value, key) {
							//console.log(value);
							if (typeof value === 'object' && value.$invalid && sw){

								var comun =  'Campo: ' + element.context.elements[key].getAttribute("nombre");

								var mensaje = '';
								if (value.$error.url) {
									mensaje = comun + ' no tiene tiene formato de pagina web correcto, favor corregir, gracias';
								}else if  (value.$error.pattern) {
									mensaje = comun + ' no tiene el formato correcto (' + element.context.elements[key].getAttribute("mensaje") +' ) favor corregir, gracias';
								}else if  (value.$error.maxlength) {
									mensaje = comun + ' ha excedido la longitud máxima, favor corregir, gracias';
								}else if  (value.$error.minlength) {
									mensaje = comun + ' no tiene la longitud mínima, favor corregir, gracias';
								}else if  (value.$error.email) {
									mensaje = comun + ' no tiene el formato de correo electrónico, favor corregir, gracias';
								}else{
									mensaje = comun + ' no ingresado, favor corregir, gracias';									
								}
								
								scope.alerts = [{ type: 'danger', msg: mensaje}];								

								scope.$broadcast(value.$name);
								sw = false;//Switch para que no entre de nuevo en este if dado que no hay una sentencia break en angular.forEach
							}
						});
						
						//console.log(myForm)
						
						//Si llega aqui true es porq no pudo identificar cual es el nombre del campo que esta ocasionando el error 
						if (sw){
							mensaje = 'Faltan datos en el formulario favor revisar detenidamente, gracias'
							scope.alerts = [{ type: 'danger', msg: mensaje}];
						}
						
						scope.formSubmitted = false;
					}
				}
				
				
				$location.hash();
				$anchorScroll();
			});
		}
	}
});