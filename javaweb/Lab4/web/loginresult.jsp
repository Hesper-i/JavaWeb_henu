<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>info</title>
</head>
<body>
<div style="text-align: center">
    <h2>
<%
    String info = (String)request.getAttribute("statusMessage");
    out.println(info);
%></h2>
</div>
</body>
</html>
