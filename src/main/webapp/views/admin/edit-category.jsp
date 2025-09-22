<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa Category</title>
</head>
<body>

	<h2>Sửa Category</h2>

	<c:url value="/admin/category/edit" var="edit"></c:url>
	<form role="form" action="${edit}" method="post"
		enctype="multipart/form-data">
		
		<input name="id" value="${category.id}" hidden="hidden" />

		<div class="form-group">
			<label>Tên danh sách:</label>
			<input type="text" class="form-control" name="name"
				value="${category.name}" />
		</div>

		<div class="form-group">
			<c:url value="/image?fname=${category.icon}" var="imgUrl"></c:url>
			<img class="img-responsive" width="100px" src="${imgUrl}" alt="">
			<br>
			<label>Ảnh đại diện:</label>
			<input type="file" name="icon" />
		</div>

		<button type="submit" class="btn btn-default">Edit</button>
		<button type="reset" class="btn btn-primary">Reset</button>
	</form>

</body>
</html>
