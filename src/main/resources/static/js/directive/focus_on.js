angular.module("comun").directive("focusOn", function($timeout) {
	return {
		restrict: "A",
		link: function(scope, element, attrs) {
			scope.$on(attrs.focusOn, function(e) {
				$timeout((function() {
					element[0].focus();
				}), 10);
			});
		}
	};
});