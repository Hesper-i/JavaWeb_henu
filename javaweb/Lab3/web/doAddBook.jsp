<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>doAddUser Page</title>
</head>
<body>
<%
    String bookName = request.getParameter("bookName");
    Double price = Double.parseDouble(request.getParameter("price"));
    Integer count = Integer.parseInt(request.getParameter("count"));
    String author = request.getParameter("author");

    String sql= String.format("insert into book(name, price, bookCount, author) values('%s', '%f', '%d', '%s')", bookName, price, count, author);
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/hwdlab?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
    Connection con = DriverManager.getConnection(url, "root", "123456");
    Statement stmt = con.createStatement();

    int res = stmt.executeUpdate(sql);
    if (res > 0)
    {
        response.sendRedirect("index.jsp");
    }else{
        response.sendRedirect("addBook.jsp");
    }
%>

</body>
</html>
