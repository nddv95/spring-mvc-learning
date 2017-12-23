angular.module('library').controller('empOffsetCtrl',
		function($scope, $http, $window) {
			// $scope.test = function(){
			// $window.location.href
			// ='/13110194_NguyenDucDuongViet_03/order';
			// };
			$scope.offsets = [];
			$scope.nodata = false;
			var init = function() {
				$http({
					url : '/13110194_NguyenDucDuongViet_03/getAllBookOffset',
					method : 'GET'
				}).then(function success(response) {
					if (response.data.status = '200') {
						$scope.offsets = response.data.data;
						$scope.nodata = false;
					} else {
						$scope.nodata = true;
					}
				}, function error(response) {
					$scope.nodata = true;
				});
			};
			init();

		});