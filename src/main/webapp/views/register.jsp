<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
</head>
<body>
    <h2>Tạo tài khoản mới</h2>

    <c:if test="${not empty alert}">
        <p style="color:red">${alert}</p>
    </c:if>

    <form action="register" method="post">
        <p>
            <label>Username:</label><br>
            <input type="text" name="username" required>
        </p>
        <p>
            <label>Password:</label><br>
            <input type="password" name="password" required>
        </p>
        <p>
            <label>Email:</label><br>
            <input type="email" name="email" required>
        </p>
        <p>
            <label>Họ và tên:</label><br>
            <input type="text" name="fullname" required>
        </p>
        <p>
            <label>Số điện thoại:</label><br>
            <input type="text" name="phone" required>
        </p>
        <p>
            <button type="submit">Tạo tài khoản</button>
        </p>
    </form>
    <p>Bạn đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập</a></p>
</body>
</html>
