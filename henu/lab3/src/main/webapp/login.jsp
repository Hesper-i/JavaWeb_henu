<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<%
%>


<%
    //获取用户名和密码
    String username = request.getParameter("username");
    String password = request.getParameter("password");
%>

<%
    if(username != null && password!= null)
    {
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false";
        String sqlusername = "root";
        String sqlpassword = "admin";
        Connection conn = DriverManager.getConnection(url, sqlusername, sqlpassword);
        //定义sql
        String sql = String.format("select * from tb_user where username = '%s' and password = '%s'", username, password);

        //获取statement对象
        Statement stmt = conn.createStatement();

        //执行sql
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next())
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
        <input type="text" name="username"><br>

        <label for="password">密码：</label>
        <input type="password" name="password"><br>

        <input type="submit" value="提交查询">
    </form>
</div>
<%
    }
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
