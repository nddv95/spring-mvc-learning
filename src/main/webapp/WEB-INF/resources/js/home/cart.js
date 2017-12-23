angular
		.module('library')
		.controller(
				'cartCtrl',
				function($scope, $http, $timeout) {
					$scope.bookFavorites = [];
					$scope.deleteSuccess = false;
					$scope.deleteFail = false;
					$scope.message = '';
					var init = function() {
						$http(
								{
									url : '/13110194_NguyenDucDuongViet_03/getBookFavoriteByUser',
									method : 'GET'
								}).then(function success(response) {
							$scope.bookFavorites = response.data.data;
						}, function error(response) {

						});
					}
					init();
					// get all user's favorite book

					// delete a favorite book

					$scope.deleteFavor = function(id) {
						$http(
								{
									url : '/13110194_NguyenDucDuongViet_03/deleteBookFavorite/'
											+ id,
									method : 'GET'
								}).then(function success(response) {
							if (response.data.status = '200') {
								init();
								$scope.deleteSuccess = true;
								$timeout(function() {
									$scope.deleteSuccess = false;
								}, 3000);
								$scope.deleteFail = false;
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
							$scope.deleteFail = true;
							$timeout(function() {
								$scope.deleteFail = false;
							}, 3000);
						});
					}

				});