<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addBook</title>
</head>
<body>
<form action="BookServlet" method="get">
    <table align="center">
        <tr>
            <td>图书名称: </td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>图书价格: </td>
            <td><input type="number" step="0.01" name="price"></td>
        </tr>
        <tr>
            <td>书籍作者: </td>
            <td><input type="text" name="author"></td>
        </tr>
        <tr>
            <td>出版商: </td>
            <td><input type="text" name="publisher"></td>
        </tr>
        <tr>
            <td>库存数量: </td>
            <td><input type="number" step="1" name="stock"></td>
        </tr>
        <input type="hidden" name="operation" value="add">
        <tr align="center">
            <td colspan="2"><input type="submit" value="提交" align="center"></td>
        </tr>
    </table>
</form>
</body>
</html>
