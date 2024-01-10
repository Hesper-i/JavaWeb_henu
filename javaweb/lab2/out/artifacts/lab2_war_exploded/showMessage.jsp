<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
    ArrayList<String> list = new ArrayList<String>();
%>
<h1>留言区</h1><br/>
<%
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("username");
        String message = request.getParameter("message");
        String address = request.getRemoteAddr();//获取本机IP地址
        list.add(name+"@"+address+"@"+"说："+message+"<br>");
        for(int i=0;i<list.size();i++){
            out.println(list.get(i));
        }
 %>
 <br/>
</body>

</html>