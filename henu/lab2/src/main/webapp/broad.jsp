<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>broad</title>
</head>
<body>
<%!
    class User
    {
        public String username;
        public String usertext;
        public String ip;
    }
    List<User> users = new ArrayList<>();
%>

<%
    String username = request.getParameter("username");
    String usertext = request.getParameter("usertext");
    String remoteAddr = request.getRemoteAddr();
    if(username != null && usertext != null && remoteAddr != null)
    {
        User user = new User();
        user.username = username;
        user.usertext = usertext;
        user.ip = remoteAddr;
        users.add(user);
    }
%>
<div style="text-align:center;">
<form action="broad.jsp" method="get">

    <label for="username">用户：</label>
    <input type="text" name="username" id="username"><br>

    <label for="usertext">留言：</label>
    <input type="text" name="usertext" id="usertext"><br>

    <br>
    <input type="submit" value="提交">
</form>
</div>
<h3 align="center">留言板</h3>
<%
    for(User user : users)
    {
%>
<hr>
<p align="center"><%=user.username%>@<%=user.ip%>说：<%=user.usertext%></p>
<%
    }
%>
</body>

</html>
