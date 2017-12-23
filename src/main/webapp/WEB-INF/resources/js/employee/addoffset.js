angular.module('library').controller(
		'empAddOffsetCtrl',
		function($scope, $http, $window, $timeout, $filter) {
			$scope.bookOffset = {};
			$scope.code = null;
			$scope.borrowBooks = [];
			$scope.borrowBooksFull = [];
			$scope.borrows = [];
			$scope.lstBookOffset = [];
			
			$scope.selected = {
				borrow : undefined,
				borrowBook: undefined
			}
			
			$scope.showMessage = false;
			$scope.message = '';
			
			// event when select
			$scope.onSelectCallback = function (item, model){
				var temp = [];
				$scope.borrowBooksFull.forEach(function(item){
					if(item.borrow.id === $scope.selected.borrow.id)
						temp.push(item);
				});
				$scope.borrowBooks = temp;
				$scope.selected.borrowBook = undefined;
				$scope.lstBookOffset = [];
			};
			
			// define init function
			var init = function() {
				$http({
					url : '/13110194_NguyenDucDuongViet_03/getAllBorrow',
					method : 'GET'
				}).then(function success(response) {
					$scope.borrows = response.data.data;
				}, function error(response) {

				});
				
				$http({
					url : '/13110194_NguyenDucDuongViet_03/getAllBookCanOffset',
					method : 'GET'
				}).then(function success(response) {
					$scope.borrowBooks = response.data.data;
					$scope.borrowBooksFull = response.data.data;
				}, function error(response) {

				});

			};
			// load data when page load
			init();
			
			$scope.check = function(){
				$http({
					url : '/13110194_NguyenDucDuongViet_03/checkBookCodeExist/' + $scope.code,
					method : 'GET'
				}).then(function success(response) {
					if(response.data.status === '200'){
						$scope.showMessage = false;
						$scope.message = '';
					}
					else{
						$scope.showMessage = true;
						$scope.message = 'Mã vạch đã tồn tại';
					}
						
				}, function error(response) {
					$scope.showMessage = true;
					$scope.message = 'Xãy ra lỗi khi kết nối đến server!';
				});
			};
			
			// add book to list borrow
			$scope.add = function(){
				if(($scope.selected.borrowBook  === undefined) || ($scope.selected.borrowBook === null)){
					$scope.message = 'Hãy chọn một cuốn sách!';
					$scope.showMessage = true;
					return;
				}
				
				if(($scope.code  === undefined) || ($scope.code === null)){
					$scope.message = 'Hãy nhập mã sách mới!';
					$scope.showMessage = true;
					return;
				}	
				
				for(var i = 0; i < $scope.lstBookOffset.length; i++){
					if($scope.lstBookOffset[i].id === $scope.selected.borrowBook.book.id){
						$scope.message = 'Sách này đã tồn tại trong danh sách!';
						$scope.showMessage = true;
						return;
					}
				}
			
				$scope.showMessage = false;
				var book = {};
				book = $scope.selected.borrowBook.book;
				book.code = $scope.code;
				$scope.lstBookOffset.push(book);
				$scope.selected.borrowBook = undefined;
				$scope.code = null;
				
			};
			
			// delete from list borrow
			$scope.delete = function(index){
				$scope.lstBookOffset.splice(index,1);
			};
			
			// Save borrow detail
			$scope.save = function(){
				 if(($scope.selected.borrow === undefined) || ($scope.selected.borrow ===
				 null)){
				 $scope.message = 'Hãy chọn một phiếu mượn!';
				 $scope.showMessage = true;
				 return;
				}
			 if($scope.lstBookOffset.length == 0){
			 $scope.message = 'Danh sách sách đền bù không được để trống';
			 $scope.showMessage = true;
			 return;
			 }
			 if(($scope.dateOffset === undefined) || ($scope.dateOffset === null)){
			 $scope.message = 'Ngày đền bù không được để trống';
			 $scope.showMessage = true;
			 return;
			 }
			 
			 $scope.showMessage = false;
			 $scope.bookOffset.borrowBookId = $scope.selected.borrow.id;
			 $scope.bookOffset.user =  $scope.selected.borrow.user;
			 $scope.bookOffset.books = $scope.lstBookOffset;
			 $scope.bookOffset.offsetDate = $scope.dateOffset;
			 console.log($scope.bookOffset);
							
			 $http({
				 url:'/13110194_NguyenDucDuongViet_03/saveBookOffset', 
				 method: 'POST', 
				 data: $scope.bookOffset
				 }).then(function success(response){
					 console.log(response);
					 if(response.data.status == '200'){
						 $scope.message = 'Lưu thông tin thành công! Tự động trở về danh sách đền bù sau 3s...';
						 $scope.showMessage = true;
						 $timeout(function(){
							 $window.location.href = '/13110194_NguyenDucDuongViet_03/offset';
							 },3000);
						 }else{
							 $scope.message = 'Đã xãy ra lỗi, kiểm tra lại thông tin...';
							 $scope.showMessage = true;}},
					function error(){
								 $scope.message = 'Kết nối tới server thất bại! Vui lòng thử lại sau.';
								 $scope.showMessage = true;
								 });
			};
			
			$scope.today = function() {
				$scope.dateOfset = new Date();

			};
			$scope.today();

			$scope.dateOffset = new Date();
			$scope.clear = function() {
				$scope.dateOffset = null;
			};

			$scope.inlineOptions = {
				customClass : getDayClass,
				minDate : new Date(),
				showWeeks : true
			};

			$scope.dateOptions = {
				dateDisabled : disabled,
				formatYear : 'yy',
				maxDate : new Date(2020, 5, 22),
				minDate : new Date(),
				startingDay : 1
			};

			// Disable weekend selection
			function disabled(data) {
				var date = data.date, mode = data.mode;
				return mode === 'day'
						&& (date.getDay() === 0 || date.getDay() === 6);
			}

			$scope.open1 = function() {
				$scope.popup1.opened = true;
			};

			$scope.open2 = function() {
				$scope.popup2.opened = true;
			};
			
			$scope.open3 = function() {
				$scope.popup3.opened = true;
			};

			$scope.altInputFormats = [ 'M!/d!/yyyy' ];

			$scope.popup1 = {
				opened : false
			};

			$scope.popup2 = {
				opened : false
			};
			
			$scope.popup3 = {
					opened : false
				};

			function getDayClass(data) {
				var date = data.date, mode = data.mode;
				if (mode === 'day') {
					var dayToCheck = new Date(date).setHours(0, 0, 0, 0);

					for (var i = 0; i < $scope.events.length; i++) {
						var currentDay = new Date($scope.events[i].date)
								.setHours(0, 0, 0, 0);

						if (dayToCheck === currentDay) {
							return $scope.events[i].status;
						}
					}
				}

				return '';
			}
		});