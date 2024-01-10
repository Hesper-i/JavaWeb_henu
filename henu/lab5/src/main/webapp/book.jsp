<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>addBook</title>
</head>
<body>
<h3>添加图书</h3>
<form action="/lab5/bookServlet" method="post">
    图书名称：<input name="bookname"><br>
    图书价格：<input name="bookprice"><br>
    图书作者：<input name="bookauthor"><br>
    出版社：<input name="bookpublisher"><br>
    存放数量：<input name="bookamount"><br>

    <input type="submit" value="提交">
</form>
</body>
</html>
