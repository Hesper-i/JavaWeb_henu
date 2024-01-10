<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<%!
    String userName = "root";
    String userPassword = "admin";
%>


<%
    //获取用户名和密码
    String username = request.getParameter("username");
    String password = request.getParameter("password");
%>

<%
    if(username != null && password!= null && username.equals(userName) && password.equals(userPassword))
    {
%>
    <h1>欢迎，<%=username%></h1>
<%
    }
    else
    {
%>
<div style="text-align:center;">
    <form action="login.jsp" method="post">

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
