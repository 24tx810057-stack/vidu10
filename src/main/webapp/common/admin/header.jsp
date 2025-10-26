<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!-- HEADER ADMIN -->
<nav class="navbar navbar-dark bg-dark px-3">
	<a class="navbar-brand fw-bold text-uppercase" href="#"> Admin
		Panel </a>

	<div class="d-flex align-items-center text-light">

		<!-- Link sang trang người dùng -->
		<a href="${pageContext.request.contextPath}/web/home"
			class="text-light me-3 text-decoration-none"> <i
			class="bi bi-house-door"></i> Trang khách hàng
		</a>

		<!-- Kiểm tra đăng nhập -->
		<c:choose>
			<c:when test="${sessionScope.account == null}">
				<a href="${pageContext.request.contextPath}/login"
					class="text-light text-decoration-none me-3"> <i
					class="bi bi-box-arrow-in-right"></i> Đăng nhập
				</a>
			</c:when>

			<c:otherwise>
				<span class="me-3"> <i class="bi bi-person-circle"></i>
					${sessionScope.account.fullname}
				</span>
				<a href="${pageContext.request.contextPath}/logout"
					class="text-light text-decoration-none"> <i
					class="bi bi-box-arrow-right"> </i> Đăng xuất
				</a>
			</c:otherwise>
		</c:choose>
	</div>
</nav>
