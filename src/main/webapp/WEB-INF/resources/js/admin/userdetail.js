angular.module('library').controller('adminUserDetailCtrl', function($scope, $http, $timeout){
	$scope.user = {};
	$scope.showMess = false;
	$scope.role = {
			  '0' : 'Admin',
			  '1' : 'Sinh viên',
			  '2' : 'Nhân viên'
			};
	$scope.init = function(id) {
		$http({
			url : '/13110194_NguyenDucDuongViet_03/findUserById/' + id,
			method : 'GET'
		}).then(function success(response) {
			if (response.data.status = '200') {
				$scope.user = response.data.data;
				
			}
		}, function error(response) {
		
		});
	};

});