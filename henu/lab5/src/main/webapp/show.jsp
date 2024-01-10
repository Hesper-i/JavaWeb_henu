<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>show</title>
</head>
<body>
<div style="text-align: center;">
<center>
    <table border="1" cellspacing="0" width="80%">
        <tr align="center">
            <th>图书名称</th>
            <th>图书价格</th>
            <th>图书作者</th>
            <th>出版社</th>
            <th>存放数量</th>
        </tr>
        <tr align="center">
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.author}</td>
            <td>${book.publisher}</td>
            <td>${book.amount}</td>
        </tr>
    </table>
</center>
</div>
</body>
</html>
