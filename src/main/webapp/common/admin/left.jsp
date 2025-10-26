<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div
	class="col-12 col-md-3 col-lg-2 sidebar d-flex flex-column p-3 bg-dark text-light"
	style="min-height: 100vh;">

	<h6 class="text-uppercase fw-bold text-light border-bottom pb-2 mb-3"
		style="letter-spacing: 1px;">Quản lý</h6>


	<!-- Menu Links -->
	<a href="${pageContext.request.contextPath}/admin/home"
		class="text-decoration-none text-light mb-2 d-flex align-items-center">
		<i class="bi bi-house me-2"></i> Trang chủ
	</a> <a href="${pageContext.request.contextPath}/admin/list-category"
		class="text-decoration-none text-light mb-2 d-flex align-items-center">
		<i class="bi bi-tags me-2"></i> Danh mục
	</a>

	<%-- 	<a href="${pageContext.request.contextPath}/admin/list-product"
	   class="text-decoration-none text-light mb-2 d-flex align-items-center">
		<i class="bi bi-box-seam me-2"></i> Sản phẩm
	</a>

	<a href="${pageContext.request.contextPath}/admin/report"
	   class="text-decoration-none text-light mb-2 d-flex align-items-center">
		<i class="bi bi-graph-up me-2"></i> Thống kê
	</a>

	<a href="${pageContext.request.contextPath}/admin/users"
	   class="text-decoration-none text-light mb-2 d-flex align-items-center">
		<i class="bi bi-people me-2"></i> Người dùng
	</a> --%>

	<%-- <hr class="border-secondary my-3">

	<a href="${pageContext.request.contextPath}/logout"
	   class="text-decoration-none text-danger fw-semibold d-flex align-items-center">
		<i class="bi bi-box-arrow-right me-2"></i> Đăng xuất
	</a> --%>
</div>
