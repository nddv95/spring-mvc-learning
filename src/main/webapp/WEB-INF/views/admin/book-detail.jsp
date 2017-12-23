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

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">

<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/template/css/AdminLTE.min.css">

<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/template/css/skin-blue.min.css">

<!-- Custom css -->
<link
	href="${pageContext.request.contextPath}/resources/css/employee/home.css"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="hold-transition skin-blue sidebar-mini" ng-app="library"
	ng-controller="adminBookDetailCtrl" ng-init="init(${bookId})">
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="${pageContext.request.contextPath}/admin/books" class="logo">
				<!-- mini logo for sidebar mini 50x50 pixels --> <span
				class="logo-mini"><b>A</b>LT</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>HCMUTE</b></span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>

				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!-- Notifications: style can be found in dropdown.less -->
						<li class="dropdown notifications-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-bell-o"></i> <span class="label label-warning">2</span>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have 2 notifications</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<li><a href="#"> <i class="fa fa-users text-aqua"></i>
												10 bạn mượn sách sẽ hết hạn hôm nay.
										</a></li>
										<li><a href="#"> <i class="fa fa-users text-aqua"></i>
												3 phiếu đặt mới có trong hôm nay.
										</a></li>
									</ul>
								</li>
								<li class="footer"><a href="#">View all</a></li>
							</ul></li>

						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="https://placeimg.com/160/160/people" class="user-image"
								alt="User Image"> <span class="hidden-xs">${user.getFullName()}</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="https://placeimg.com/160/160/people" class="img-circle"
									alt="User Image">

									<p>${user.getFullName()}</p></li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profile</a>
									</div>
									<div class="pull-right">
										<a href="${pageContext.request.contextPath}/logout"
											class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
							</ul></li>
						<!-- Control Sidebar Toggle Button -->
						<li><a href="#" data-toggle="control-sidebar"><i
								class="fa fa-gears"></i></a></li>
					</ul>
				</div>
			</nav>
		</header>
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="https://placeimg.com/160/160/people" class="img-circle"
							alt="User Image">
					</div>
					<div class="pull-left info">
						<p>${user.getFullName()}</p>
						<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
					</div>
				</div>
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<li class="header">MENU</li>
					<li class="treeview active"><a
						href="${pageContext.request.contextPath}/addmin/books"> <i
							class="fa fa-files-o"></i> <span>Quản lý sách</span>
					</a></li>
					<li class="treeview"><a
						href="${pageContext.request.contextPath}/admin/users"> <i
							class="fa fa-files-o"></i> <span>Quản lý user</span>
					</a></li>
					<li><a href="#"> <i class="fa fa-th"></i> <span>Thống
								kê hoạt động</span>
					</a></li>
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Thông tin sách</h1>
				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/admin/books"><i
							class="fa fa-dashboard"></i> Home</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/books">Quản
							lý sách</a></li>
					<li class="active">Chi tiết</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-body">
								<div class="alert alert-danger" ng-show="showMess">
									<strong>dấdadasda</strong>
								</div>
								<div class="panel panel-primary">
									<div class="panel-heading">Thông tin sách</div>
									<div class="panel-body">
										<div class="row">
											<div class="col-md-10">
												<div class="row">
													<label class="col-md-2"
														style="margin-bottom: 0px; padding-top: 8px; padding-bottom: 8px">Mã
														sách:</label>
													<div class="col-md-4">
														<input disabled class="form-control">
													</div>
												</div>
												<div class="row">
													<label class="col-md-2"
														style="margin-bottom: 0px; padding-top: 8px; padding-bottom: 8px">Tên
														sách:</label>
													<div class="col-md-4">
														<input class="form-control">
													</div>
												</div>
												<div class="row">
													<label class="col-md-2"
														style="margin-bottom: 0px; padding-top: 8px; padding-bottom: 8px">Loại
														sách:</label>
													<div class="col-md-4">
														<input class="form-control">
													</div>
												</div>
												<div class="row">
													<label class="col-md-2"
														style="margin-bottom: 0px; padding-top: 8px; padding-bottom: 8px">Tác
														giả:</label>
													<div class="col-md-4">
														<input class="form-control">
													</div>
												</div>
												<div class="row">
													<label class="col-md-2"
														style="margin-bottom: 0px; padding-top: 8px; padding-bottom: 8px">Nhà
														xuất bản:</label>
													<div class="col-md-4">
														<input class="form-control">
													</div>
												</div>
												<div class="row">
													<label class="col-md-2"
														style="margin-bottom: 0px; padding-top: 8px; padding-bottom: 8px">Ngày
														xuất bản:</label>
													<div class="col-md-4">
														<input class="form-control">
													</div>
												</div>
												<div class="row">
													<label class="col-md-2"
														style="margin-bottom: 0px; padding-top: 8px; padding-bottom: 8px">Số
														lượng:</label>
													<div class="col-md-4">
														<input disabled class="form-control">
													</div>
												</div>

											</div>
											<div class="col-md-2">
												<img
													src="${pageContext.request.contextPath}/resources/img/book-default.jpg"
													style="width: 100% !important; height: 220px !important;"
													alt="">
											</div>
										</div>
									</div>
								</div>
								<div class="panel panel-primary">
									<div class="panel-heading">Danh sách sách có trong thư
										viện</div>
									<div class="panel-body">
										<table class="table table-bordered table-hover">
											<thead>
												<tr>
													<th style="width: 50px">STT</th>
													<th style="width: 150px">Mã vạch</th>
													<th style="border-right: none">Trạng thái</th>
													<th style="width: 50px; border-left: none"></th>
												</tr>
											</thead>
											<tbody>
												<tr ng-repeat="book in lstBookOffset">
													<td style="text-align: center">{{$index + 1}}</td>
													<td>{{book.code}}</td>
													<td style="border-right: none;">{{book.name}}</td>
													<td style="border-left: none;"><button
															ng-click="delete($index)" type="button"
															class="btn btn-sm btn-danger">Xóa</button></td>
												</tr>
												<tr ng-hide="lstBookOffset.length">
													<td colspan="4">Không tìm thấy dữ liệu</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<!-- /.box-body -->
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 1.0.0
			</div>
			<strong>Copyright &copy; 2016 <a href="#">Nguyễn Đức
					Dương Việt - 13110194</a>.
			</strong> All rights reserved.
		</footer>

	</div>
	<!-- ./wrapper -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

	<!-- AdminLTE App -->
	<script
		src="${pageContext.request.contextPath}/resources/template/js/app.min.js"></script>

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
		src="${pageContext.request.contextPath}/resources/js/admin/bookdetail.js"></script>


</body>
</html>