<%@ page import="utils.DBConnection" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Driver" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showUser Page</title>
</head>
<body>

<table border="1" style="border-collapse: collapse">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>price</td>
        <td>bookCount</td>
        <td>author</td>
    </tr>

    <%
        String sql = "select * from book";
        Connection con = null;
        try {
            con = DBConnection.openConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Statement stmt = null;
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet rs= null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while(true)
        {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    %>
        <tr>
            <td><%= rs.getString("id") %></td>
            <td><%= rs.getString(2) %></td>
            <td><%= rs.getString(3) %></td>
            <td><%= rs.getString(4) %></td>
            <td><%= rs.getString(5) %></td>
        </tr>
    <%
        }
        rs.close();
        stmt.close();
        con.close();
    %>
</table>
</body>
</html>
