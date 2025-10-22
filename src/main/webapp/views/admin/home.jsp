<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TRANG ADMIN</title>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<!-- Header -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand fw-bold text-uppercase" href="#">Admin
				Header</a>
			<div class="collapse navbar-collapse">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/web/home">Trang Web</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Main -->
	<div class="container mt-4">
		<div class="text-center mb-4">
			<h2 class="fw-bold text-uppercase">Bảng điều khiển Admin</h2>
			<p class="text-muted">
				Xin chào, <strong>${sessionScope.account.username}</strong> (Role:
				Admin)
			</p>
		</div>

		<div class="row g-4 justify-content-center text-center">
		
			<!-- Quản lý danh mục -->
			<div class="col-md-4 col-sm-6">
				<div class="card border-0 shadow-sm h-100">
					<div class="card-body">
						<h5 class="fw-bold text-primary">Quản lý Danh mục</h5>
						<p class="small text-muted">Thêm, chỉnh sửa hoặc xóa danh mục
							sản phẩm</p>
						<a href="${pageContext.request.contextPath}/admin/list-category"
							class="btn btn-outline-primary btn-sm">Xem danh sách</a> <a
							href="${pageContext.request.contextPath}/admin/add-category"
							class="btn btn-outline-success btn-sm">Thêm mới</a>
					</div>
				</div>
			</div>

			<!-- Báo cáo & thống kê -->
			<div class="col-md-4 col-sm-6">
				<div class="card border-0 shadow-sm h-100">
					<div class="card-body">
						<h5 class="fw-bold text-primary">Báo cáo & Thống kê</h5>
						<p class="small text-muted">Xem số lượng khách, lượt mua, lượt
							xem,...</p>
						<a href="#" class="btn btn-outline-info btn-sm">Xem báo cáo</a>
					</div>
				</div>
			</div>
		</div>


		<hr class="my-4">

		<div class="text-center text-muted">
			<small>© 2025 Admin Dashboard | Powered by NGUYỄN QUỐC BẢO</small>
		</div>
	</div>

</body>
</html>
