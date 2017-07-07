angular
.module('myApp')
.controller(
		'CertificadoCtrl',
		function($http, $scope, misMensajes, filterFilter, $window) {

			$scope.sortType     = 'nombre'; // set the default sort type
			$scope.sortReverse  = false;  // set the default sort order

			$scope.selectTableRow = function(index, storeId) {
				if ($scope.dayDataCollapse === 'undefined') {
					$scope.dayDataCollapse = $scope.dayDataCollapseFn();
				} else {

					if ($scope.tableRowExpanded === false
							&& $scope.tableRowIndexCurrExpanded === ""
								&& $scope.storeIdExpanded === "") {
						$scope.tableRowIndexPrevExpanded = "";
						$scope.tableRowExpanded = true;
						$scope.tableRowIndexCurrExpanded = index;
						$scope.storeIdExpanded = storeId;
						$scope.dayDataCollapse[index] = false;
					} else if ($scope.tableRowExpanded === true) {
						if ($scope.tableRowIndexCurrExpanded === index
								&& $scope.storeIdExpanded === storeId) {
							$scope.tableRowExpanded = false;
							$scope.tableRowIndexCurrExpanded = "";
							$scope.storeIdExpanded = "";
							$scope.dayDataCollapse[index] = true;
						} else {
							$scope.tableRowIndexPrevExpanded = $scope.tableRowIndexCurrExpanded;
							$scope.tableRowIndexCurrExpanded = index;
							$scope.storeIdExpanded = storeId;
							$scope.dayDataCollapse[$scope.tableRowIndexPrevExpanded] = true;
							$scope.dayDataCollapse[$scope.tableRowIndexCurrExpanded] = false;
						}
					}
				}
			};


			misMensajes.getFuncionarios(null, null).then(
					function(response) {
						if (response) {
							$scope.funcRes = response.data;
							$scope.viewby = '10';
							$scope.totalItems = $scope.funcRes.length;
							$scope.itemsPerPage = $scope.viewby;
							$scope.entryLimit = 10;
							$scope.maxSize = 5; // Number of
							// pager
							// buttons
							// to show
							$scope.search   = '';

							$scope.paginate = function (value) {
								var begin, end, index;
								begin = ($scope.currentPage - 1) * $scope.entryLimit;
								end = begin + $scope.entryLimit;
								index = $scope.funcRes.indexOf(value);
								return (begin <= index && index < end);
							};

							$scope.setPage = function(
									pageNo) {
								$scope.currentPage = pageNo;
							};
							$scope.pageChanged = function() {
								console
								.log('Page changed to: '
										+ $scope.currentPage);
							};
							$scope.setItemsPerPage = function(
									num) {
								$scope.itemsPerPage = num;
								$scope.currentPage = 1; // reset
								// to
								// first
								// page
							};

							$scope.$watch('currentPage + itemsPerPage', function() {
								var begin = (($scope.currentPage - 1) * $scope.entryLimit),
								end = begin + $scope.entryLimit;

								$scope.filteredFriends = $scope.funcRes.slice(begin, end);
							});

							$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);

							$scope.$watch('searchFunc', function (newVal, oldVal) {
								$scope.filtered = filterFilter($scope.funcRes, newVal);
								$scope.totalItems = $scope.filtered.length;
								$scope.noOfPages = Math.ceil($scope.totalItems / $scope.entryLimit);
								$scope.currentPage = 1;
							}, true);



							$scope.toggleDetail = function($index) {
								$scope.activePosition = $scope.activePosition == $index ? -1
										: $index;
							};

							//};

						}});

			$scope.setClickedRow = function(id) {
				$scope.selectedRow = id;

				var dato = {
						rut : $scope.selectedRow
				};

				var dato = {
						rut : 1
				};

				$scope.pdf = misMensajes.getPDF1(dato,	null).then(function(response) {
							if (response) {
								$scope.pdfOut = response.data;


								var fileName = $scope.selectedRow;
								var a = document.createElement("a");
								document.body.appendChild(a);
								a.style = "display: none";


//								var fileContent = base64.decode($scope.pdfOut.pdf);
								var myBlob = $scope.b64toBlob($scope.pdfOut.pdf, 'application/pdf', 512);
								var blobURL = ($window.URL || $window.webkitURL).createObjectURL(myBlob);
								a.download = fileName;
								a.href = blobURL;
								document.body.appendChild(a);
								a.click();
								document.body.removeChild(a);

							}
						});
			};

			$scope.b64toBlob = function(b64Data, contentType, sliceSize) {
				contentType = contentType || '';
				sliceSize = sliceSize || 512;

				var byteCharacters = atob(b64Data);
				var byteArrays = [];

				for (var offset = 0; offset < byteCharacters.length; offset += sliceSize) {
					var slice = byteCharacters.slice(offset, offset + sliceSize);

					var byteNumbers = new Array(slice.length);
					for (var i = 0; i < slice.length; i++) {
						byteNumbers[i] = slice.charCodeAt(i);
					}

					var byteArray = new Uint8Array(byteNumbers);

					byteArrays.push(byteArray);
				}

				var blob = new Blob(byteArrays, {type: contentType});
				return blob;
			};
		});

angular
.module('myApp').filter('startFrom', function () {
	return function (input, start) {
		if (input) {
			start = +start; //parse to int
			return input.slice(start);
		}
		return [];
	}
});