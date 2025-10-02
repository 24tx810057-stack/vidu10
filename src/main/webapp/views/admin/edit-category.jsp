<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa Category</title>

<!-- Thêm link Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body class="bg-light">

	<div class="container mt-4">
		<h2 class="mb-3">Sửa Category</h2>

		<c:url value="/admin/category/edit" var="edit"></c:url>
		<form action="${edit}" method="post" enctype="multipart/form-data"
			class="card p-4 shadow-sm" style="max-width: 500px;">

			<input type="hidden" name="id" value="${category.id}" />

			<div class="mb-3">
				<label class="form-label">Tên danh mục:</label> <input type="text"
					class="form-control" name="name" value="${category.name}" required>
			</div>

			<div class="mb-3">
				<label class="form-label">Ảnh hiện tại:</label><br>
				<c:url value="/image?fname=${category.icon}" var="imgUrl"></c:url>
				<img src="${imgUrl}" alt="Ảnh" width="120"
					class="border rounded mb-2">
			</div>

			<div class="mb-3">
				<label class="form-label">Chọn ảnh mới:</label> <input type="file"
					class="form-control" name="icon">
			</div>

			<button type="submit" class="btn btn-primary">Cập nhật</button>
			<a href="${pageContext.request.contextPath}/admin/category/list"
				class="btn btn-secondary">Quay lại</a>
		</form>
	</div>

</body>
</html>
