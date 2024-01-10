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
    //获取用户名和密码
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if(username != null && password!= null)
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/hwdlab?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";;
        String sqlusername = "root";
        String sqlpassword = "123456";
        Connection conn = DriverManager.getConnection(url, sqlusername, sqlpassword);
        //定义sql
        String sql = String.format("select * from lab_user where username = '%s' and password = '%s'", username, password);

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
            request.setAttribute("error", "用户名或密码错误,请重新登录");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
else
{
    response.sendRedirect("index.jsp");
    }
%>
</body>
</html>
