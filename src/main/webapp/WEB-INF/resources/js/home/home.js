angular.module('library').controller('homeCtrl', function($scope, $http,$timeout) {
	$scope.bookHots = [];
	$scope.addFavoriteSuccess = false;
	$scope.addFavoriteFail = false;
	
	//add favorite book
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
				$timeout(function () {
			        $scope.addFavoriteSuccess = false;
			    }, 3000);
				
				$scope.addFavoriteFail = false;
			} else {
				$scope.addFavoriteSuccess = false;
				$scope.addFavoriteFail = true;
				$timeout(function () {
			        $scope.addFavoriteFail = false;
			    }, 3000);
			}
		}, function errorCallback(response) {
			$scope.addFavoriteSuccess = false;
			$scope.addFavoriteFail = true;
		});
	};
	
	//get book hot in month
	$http({
		method : 'GET',
		url : '/13110194_NguyenDucDuongViet_03/getBookHotInMonth'
	}).then(function successCallback(response) {
		$scope.bookHots = response.data.data;

	}, function errorCallback(response) {
		consol.log(response);
	});

})