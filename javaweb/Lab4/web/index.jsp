<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <div style="text-align:center;color: red">${error}</div>
   <form action="/Lab4_war_exploded/LoginCheckServlet" method="post">
    <table align="center">
        <tr align="center">
          <td>用户名:</td>
          <td><input type="text" name="uname"></td>
        </tr>
        <tr align="center">
          <td>密码:</td>
          <td><input type="password" name="pwd"></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="登录" align="center"></td>
        </tr>
    </table>
  </form>
  </body>
</html>
