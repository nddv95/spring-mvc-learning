angular.module('library').controller(
		'empBorrowOrderCtrl',
		function($scope, $http, $window, $timeout,$filter) {
			$scope.borrow = {};
			$scope.order = {};
			
			var orderId = null;
			
			$scope.bookLists = [];
			$scope.students = [];
			$scope.lstBookBorrow = [];
			
			$scope.selected = {
				student : undefined,
				bookList: undefined
			}
			
			$scope.showMessage = false;
			$scope.message = '';
			
			// define init function
			$scope.init = function(id) {
				orderId = id;
				// get all student
				$http({
					url : '/13110194_NguyenDucDuongViet_03/findAllStudent',
					method : 'GET'
				}).then(function success(response) {
					$scope.students = response.data.data;
				}, function error(response) {

				});
				// get all book list
				$http({
					url : '/13110194_NguyenDucDuongViet_03/getAllBookList',
					method : 'GET'
				}).then(function success(response) {
					$scope.bookLists = response.data.data;
				}, function error(response) {

				});
				// get order detail
				$http({
					url : '/13110194_NguyenDucDuongViet_03/getOrder/' + id,
					method : 'GET',
				}).then(function success(response) {
					if (response.data.status == '200') {
						$scope.order = response.data.data;
						$scope.selected.student = $scope.order.user;
						$scope.order.books.forEach(function(book){
							var b = {};
							b.id = book.id;
							b.code = null;
							b.name = book.name;
							
							$scope.lstBookBorrow.push(b);
						});
					}
				}, function error(response) {

				});

			};
			
			// add book to list borrow
			$scope.add = function(){
				if(($scope.selected.bookList  === undefined) || ($scope.selected.bookList === null)){
					$scope.message = 'Hãy chọn một cuốn sách!';
					$scope.showMessage = true;
					return;
				}					
				for(var i = 0; i < $scope.lstBookBorrow.length; i++){
					if($scope.lstBookBorrow[i].id === $scope.selected.bookList.id){
						if(($scope.lstBookBorrow[i].code  === undefined) || ($scope.lstBookBorrow[i].code === null)){
							$scope.lstBookBorrow[i].code = $scope.selected.bookList.code;
							return;
						}
						$scope.message = 'Sách này đã tồn tại trong danh sách!';
						$scope.showMessage = true;
						return;
					}
				}		
				$scope.showMessage = false;
				$scope.lstBookBorrow.push($scope.selected.bookList);
				
			};
			
			// delete from list borrow
			$scope.delete = function(index){
				$scope.lstBookBorrow.splice(index,1);
			};
			
			//delete order
			var deleteOrder = function(){
				$http({
					url : '/13110194_NguyenDucDuongViet_03//deteteOrder/'+ orderId,
					method : 'GET'
					}).then(function success(response) {
					if (response.data.status = '200') {
						console.log('success');
					}
				}, function error(response) {
					
				});
			};
			
			// Save borrow detail
			$scope.save = function(){
				
				if(($scope.selected.student  === undefined) || ($scope.selected.student === null)){
					$scope.message = 'Sinh viên không được để trống';
					$scope.showMessage = true;
					return;
				}
				
				if($scope.lstBookBorrow.length == 0){
					$scope.message = 'Danh sách sách mượn không được để trống';
					$scope.showMessage = true;
					return;
				}
				
				for(var i = 0; i < $scope.lstBookBorrow.length; i++){
						if(($scope.lstBookBorrow[i].code  === undefined) || ($scope.lstBookBorrow[i].code === null)){
							$scope.message = 'Hãy chọn mã vạch cho những sách đặt!';
							$scope.showMessage = true;
							return;
						}
					}
			
				if(($scope.dateReturn  === undefined) || ($scope.dateReturn === null)){
					$scope.message = 'Ngày trả không được để trống';
					$scope.showMessage = true;
					return;
				}
				
				$scope.showMessage = false;
				$scope.borrow.user = $scope.selected.student;
				$scope.borrow.books = $scope.lstBookBorrow;
				$scope.borrow.dateBorrow = $scope.dateBorrow;
				$scope.borrow.dateReturn = $scope.dateReturn;
				
				$http({url:'/13110194_NguyenDucDuongViet_03/borrowBook', method: 'POST', data: $scope.borrow}).then(function success(response){
					console.log(response);
					if(response.data.status == '200'){
						deleteOrder();
						$scope.message = 'Lưu thông tin thành công! Tự động trở về danh sách mượn sau 3s...';
						$scope.showMessage = true;
						$timeout(function(){
							$window.location.href = '/13110194_NguyenDucDuongViet_03/borrow';
						},3000);
					}else{
						$scope.message = 'Đã xãy ra lỗi, kiểm tra lại thông tin...';
						$scope.showMessage = true;
					}
				}, function error(){
					$scope.message = 'Đã xãy ra lỗi, kiểm tra lại thông tin...';
					$scope.showMessage = true;});
			};
			
			$scope.today = function() {
				$scope.dateReturn = new Date();

			};
			$scope.today();

			$scope.dateBorrow = new Date();
			$scope.clear = function() {
				$scope.dateReturn = null;
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

			$scope.altInputFormats = [ 'M!/d!/yyyy' ];

			$scope.popup1 = {
				opened : false
			};

			$scope.popup2 = {
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