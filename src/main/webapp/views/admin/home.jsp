<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/admin/home">Admin
				Dashboard</a>
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav ms-auto">
					<c:choose>
						<c:when test="${sessionScope.account != null}">
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/member/myaccount">
									${sessionScope.account.fullname} </a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/login">Đăng nhập</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<!-- Sidebar -->
			<div class="col-2 bg-light border-end vh-100">
				<h5 class="mt-3">Menu</h5>
				<ul class="nav flex-column">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/admin/category/list"><i
							class="fa fa-list"></i> Quản lý danh mục</a></li>
					<li class="nav-item"><a class="nav-link" href="#"><i
							class="fa fa-box"></i> Quản lý sản phẩm</a></li>
					<li class="nav-item"><a class="nav-link" href="#"><i
							class="fa fa-users"></i> Quản lý người dùng</a></li>
				</ul>
			</div>

			<!-- Main content -->
			<div class="col-10 p-4">
				<h2>Chào mừng ${sessionScope.account.fullname}!</h2>
				<p>Đây là trang quản trị. Chọn menu bên trái để tiếp tục.</p>
			</div>
		</div>
	</div>
</body>
</html>





















































<%--
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>Trang chủ</title>
</head>
<body>
	<header>
		<c:choose>
			<c:when test="${sessionScope.account == null}">
				<div class="col-sm-6">
					<ul class="list-inline right-topbar pull-right">
						<li><a href="${pageContext.request.contextPath}/login">Đăngnhập</a>
							| <a href="${pageContext.request.contextPath}/register">Đăngký</a></li>
						<li><i class="search fa fa-search search-button"></i></li>
					</ul>
				</div>
			</c:when>
			<c:otherwise>
				<div class="col-sm-6">
					<ul class="list-inline right-topbar pull-right">
						<li><a
							href="${pageContext.request.contextPath}/member/myaccount">
								${sessionScope.account.fullname} </a> | <ahref="${pageContext.request.contextPath}/logout">ĐăngXuất</a></li>
						<li><i class="search fa fa-search search-button"></i></li>
					</ul>
				</div>
			</c:otherwise>
		</c:choose>
	</header>
</body>
</html>
--%>