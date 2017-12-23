angular.module('library').controller('empOrderListCtrl', function($scope, $http){
	$scope.orders = [];
	$scope.nodata = false;
	var init = function() {
		$http({
			url : '/13110194_NguyenDucDuongViet_03/getAllOrder',
			method : 'GET'
		}).then(function success(response) {
			if (response.data.status = '200') {
				$scope.orders = response.data.data;
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