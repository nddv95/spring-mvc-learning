angular.module('library').controller('empBookListCtrl', function($scope, $http){
	$scope.books = [];
	$scope.nodata = false;
	var init = function() {
		$http({
			url : '/13110194_NguyenDucDuongViet_03/getBooks',
			method : 'GET'
		}).then(function success(response) {
			if (response.data.status = '200') {
				$scope.books = response.data.data;
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