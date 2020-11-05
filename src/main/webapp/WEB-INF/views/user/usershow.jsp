<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>爱电影后台管理项目</title>
</head>
<body>
<c:forEach items="${users }" var="user">
<p>${user.id }--${user.username }--${user.password }</p>
</c:forEach>
</body>
</html>