<%@page import="java.util.ArrayList"%>
<%@page import="hwd.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "showMessage.jsp" method = "post" >
用户：<input type = "text" name = "username" style =" width:200px" /><br>
<br>
留言：<input type = "text" name = "message" style =" width:200px" /><br>
<br>
<input type = "submit" value = "提交" /><br>
<br>
</form>
<a href = 'showMessage.jsp' >查看留言</a>
</body>
</html>