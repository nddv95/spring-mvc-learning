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
	href="${pageContext.request.contextPath}/resources/css/home/mybook.css"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body ng-app="library" ng-controller="cartCtrl"">
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
							<li><a href="${pageContext.request.contextPath}/book">Tra
									cứu sách</a></li>
							<li class="active"><a
								href="${pageContext.request.contextPath}/cart">Sách quan tâm</a></li>
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
	<div class="container-fluid custom-padding">
		<div class="spacing"></div>
		<div class="row" ng-show="deleteSuccess">
			<div class="alert alert-success alert-dismissable">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
				<strong>Xóa sách yêu thích thành công</strong>
			</div>
		</div>
		<div class="row" ng-show="deleteFail">
			<div class="alert alert-danger alert-dismissable"
				style="margin: 15px">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
				<strong>Đã xãy ra lỗi khi xóa!</strong>
			</div>
		</div>
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<b>SÁCH QUAN TÂM</b>
				</div>
				<div class="panel-body">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th style="width: 50px">STT</th>
								<th style="width: 200px">Mã sách</th>
								<th style="border-right: none">Tên sách</th>
								<th style="width: 100px; border-left: none"></th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="book in bookFavorites">
								<td style="padding-top: 15px; text-align: center">{{$index
									+ 1}}</td>
								<td style="padding-top: 15px">{{book.book.id}}</td>
								<td style="border-right: none; padding-top: 15px">{{book.book.name}}</td>
								<td style="border-left: none;"><a
									href="${pageContext.request.contextPath}/book/{{book.book.id}}"
									type="button" class="btn btn-info" aria-label="Left Align"
									data-toggle="tooltip" data-placement="left"
									title="Xem thông tin sách"> <span
										class=" glyphicon glyphicon-eye-open" aria-hidden="true"></span></a>
									<button ng-click="deleteFavor(book.id)" type="button"
										class="btn btn-danger" aria-label="Left Align"
										data-toggle="tooltip" data-placement="bottom" title="Xóa">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									</button></td>
							</tr>
						</tbody>
					</table>
					<div style="text-align: center;">
						<a href="#" class="btn btn-md btn-primary">Đặt những sách quan
							tâm</a>
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
		src="${pageContext.request.contextPath}/resources/js/home/cart.js"></script>

</body>

</html>