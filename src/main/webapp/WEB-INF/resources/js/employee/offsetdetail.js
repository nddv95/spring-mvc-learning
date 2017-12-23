angular.module('library').controller('empOffsetDetailCtrl',
		function($scope, $http, $timeout, $window) {
			$scope.message = '';
			$scope.showMessage = false;
			$scope.offset = {};
			$scope.borrow = {};
			
			//get borrow by id
			var loadBorrow = function(id){
				$http({
					url : '/13110194_NguyenDucDuongViet_03/getBorrow/' + id,
					method : 'GET',
				}).then(function success(response) {
					if (response.data.status == '200') {
						$scope.borrow = response.data.data;
					}
				}, function error(response) {

				});
			};
			
			//load data
			$scope.init = function(id) {;
				$http({
					url : '/13110194_NguyenDucDuongViet_03/getBookOffset/' + id,
					method : 'GET',
				}).then(function success(response) {
					if (response.data.status == '200') {
						$scope.offset = response.data.data;
						loadBorrow(id);
					}
				}, function error(response) {

				});
			};
		});