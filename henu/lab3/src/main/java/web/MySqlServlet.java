package web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(value = "/mySqlServlet")
public class MySqlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "admin";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);

            // 接收用户输入 用户名和密码
            String name = "zhangsan";
            String pwd = "123";
            // 定义sql
            String sql = "select * from tb_user where username = ? and password = ?";
            // 获取pstmt对象
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // 设置？的值
            pstmt.setString(1,name);
            pstmt.setString(2,pwd);
            // 执行sql
            ResultSet rs = pstmt.executeQuery();
            // 判断登录是否成功
            if(rs.next()){
                System.out.println("登录成功~");
            }else{
                System.out.println("登录失败~");
            }
            //7. 释放资源
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}