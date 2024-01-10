<%@ page import="java.util.List" %>
<%@ page import="book.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>showBook</title>
</head>
<body>
<table border="1" cellspacing="0" width="100%" align="center">
    <tr>
        <th>图书书名</th>
        <th>图书价格</th>
        <th>图书作者</th>
        <th>出版社</th>
        <th>存放数量</th>
        <th>库存数量</th>
        <th>删除</th>
    </tr>

    <%
        List<Book> bookList = (List<Book>) request.getAttribute("list");
        if (bookList.size() != 0) {
            for (Book onebook : bookList) {
    %>
    <tr align="center">
        <td><%=onebook.getname()%></td>
        <td><%=onebook.getPrice()%></td>
        <td><%=onebook.getauthor()%></td>
        <td><%=onebook.getPublisher()%></td>
        <td><%=onebook.getStock()%></td>
        <td style="width: 180px;padding: 5px 6px 0 5px;line-height: 16px">
            <form action="BookServlet">
                <input type="text" name="newBookNum">
                <input type="submit" value="修改">
                <input type="hidden" name="name" value="<%=onebook.getname()%>">
                <input type="hidden" name="operation" value="update">
            </form>
        </td>

        <td style="padding: 5px 6px 0 5px;line-height: 16px">
            <form action="BookServlet">
            <input type="hidden" name="name" value="<%=onebook.getname()%>">
            <input type="hidden" name="operation" value="delete">
            <input type="submit" value="删除" onclick="return confirm('确认删除？');">
            </form>
        </td>
    </tr>

    <%
        }}else{
    %>
        <tr>
            <td colspan="6">数据库中无数据！</td>
        </tr>
    <%
        }
    %>
</table>

<br> <br>
<a href="addBook.jsp">添加图书信息</a>

</body>
</html>
