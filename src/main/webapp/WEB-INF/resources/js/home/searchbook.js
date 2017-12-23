angular.module('library').controller(
		'searchCtrl',
		function($scope, $http, $timeout) {
			$scope.books = [];
			$scope.categories = [];
			$scope.searchParam = '';
			$scope.filter = 'Tất cả';
			$scope.addFavoriteSuccess = false;
			$scope.addFavoriteFail = false;

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
			/*
			 * $scope.addFavorite = function(userId, bookId) {
			 * console.log(userId + ' ' + bookId); var param = { "bookId" :
			 * bookId, "userId" : userId }; $.ajax({ url :
			 * '/13110194_NguyenDucDuongViet_03/saveBookFavorite', type : 'POST',
			 * contentType : "application/json", dataType : 'json', data :
			 * JSON.stringify(param), success : function(data) {
			 * console.log(data); if (data.status == '200') {
			 * $scope.addFavoriteSuccess = true; $timeout(function() {
			 * $scope.addFavoriteSuccess = false; }, 2000);
			 * $scope.addFavoriteFail = false; } else {
			 * $scope.addFavoriteSuccess = false; $scope.addFavoriteFail = true;
			 * $timeout(function() { $scope.addFavoriteFail = false; }, 2000); } },
			 * error : function(data) { console.log(data);
			 * $scope.addFavoriteSuccess = false; $scope.addFavoriteFail = true;
			 * $timeout(function() { $scope.addFavoriteFail = false; }, 2000); },
			 * 
			 * }); };
			 */

			// get all book
			$http({
				method : 'GET',
				url : '/13110194_NguyenDucDuongViet_03/getBooks'
			}).then(function successCallback(response) {
				$scope.books = response.data.data;

			}, function errorCallback(response) {

			});

			// get categories
			$http({
				method : 'GET',
				url : '/13110194_NguyenDucDuongViet_03/getCategories'
			}).then(function successCallback(response) {
				$scope.categories = response.data.data;

			}, function errorCallback(response) {

			});

			$scope.getAllBook = function() {
				$scope.filter = 'Tất cả';
				$http({
					method : 'GET',
					url : '/13110194_NguyenDucDuongViet_03/getBooks'
				}).then(function successCallback(response) {
					$scope.books = response.data.data;

				}, function errorCallback(response) {

				});
			};

			// get books by category
			$scope.getBookByCategory = function(id, name) {
				$scope.filter = name;
				$http({
					method : 'GET',
					url : '/13110194_NguyenDucDuongViet_03/getBookByCategory/' + id
				}).then(function successCallback(response) {
					$scope.books = response.data.data;

				}, function errorCallback(response) {

				});
			};
			// search book
			$scope.search = function() {
				$http(
						{
							method : 'GET',
							url : '/13110194_NguyenDucDuongViet_03/searchBook/'
									+ this.searchParam
						}).then(function successCallback(response) {
					$scope.books = response.data.data;

				}, function errorCallback(response) {

				});

			};
		});