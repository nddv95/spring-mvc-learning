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
	ng-controller="empHomeCtrl">
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="${pageContext.request.contextPath}/borrow" class="logo">
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
					<li class="active treeview"><a href="#"> <i
							class="fa fa-dashboard"></i> <span>Quản lý đặt/mượn sách</span><span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
						<ul class="treeview-menu">
							<li class="active"><a
								href="${pageContext.request.contextPath}/borrow"><i
									class="fa fa-circle-o"></i> <span>Danh sách mượn</span></a></li>
							<li><a href="${pageContext.request.contextPath}/order"><i
									class="fa fa-circle-o"></i><span>Danh sách đặt</span></a></li>
						</ul></li>
					<li class="treeview"><a
						href="${pageContext.request.contextPath}/borrow-book"> <i
							class="fa fa-files-o"></i> <span>Cho mượn sách</span>
					</a></li>
					<li><a href="${pageContext.request.contextPath}/offset"> <i
							class="fa fa-th"></i> <span>Quản lý đền bù</span>
					</a></li>

					<li class="treeview"><a
						href="${pageContext.request.contextPath}/book-list"> <i
							class="fa fa-table"></i> <span>Tra cứu sách</span> <span
							class="pull-right-container"> </span>
					</a></li>
					
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Danh sách mượn</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Danh sách mượn</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-body">
								<div class="form-group pull-right">
									<input type="text" class="search form-control"
										ng-model="search.user.username" placeholder="Mã số sinh viên">
								</div>
								<table id="example2" class="table table-bordered table-hover">
									<thead>
										<tr>
											<th style="width: 50px;">STT</th>
											<th>Mã số sinh viên</th>
											<th style="border-right: none;">Tên sinh viên</th>
											<th style="width: 40px; border-left: none;"></th>
											<th>Ngày mượn</th>
											<th>Ngày trả</th>

										</tr>
									</thead>
									<tbody>
										<tr ng-repeat="borrow in borrows | filter:search">
											<td style="text-align: center;">{{$index + 1}}</td>
											<td>{{borrow.user.username}}</td>
											<td style="border-right: none;">{{borrow.user.fullName}}</td>
											<td style="border-left: none;"><a
												href="${pageContext.request.contextPath}/borrow/{{borrow.id}}"
												class="btn btn-info btn-sm glyphicon glyphicon-eye-open"></a></td>
											<td>{{borrow.dateBorrow | date:"dd/MM/yyyy" }}</td>
											<td>{{borrow.dateReturn | date:"dd/MM/yyyy"}}</td>

										</tr>
										<tr ng-hide="(borrows | filter:search).length">
											<td colspan="6">Không tìm thấy dữ liệu</td>
										</tr>
									<tfoot>
										<tr>
											<th>STT</th>
											<th>Mã số sinh viên</th>
											<th style="border-right: none;">Tên sinh viên</th>
											<th style="border-left: none;"></th>
											<th>Ngày mượn</th>
											<th>Ngày trả</th>

										</tr>
									</tfoot>
								</table>
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
		src="${pageContext.request.contextPath}/resources/js/employee/home.js"></script>


</body>
</html>