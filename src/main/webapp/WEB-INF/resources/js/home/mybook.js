angular
		.module('library')
		.controller(
				'mybookCtrl',
				function($scope, $http, $timeout) {
					$scope.orderDetail = {};
					$scope.borrowDetail = {};
					$scope.showTip = false;
					$scope.showMessage = false;
					$scope.showFooter = false;
					$scope.showFooterBorrow = false;
					$scope.message = '';
					var init = function() {
						$http(
								{
									url : '/13110194_NguyenDucDuongViet_03/getOrderListByUser',
									method : 'GET'
								})
								.then(
										function success(response) {
											if (response.data.status == '200') {
												$scope.orderDetail = response.data.data;
												$scope.orderDetail.dateOrder = fomat($scope.orderDetail.dateOrder);
												$scope.orderDetail.dateEnd = fomat($scope.orderDetail.dateEnd);
												$scope.showTip = true;
												$scope.showFooter = false;
											}else{
												$scope.showTip = false;
												$scope.showFooter = true;
												$scope.orderDetail.books = [];
											}

										}, function error(response) {

										});
						$http(
								{
									url : '/13110194_NguyenDucDuongViet_03/getBorrowListByUser',
									method : 'GET'
								})
								.then(
										function success(response) {
											if (response.data.status == '200') {
												$scope.borrowDetail = response.data.data;
												$scope.borrowDetail.dateBorrow = fomatDDMMYYY($scope.borrowDetail.dateBorrow);
												$scope.borrowDetail.dateReturn = fomatDDMMYYY($scope.borrowDetail.dateReturn);
												// $scope.orderDetail.dateOrder
												// =
												// fomat($scope.orderDetail.dateOrder);
												// $scope.orderDetail.dateEnd =
												// fomat($scope.orderDetail.dateEnd);
												// $scope.showTip = true;
												// $scope.showFooter = false;
												$scope.showFooterBorrow = false;
											}else{
												// $scope.showTip = false;
												// $scope.showFooter = true;
												// $scope.orderDetail.books =
												// [];
												$scope.showFooterBorrow = true;
											}

										}, function error(response) {

										});
					}
					init();
					
					// delete a order detail
					$scope.delete = function(bookId){
						$http(
								{
									url : '/13110194_NguyenDucDuongViet_03/deteteOrderDetail',
									method : 'POST',
									data: {
										orderId: $scope.orderDetail.id,
										bookId: bookId
									}
								})
								.then(
										function success(response) {
											if (response.data.status == '200') {
												init();
												$scope.message = 'Xóa thành công';
												$scope.showMessage = true;
												$timeout(function(){
													$scope.showMessage = false;
												}, 3000);											
											}

										}, function error(response) {
											$scope.message = 'Đã xãy ra lỗi khi kết nối tới server';
											$scope.showMessage = true;
											$timeout(function(){
												$scope.showMessage = false;
											}, 3000);
										});
					};

					// convert date fomat
					function fomat(d) {
						d = new Date(d);
						var month = d.getMonth() + 1;
						return d.getDate() + '/' + month + '/'
								+ d.getFullYear() + ', ' + d.getHours() + 'h'
								+ d.getMinutes();
					}
					;
					
					// convert date fomat
					function fomatDDMMYYY(d) {
						d = new Date(d);
						var month = d.getMonth() + 1;
						return d.getDate() + '/' + month + '/'
								+ d.getFullYear()
					}
					;
					
					// convert date fomat
					function countDownTime(dateEnd) {
						dateEnd = new Date(dateEnd);
						var month = d.getMonth() + 1;
						return d.getDate() + '/' + month + '/'
								+ d.getFullYear() + ', ' + d.getHours() + 'h'
								+ d.getMinutes();
					}
					;
				});