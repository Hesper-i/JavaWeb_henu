<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show</title>
</head>
<body>
<div style="text-align: center;">
    <h1>添加图书成功</h1>
    <p>以下是您刚刚添加的图书信息：</p>
    <table align="center" border="1.5" style="border-collapse: collapse">
        <tr>
            <th>图书名称</th>
            <th>图书价格</th>
            <th>图书作者</th>
            <th>出版社</th>
            <th>存放数量</th>
        </tr>
        <tr>
            <td>${book.name}</td>
            <td>${book.price}</td>
            <td>${book.author}</td>
            <td>${book.publisher}</td>
            <td>${book.stock}</td>
        </tr>
    </table>
</div>
</body>
</html>
