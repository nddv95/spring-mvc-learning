angular.module('library').controller('adminAddUserCtrl', function($scope, $http, $timeout, $window){
	$scope.user = {};
	$scope.showMess = false;
	$scope.canSave = true;
	$scope.message = '';
	
	//save user
	$scope.save = function(){
		if(($scope.user.username === undefined)||($scope.user.username === null)){
			$scope.showMess = true;
			$scope.message = 'Tên đăng nhập không được để trống';
			return;
		}
		if(($scope.user.password === undefined)||($scope.user.password === null)){
			$scope.showMess = true;
			$scope.message = 'Mật khẩu không được để trống';
			return;
		}
		if(($scope.user.role === undefined)||($scope.user.role === null)){
			$scope.showMess = true;
			$scope.message = 'Loại tài khoản không được để trống';
			return;
		}
		$scope.showMess = false;
		$http({
			url : '/13110194_NguyenDucDuongViet_03/saveOrUpdateUser',
			method : 'POST',
			data : $scope.user
		}).then(function success(response) {
			if (response.data.status == '200') {
				$scope.showMess = true;
				$scope.message = 'Lưu thành công. Tự động chuyển về màn hình quản lý user sau 3s.';
				$timeout(function(){
					$window.location.href = '/13110194_NguyenDucDuongViet_03/admin/users';
				}, 3000);
			}else{
				$scope.showMess = true;
				$scope.message = 'Đã xãy ra lỗi, kiểm tra lại thông tin';
				$timeout(function(){
					$scope.showMess = false;
				}, 3000);
			}
		}, function error(response) {
			$scope.showMess = true;
			$scope.message = 'Đã xãy ra lỗi khi kết nối đến server';
			$timeout(function(){
				$scope.showMess = false;
			}, 3000);
		});
	};
	
	//check username
	$scope.check = function(){
		if(($scope.user.username === undefined)||($scope.user.username === null)){			
			return;
		}
		$http({
			url : '/13110194_NguyenDucDuongViet_03/checkUsername/' + $scope.user.username,
			method : 'GET'
		}).then(function success(response) {
			if (response.data.status == '403') {
				$scope.showMess = true;
				$scope.message = 'Tên người dùng đã tồn tại';
			}else{
				$scope.showMess = false;
			}
		}, function error(response) {
		
		});
	};
	
	$scope.today = function() {
		$scope.user.dateOfBirth = new Date();

	};
	$scope.today();

	$scope.user.dateOfBirth = new Date();
	$scope.clear = function() {
		$scope.user.dateOfBirth = new Date();
	};

	$scope.inlineOptions = {
		showWeeks : true
	};

	$scope.dateOptions = {
		formatYear : 'yy',
		maxDate : new Date(2020, 5, 22),
		minDate : new Date(1900,1,1),
		startingDay : 1
	};


	$scope.open1 = function() {
		$scope.popup1.opened = true;
	};

	$scope.open2 = function() {
		$scope.popup2.opened = true;
	};

	$scope.altInputFormats = [ 'M!/d!/yyyy' ];

	$scope.popup1 = {
		opened : false
	};

	$scope.popup2 = {
		opened : false
	};


});