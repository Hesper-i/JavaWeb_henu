<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>book</title>
</head>
<body>
<center>

<h2 style="align-content: center">
图书管理系统
</h2>
<table border="1" cellspacing="0" width="80%">
  <tr>
    <th>序号</th>
    <th>图书名称</th>
    <th>图书价格</th>
    <th>图书作者</th>
    <th>出版社</th>
    <th>存放数量</th>
    <th>操作</th>
  </tr>

  <c:forEach items="${books}" var="book" varStatus="status">
    <tr align="center">
      <td>${book.id}</td>
      <td>${book.name}</td>
      <td>${book.price}</td>
      <td>${book.author}</td>
      <td>${book.publisher}</td>
      <td style="width:15%"><input type="number" id="amount${book.id}" name="bookamount" value="${book.amount}" style="width:40%"> <a href="/lab8/updateByIdServlet?id=${book.id}&amount="  onclick="handleLinkClick${book.id}(event)">修改</a> </td>
<%--      添加监听事件--%>
      <script>
        function handleLinkClick${book.id}(event) {
          event.preventDefault(); // 取消默认的链接跳转行为

          //获取amount
          var amount = document.getElementById("amount${book.id}").value;

          //通过url重新提交get请求
          window.location.href = "/lab8/updateByIdServlet?id=${book.id}&amount=" + amount;
        }
      </script>
      <td><a href="/lab8/deleteByIdServlet?id=${book.id}#">删除</a></td>
    </tr>
  </c:forEach>
</table>
</center>
<hr>
<center>
  <input type="button" value="新增" id="add" style="width: 10%"><br>
</center>
</body>

<script>
  document.getElementById("add").onclick = function (){
    location.href = "/lab8/addBook.jsp";
  }

</script>
</body>
</html>
