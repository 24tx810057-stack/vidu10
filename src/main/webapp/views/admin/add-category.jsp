<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Category</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-4">
    <h2>Thêm Category</h2>
    <form role="form" 
          action="${pageContext.request.contextPath}/admin/category/add" 
          method="post" 
          enctype="multipart/form-data">

        <div class="mb-3">
            <label class="form-label">Tên danh mục:</label>
            <input class="form-control" placeholder="Nhập tên danh mục" name="name" />
        </div>

        <div class="mb-3">
            <label class="form-label">Ảnh đại diện:</label>
            <input type="file" class="form-control" name="icon" />
        </div>

        <button type="submit" class="btn btn-success">Thêm</button>
        <button type="reset" class="btn btn-secondary">Hủy</button>
    </form>
</div>

</body>
</html>



































<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Category</title>
</head>
<body>
	<h2>Thêm Category</h2>
	<form role="form" 
      action="${pageContext.request.contextPath}/admin/category/add" 
      method="post" 
      enctype="multipart/form-data">

		<div class="form-group">
			<label>Tên danh mục:</label> <input class="form-control"
				placeholder="please enter category name" name="name" />
		</div>

		<div class="form-group">
			<label>Ảnh đại diện:</label> <input type="file" name="icon" />
		</div>

		<button type="submit" class="btn btn-default">Thêm</button>
		<button type="reset" class="btn btn-primary">Hủy</button>
	</form>
</body>
</html>
--%>