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
	href="${pageContext.request.contextPath}/resources/css/home/search.css"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body ng-app="library" ng-controller="searchCtrl">
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
							<li><a href="${pageContext.request.contextPath}/home">Trang
									chủ</a></li>
							<li class="active"><a
								href="${pageContext.request.contextPath}/book">Tra cứu sách</a></li>
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
	<!-- Content -->
	<div class="container-fluid" style="margin-top: 100px">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<div class="input-group buscador-principal">
					<input name="search_param" value="all" id="search_param"
						type="hidden"> <input class="form-control" name="x"
						placeholder="Tên sách hoặc tác giả" ng-model="searchParam"
						type="text">
					<div class="input-group-btn search-panel">
						<button type="button"
							class="btn btn-custom btn-default dropdown-toggle"
							data-toggle="dropdown">
							<span id="search_concept">{{filter}}</span> <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu">
							<li><a ng-click="getAllBook()">Tất cả</a></li>
							<li ng-repeat="category in categories"><a
								ng-click="getBookByCategory(category.id,category.categoryName)">{{category.categoryName}}</a></li>
						</ul>
					</div>
					<span class="input-group-btn">
						<button class="btn btn-custom btn-primary" type="button"
							ng-click="search()">
							<span class="glyphicon glyphicon-search"></span> Tìm kiếm
						</button>
					</span>
				</div>
			</div>
		</div>
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
			<div class="row" style="margin-top: 20px">
				<div class="col-md-2" ng-repeat="book in books">
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
						</div>
					</c:if>
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
		src="${pageContext.request.contextPath}/resources/angularjs/angular.js"></script>
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
		src="${pageContext.request.contextPath}/resources/js/home/searchbook.js"></script>
</body>

</html>