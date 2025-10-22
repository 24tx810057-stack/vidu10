<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách danh mục</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container mt-4">
		<h2 class="mb-3">Quản lý danh mục</h2>
		<table
			class="table table-bordered table-hover text-center align-middle">
			<thead class="table-primary">
				<tr>
					<th>STT</th>
					<th>Hình ảnh</th>
					<th>Tên danh mục</th>
					<th>Hành động</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cate" items="${cateList}" varStatus="status">
					<tr>
						<td>${status.index + 1}</td>
						<td><img
							src="${pageContext.request.contextPath}/image?fname=${cate.icon}"
							alt="Ảnh" width="80" /></td>
						<td>${cate.name}</td>
						<td><a
							href="${pageContext.request.contextPath}/admin/category/edit?id=${cate.id}"
							class="btn btn-sm btn-warning">Sửa</a> <a
							href="${pageContext.request.contextPath}/admin/category/delete?id=${cate.id}"
							class="btn btn-sm btn-danger"
							onclick="return confirm('Xóa danh mục này?');">Xóa</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<a href="${pageContext.request.contextPath}/admin/category/add"
			class="btn btn-success">+ Thêm mới</a>
	</div>

</body>
</html>

