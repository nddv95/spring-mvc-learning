angular.module('library').controller('adminUsersCtrl', function($scope, $http, $timeout){
	$scope.users = [];
	$scope.showMess = false;
	$scope.message = '';
	
	var init = function() {
		$http({
			url : '/13110194_NguyenDucDuongViet_03/findAllUser',
			method : 'GET'
		}).then(function success(response) {
			if (response.data.status = '200') {
				$scope.users = response.data.data;
				
			}
		}, function error(response) {
		
		});
	};
	init();
	
	$scope.role = {
			  '0' : 'Admin',
			  '1' : 'Sinh viên',
			  '2' : 'Nhân viên'
			};

	$scope.delete = function(id){
		$http({
			url : '/13110194_NguyenDucDuongViet_03/deleteUser/' + id,
			method : 'GET'
		}).then(function success(response) {
			if (response.data.status = '200') {
				console.log(response.data);
				init();				
				$scope.message = 'Xóa thành công!';	
				$scope.showMess = true;
				$timeout(function(){
					$scope.showMess = false;
				}, 3000);
			} else{
				$scope.message = 'Xóa thất bại!';
				$timeout(function(){
					$scope.showMess = false;
				}, 3000);
			}
		}, function error(response) {
			$scope.message = 'Xảy ra lỗi khi kết nối đến server!';
			$timeout(function(){
				$scope.showMess = false;
			}, 3000);
		});
	};
});