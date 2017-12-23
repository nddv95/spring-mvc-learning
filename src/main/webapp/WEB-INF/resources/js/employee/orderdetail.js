angular.module('library').controller('empOrderDetailCtrl',
		function($scope, $http, $window, $timeout) {
			$scope.order = {};
			$scope.orderGet = {};
			$scope.message = '';
			$scope.showMessage = false;
			
			// init when page load
			$scope.init = function(id) {
				$http({
					url : '/13110194_NguyenDucDuongViet_03/getOrder/' + id,
					method : 'GET',
				}).then(function success(response) {
					if (response.data.status == '200') {
						$scope.order = response.data.data;
					}else{
						$scope.order.books = [];
						$scope.message = 'Tất cả sách đặt đã xóa hết, thông tin đặt sách sẽ bị hủy! Chuyển đến danh sách đặt sau 3s...';
						$scope.showMessage = true;
						$timeout(function(){
							$window.location.href = '/13110194_NguyenDucDuongViet_03/order';
						}, 3000);
					}

				}, function error(response) {

				});
				$scope.orderGet = $scope.order;
			};
			
			// delete a order detail
			$scope.delete = function(bookId){
				$http({
					url : '/13110194_NguyenDucDuongViet_03/deteteOrderDetail',
					method : 'POST',
					data: {orderId: $scope.order.id, bookId: bookId}})
					.then( function success(response) {
						if(response.data.status == '200'){
							$scope.init($scope.order.id);
							$scope.message = 'Xóa thành công!';
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
		});