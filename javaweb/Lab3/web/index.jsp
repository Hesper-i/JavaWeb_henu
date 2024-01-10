<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
</head>
<body>
<div style="text-align:center;color: red">${error}</div>
<div style="text-align:center;">
    <form action="login.jsp" method="post">

        <label for="username">用户名：</label>
        <input type="text" name="username" id="username"><br>

        <label for="password">密码：</label>
        <input type="password" name="password" id="password"><br>

        <input type="submit" value="登录">
    </form>
</div>
</body>
</html>
