angular.module('library').controller('adminBookDetailCtrl', function($scope, $http, $timeout){
	$scope.book = {};
	$scope.showMess = false;
	
	$scope.init = function(id) {
		//alert(id);
	};

});