<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h1>Trang cho User</h1>
<p>Phần nội dung cho user </p>


<%-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
    <h2>Xin chào, 
        <c:if test="${not empty sessionScope.account}">
            ${sessionScope.account.username}
        </c:if>
    </h2>

    <ul>
        <li><a href="${pageContext.request.contextPath}/profile">Hồ sơ</a></li>
        <li><a href="${pageContext.request.contextPath}/logout">Đăng xuất</a></li>
    </ul>
</body>
</html>
--%>