<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login</title>
</head>
<body>
<%
    Integer status = (Integer) request.getAttribute("status");
    if(status != null && status == 1)
    {
%>

<div style="text-align:center;">

</div>
<h1 align="center">欢迎，${username}</h1>
<%
    }else{

%>
<div style="text-align:center;">
<form action="/lab4/userLoginServlet" method="post">

    <label for="username">用户名：</label>
    <input type="text" name="username" id="username"><br>

    <label for="password">密码：</label>
    <input type="password" name="password" id="password"><br>

    <input type="submit" value="提交查询">
</form>
</div>
<%
    }
%>
</body>
</html>