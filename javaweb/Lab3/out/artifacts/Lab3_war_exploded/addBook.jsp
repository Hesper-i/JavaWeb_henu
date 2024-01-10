<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>addUser Page</title>
  </head>
  <body>
  <form action="doAddBook.jsp">
    <table>
      <tr>
        <td>书名：</td>
        <td><input type="text" name="bookName"></td>
      </tr>

      <tr>
        <td>价格：</td>
        <td><input type="number" step="0.01" name="price"></td>
      </tr>

      <tr>
        <td>数量：</td>
        <td><input type="number" step="1" name="count"></td>
      </tr>

      <tr>
        <td>作者：</td>
        <td><input name="author"></td>
      </tr>

      <tr>
        <td><input type="submit" value="提交"></td>
      </tr>
    </table>
  </form>
  </body>
</html>
