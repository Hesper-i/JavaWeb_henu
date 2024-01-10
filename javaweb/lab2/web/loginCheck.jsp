<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String username = request.getParameter("username");
String password = request.getParameter("password");

if(username!=""&&password.equals("123456"))
{
	%><jsp:forward page="main.jsp"></jsp:forward><%
}else
{
	%><jsp:forward page="login.jsp"></jsp:forward><%
}
%>

%>
</body>
</html>