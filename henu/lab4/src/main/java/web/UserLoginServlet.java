package web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(value = "/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理POST请求的中文问题
        request.setCharacterEncoding("utf-8");

        //获取post请求中用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //连接数据库
        try {
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
                //封装登录结果（成功）
                request.setAttribute("status", 1);
                request.setAttribute("username", username);
            }
            else
                //封装登录结果（失败）
                request.setAttribute("status", 0);

            //转发界面
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        } catch (Exception e) {
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}