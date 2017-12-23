angular.module('library').controller('empHomeCtrl',
		function($scope, $http, $window) {
			// $scope.test = function(){
			// $window.location.href
			// ='/13110194_NguyenDucDuongViet_03/order';
			// };
			$scope.borrows = [];
			$scope.nodata = false;
			var init = function() {
				$http({
					url : '/13110194_NguyenDucDuongViet_03/getAllBorrow',
					method : 'GET'
				}).then(function success(response) {
					if (response.data.status = '200') {
						$scope.borrows = response.data.data;
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