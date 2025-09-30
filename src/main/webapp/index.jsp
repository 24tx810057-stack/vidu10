<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // Khi vào http://localhost:8080/vidu10/ thì nó nhảy qua /login
    response.sendRedirect(request.getContextPath() + "/login");
%>
