<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String username=request.getParameter("username"); %>
欢迎，<%= username %>
<br>
<br>
<a href="addMessage.jsp">点击跳转留言页面</a>

</body>
</html>