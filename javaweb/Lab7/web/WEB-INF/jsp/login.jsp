<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
</head>
<body>
${msg}
<form action="${pageContext.request.contextPath}/login" method="post">
    <table align="center">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" /></td>
        </tr>

        <tr>
            <td>密码</td>
            <td><input type="password" name="password" /></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><input type="submit" value="登录"/></td>
        </tr>
    </table>

</form>
</body>
</html>

