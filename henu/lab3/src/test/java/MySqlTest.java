import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySqlTest {
    @Test
    public void testPreparedStatement() throws  Exception {
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "admin";
        Connection conn = DriverManager.getConnection(url, username, password);

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
    }
}
