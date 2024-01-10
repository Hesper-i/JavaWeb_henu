<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logging Page</title>
</head>
<body>
<div align="center">
<h3>欢迎:${USER_SESSION.username}</h3>
<a href="${pageContext.request.contextPath}/logout">退出</a>
</div>
</body>
</html>
