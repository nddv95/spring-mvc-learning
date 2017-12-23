angular.module('library').controller('empBorrowDetailCtrl',
		function($scope, $http, $timeout, $window) {
			$scope.message = '';
			$scope.showMessage = false;
			$scope.borrow = {};
			$scope.borrowGet = {};
			$scope.init = function(id) {
				
				$http({
					url : '/13110194_NguyenDucDuongViet_03/getBorrowDetail/' + id,
					method : 'GET',
				}).then(function success(response) {
					if (response.data.status == '200') {
						$scope.borrow = response.data.data;
					}else{
						$scope.borrow.books = [];
						$scope.message = 'Tất cả sách đã trả hết, tự động chuyển đến danh sách mượn...';
						$scope.showMessage = true;
						$timeout(function(){
							$window.location.href = '/13110194_NguyenDucDuongViet_03/borrow';
						}, 3000);
					}

				}, function error(response) {

				});
				$scope.borrowGet = $scope.borrow;
			};
			$scope.return = function(bookId){
				$http({
					url : '/13110194_NguyenDucDuongViet_03/returnBook',
					method : 'POST',
					data: {
						borrowId: $scope.borrow.id,
						bookId: bookId
					}
				}).then(function success(response) {
					if (response.data.status == '200') {
						$scope.init($scope.borrow.id);
						$scope.message = 'Trả sách thành công';
						$scope.showMessage = true;
						$timeout(function(){
							$scope.showMessage = false;
						},3000);
					}else{
						$scope.message = 'Đã xảy ra lỗi trong quá trình cập nhật dữ liệu!';
						$scope.showMessage = true;
						$timeout(function(){
							$scope.showMessage = false;
						},3000);
					}

				}, function error(response) {
					$scope.message = 'Đã xảy ra lỗi trong quá trình cập nhật dữ liệu!';
					$scope.showMessage = true;
					$timeout(function(){
						$scope.showMessage = false;
					},3000);
				});
			};
			
			$scope.returnAll = function(){
				$http({
					url : '/13110194_NguyenDucDuongViet_03/returnBook/' + $scope.borrow.id,
					method : 'GET',
				}).then(function success(response) {
					if (response.data.status == '200') {
						$scope.borrow.books = [];
						$scope.message = 'Tất cả sách đã trả hết, tự động chuyển đến danh sách mượn...';
						$scope.showMessage = true;
						$timeout(function(){
							$window.location.href = '/13110194_NguyenDucDuongViet_03/borrow';
						}, 3000);
					}else{
						$scope.message = 'Đã xảy ra lỗi trong quá trình cập nhật dữ liệu!';
						$scope.showMessage = true;
						$timeout(function(){
							$scope.showMessage = false;
						},3000);
					}

				}, function error(response) {
					$scope.message = 'Đã xảy ra lỗi trong quá trình cập nhật dữ liệu!';
					$scope.showMessage = true;
					$timeout(function(){
						$scope.showMessage = false;
					},3000);
				});
			};
		});