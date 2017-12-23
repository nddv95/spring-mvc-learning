<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Thư viện trường Đại học Sư phạm Kỹ thuật TPHCM</title>

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Custom css -->
<link
	href="${pageContext.request.contextPath}/resources/css/home/home.css"
	rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body ng-app="library" ng-controller="homeCtrl">
	<!-- Nav bar -->
	<div class="navbar-wrapper">
		<div class="container-fluid">
			<nav class="navbar navbar-fixed-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand"
							href="${pageContext.request.contextPath}/home">UTE</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a
								href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
							<li><a href="${pageContext.request.contextPath}/book">Tra
									cứu sách</a></li>
							<li><a href="${pageContext.request.contextPath}/cart">Sách
									quan tâm</a></li>
							<li><a href="${pageContext.request.contextPath}/mybook">Sách
									đang mượn</a></li>
						</ul>
						<ul class="nav navbar-nav pull-right">
							<c:choose>
								<c:when test="${user!=null}">
									<li class=" dropdown"><a href="#"
										class="dropdown-toggle active" data-toggle="dropdown"
										role="button" aria-haspopup="true" aria-expanded="false">${user.getFullName()}<span
											class="caret"></span>
									</a>
										<ul class="dropdown-menu">
											<li><a href="#">Thông tin tài khoản</a></li>
											<li><a href="#">Đổi mật khẩu</a></li>
										</ul></li>
									<li><a href="${pageContext.request.contextPath}/logout">Đăng
											xuất</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="${pageContext.request.contextPath}/login">Đăng
											nhập</a></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<!-- End Nav bar -->

	<!-- Slide image -->
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" id="img-slide" role="listbox">
			<div class="item active">
				<img
					src="${pageContext.request.contextPath}/resources/img/home_1.jpg">
				<div class="carousel-caption">
					<h3>A person who won’t read has no advantage over one who
						can’t read.</h3>
					<p>Mark Twain</p>
				</div>
			</div>
			<div class="item">
				<img
					src="${pageContext.request.contextPath}/resources/img/home_2.jpg">
				<div class="carousel-caption">
					<h3>The reading of all good books is like a conversation with
						the finest minds of past centuries.</h3>
					<p>Rene Descartes</p>
				</div>
			</div>
			<div class="item">
				<img
					src="${pageContext.request.contextPath}/resources/img/home_3.jpg">
				<div class="carousel-caption">
					<h3>The more that you read, the more things you will know. The
						more that you learn, the more places you'll go.</h3>
					<p>Dr Seuss</p>
				</div>

			</div>
		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- End Slide image -->

	<!-- Content -->
	<div class="container-fluid">

		<div class="row hot-book">
			<c:if test="${user == null}">
				<div class="row">
					<div class="alert alert-info" style="margin: 15px;">
						<strong>Chú ý!</strong> Bạn phải <a
							href="${pageContext.request.contextPath}/login"
							class="alert-link">đăng nhập</a> để đặt sách.
					</div>
				</div>
			</c:if>
			<div class="row" ng-show="addFavoriteSuccess">
				<div class="alert alert-success alert-dismissable"
					style="margin: 15px;">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					<strong>Thêm thành công!</strong> Vào <a
						href="${pageContext.request.contextPath}/cart" class="alert-link">Danh
						sách quan tâm</a> để xem lại.
				</div>
			</div>
			<div class="row" ng-show="addFavoriteFail">
				<div class="alert alert-danger alert-dismissable"
					style="margin: 15px;">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					<strong>Đã xãy ra lỗi trong quá trình thêm!</strong>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" style="text-align: left;">
					<b>SÁCH HOT TRONG THÁNG</b> <span style="float: right;"><a
						href="${pageContext.request.contextPath}/book">Tất cả>></a></span>
				</div>
				<div class="panel-body">
					<div class="row">
						<div ng-repeat="book in bookHots">
							<div class="col-md-2 col-sm-4 col-xs-6">

								<div class="book-item show">
									<img alt="" style="width: 100%; height: 250px"
										ng-src="{{'${pageContext.request.contextPath}' + (book.image ||'/resources/img/book-default.jpg')}}">
									<div class="button-child">
										<h4>{{book.name}}</h4>
										<a href="${pageContext.request.contextPath}/book/{{book.id}}"
											class="btn btn-default">Xem</a>
									</div>
								</div>
								<c:if test="${user!=null}">
									<div class="action">
										<button class="btn btn-default btn-block"
											ng-click="addFavorite(${user.id}, book.id)">Quan tâm</button>
										<form style="margin-top: 5px;"
											action="${pageContext.request.contextPath}/order-book"
											method="POST">
											<input type="hidden" name="bookId" value="{{book.id}}">
											<button type="submit" class="btn btn-default btn-block">Đặt
												sách</button>
										</form>
									</div>
								</c:if>

							</div>

						</div>

					</div>
				</div>
			</div>
		</div>

		<div class="row hot-book">
			<div class="panel panel-default">
				<div class="panel-heading" style="text-align: left;">
					<b>XU HƯỚNG GẦN ĐÂY</b> <span style="float: right;"><a
						href="${pageContext.request.contextPath}/book">Tất cả>></a></span>
				</div>
				<div class="panel-body">
					<div class="row">

						<div class="col-md-2 col-sm-4 col-xs-6">
							<div class="book-item show">
								<img alt="" style="width: 100%; min-height: 250px"
									src="${pageContext.request.contextPath}/resources/img/book-default.jpg">
								<div class="button-child">
									<h4>Toán cao cấp A1</h4>
									<a href="${pageContext.request.contextPath}/book/1"
										class="btn btn-default">Xem</a>
								</div>
							</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6">
							<div class="book-item show">
								<img alt="" style="width: 100%; min-height: 250px"
									src="${pageContext.request.contextPath}/resources/img/book-default.jpg">
								<div class="button-child">
									<h4>Toán cao cấp A1</h4>
									<a href="${pageContext.request.contextPath}/book/1"
										class="btn btn-default">Xem</a>
								</div>
							</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6">
							<div class="book-item show">
								<img alt="" style="width: 100%; min-height: 250px"
									src="${pageContext.request.contextPath}/resources/img/book-default.jpg">
								<div class="button-child">
									<h4>Toán cao cấp A1</h4>
									<a href="${pageContext.request.contextPath}/book/1"
										class="btn btn-default">Xem</a>
								</div>
							</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6">
							<div class="book-item show">
								<img alt="" style="width: 100%; min-height: 250px"
									src="${pageContext.request.contextPath}/resources/img/book-default.jpg">
								<div class="button-child">
									<h4>Toán cao cấp A1</h4>
									<a href="${pageContext.request.contextPath}/book/1"
										class="btn btn-default">Xem</a>
								</div>
							</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6">
							<div class="book-item show">
								<img alt="" style="width: 100%; min-height: 250px"
									src="${pageContext.request.contextPath}/resources/img/book-default.jpg">
								<div class="button-child">
									<h4>Toán cao cấp A1</h4>
									<a href="${pageContext.request.contextPath}/book/1"
										class="btn btn-default">Xem</a>
								</div>
							</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6">
							<div class="book-item show">
								<img alt="" style="width: 100%; min-height: 250px"
									src="${pageContext.request.contextPath}/resources/img/book-default.jpg">
								<div class="button-child">
									<h4>Toán cao cấp A1</h4>
									<a href="${pageContext.request.contextPath}/book/1"
										class="btn btn-default">Xem</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- End Content -->

	<!-- Footer -->
	<div class="container-fluid">
		<div class="row">
			<hr>
			<div class="col-lg-12">
				<div class="col-md-8">
					<a href="#">0966805560</a> | <a href="#">nddv95@gmail.com</a>
				</div>
				<div class="col-md-4">
					<p class="muted pull-right">© 2016 HCMUTE Nguyễn Đức Dương Việt
						- 13110194</p>
				</div>
			</div>
		</div>
	</div>
	<!-- End Footer -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

	<!-- AngularJs -->
	<script
		src="${pageContext.request.contextPath}/resources/angularjs/angular.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-sanitize.js"></script>
	<!-- Angular ui select -->
	<script
		src="${pageContext.request.contextPath}/resources/angular-ui/select.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/angular-ui/ui-bootstrap-tpls.js"></script>
	<!-- Js for home -->
	<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/home/home.js"></script>
</body>

</html>