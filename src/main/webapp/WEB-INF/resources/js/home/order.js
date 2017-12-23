angular
		.module('library')
		.controller(
				'orderCtrl',
				function($scope, $http, $window, $location) {
					$scope.orderOrginal = {};
					$scope.order = {};
					$scope.error = false;
					$scope.deleteSuccess = false;
					$scope.deleteFail = false;
					var init = function() {
						$http({
							url : '/13110194_NguyenDucDuongViet_03/getOrderDetail',
							method : 'GET'
						})
								.then(
										function success(response) {
											if (response.data.status == '200') {
												$scope.orderOrginal = response.data.data;
												$scope.order.username = $scope.orderOrginal.user.username;
												$scope.order.fullName = $scope.orderOrginal.user.fullName;
												$scope.orderOrginal.dateOfBirth == null ? $scope.order.dateOfBirth = 'Không có dữ liệu'
														: $scope.order.dateOfBirth = $scope.orderOrginal.dateOfBirth;

												$scope.orderOrginal.phone == null ? $scope.order.phone = 'Không có dữ liệu'
														: $scope.order.phone = $scope.orderOrginal.phone;

												$scope.orderOrginal.dept == null ? $scope.order.dept = 'Không có dữ liệu'
														: $scope.order.dept = $scope.orderOrginal.dept;

												$scope.orderOrginal.className == null ? $scope.order.className = 'Không có dữ liệu'
														: $scope.order.className = $scope.orderOrginal.className;

												$scope.orderOrginal.address == null ? $scope.order.address = 'Không có dữ liệu'
														: $scope.order.address = $scope.orderOrginal.address;
											} else {
												$window.location.reload();
							
											}
											;
										}, function error(response) {

										});
					};
					init();

					$scope.deleteOrderBook = function(id) {

						$http(
								{
									url : '/13110194_NguyenDucDuongViet_03/deleteOrderDetail/'
											+ id,
									method : 'GET'
								}).then(function success(response) {
							if (response.data.status = '200') {
								init();
								$scope.deleteSuccess = true;
								$scope.deleteFail = false;
								$timeout(function() {
									$scope.deleteSuccess = false;
								}, 3000);

							} else {
								$scope.deleteSuccess = false;
								$scope.message = response.data.message;
								$scope.deleteFail = true;
								$timeout(function() {
									$scope.deleteFail = false;
								}, 3000);

							}
						}, function error(response) {
							$scope.deleteSuccess = false;
							$scope.message = response.data.message;
							$scope.deleteFail = true;
							$timeout(function() {
								$scope.deleteFail = false;
							}, 3000);
						});

					};
				});