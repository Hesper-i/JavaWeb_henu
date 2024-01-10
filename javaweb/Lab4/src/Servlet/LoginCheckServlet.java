package Servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class LoginCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的中文问题
//        request.setCharacterEncoding("utf-8");

        //获取post请求中用户名和密码
        String username = request.getParameter("uname");
        String password = request.getParameter("pwd");

        //连接数据库驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            // 获取连接
            String url = "jdbc:mysql://localhost:3306/hwdlab?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";;
            String sqlusername = "root";
            String sqlpassword = "123456";
            Connection conn = DriverManager.getConnection(url, sqlusername, sqlpassword);

            //定义sql
            String sql = "select * from lab_user where username = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            //执行sql
            ResultSet rs = pstmt.executeQuery();
            String info="";
            if(rs.next()) {
                info = "欢迎您，" + username + "!";
                request.setAttribute("statusMessage", info);
                //转发界面
                request.getRequestDispatcher("/loginresult.jsp").forward(request, response);
            } else {
                info = "用户名或密码不正确！";
                request.setAttribute("error", info);
                //转发界面
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("uname");
        String password = request.getParameter("pwd");

        //连接数据库驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            // 获取连接
            String url = "jdbc:mysql://localhost:3306/hwdlab?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";;
            String sqlusername = "root";
            String sqlpassword = "123456";
            Connection conn = DriverManager.getConnection(url, sqlusername, sqlpassword);

            //定义sql
            String sql = "select * from lab_user where username = ? and password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            //执行sql
            ResultSet rs = pstmt.executeQuery();
            String info="";
            if(rs.next()) {
                info = "欢迎您，" + username + "!";
            } else {
                info = "用户名或密码不正确！";
            }
            request.setAttribute("statusMessage", info);
            //转发界面
            request.getRequestDispatcher("/loginresult.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
