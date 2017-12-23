angular.module('library').controller(
		'bookCtrl',
		function($scope, $http, $timeout) {
			$scope.book = {};
			$scope.relatedBooks = [];
			$scope.addFavoriteSuccess = false;
			$scope.addFavoriteFail = false;

			// add favorite book
			$scope.addFavorite = function(userId, bookId) {
				$http({
					method : 'POST',
					url : '/13110194_NguyenDucDuongViet_03/saveBookFavorite',
					data : {
						'userId' : userId,
						'bookId' : bookId
					}
				}).then(function successCallback(response) {
					if (response.data.status == '200') {
						$scope.addFavoriteSuccess = true;
						$timeout(function() {
							$scope.addFavoriteSuccess = false;
						}, 3000);

						$scope.addFavoriteFail = false;
					} else {
						$scope.addFavoriteSuccess = false;
						$scope.addFavoriteFail = true;
						$timeout(function() {
							$scope.addFavoriteFail = false;
						}, 3000);
					}
				}, function errorCallback(response) {
					$scope.addFavoriteSuccess = false;
					$scope.addFavoriteFail = true;
				});
			};

			var getRelatedBook = function(categoryId) {
				$http(
						{
							method : 'GET',
							url : '/13110194_NguyenDucDuongViet_03/getRelatedBook/'
									+ categoryId
						}).then(function successCallback(response) {
					$scope.relatedBooks = response.data.data;
				}, function errorCallback(response) {
					consol.log(response);
				});
			};

			// get book detail
			$scope.init = function(id) {
				$http({
					method : 'GET',
					url : '/13110194_NguyenDucDuongViet_03/getBookById/' + id
				}).then(function successCallback(response) {
					$scope.book = response.data.data;
					$scope.book.publishDate = fomat($scope.book.publishDate);
					getRelatedBook($scope.book.category.id);
				}, function errorCallback(response) {
					consol.log(response);
				});

			};

			// convert date fomat
			function fomat(d) {
				d = new Date(d);
				var month = d.getMonth() + 1;
				return d.getDate() + '/' + month + '/' + d.getFullYear();
			}
			;

		});