<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<h1>Header của ADMIN</h1>

<c:choose>

	<c:when test="${sessionScope.account == null}">
		<div class="col-sm-6">
			<ul class="list-inline right-topbar pull-right">
				<li><a href="${pageContext.request.contextPath}/login">Đăng
						nhập</a> | <a href="${pageContext.request.contextPath}/register">Đăng
						ký</a></li>
				<li><i class="search fa fa-search search-button"></i></li>
			</ul>
		</div>
	</c:when>


	<c:otherwise>
		<div class="col-sm-6">
			<ul class="list-inline right-topbar pull-right">
				<li><a
					href="${pageContext.request.contextPath}/member/myaccount">
						${sessionScope.account.fullname} </a> | <a
					href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
				<li><i class="search fa fa-search search-button"></i></li>
			</ul>
		</div>
	</c:otherwise>
</c:choose>


















<%-- 
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
				<p>Đây là trang quản trị, chọn menu bên trái để tiếp tục.</p>
			</div>
		</div>
	</div>
	
	--%>

</body>
</html>
