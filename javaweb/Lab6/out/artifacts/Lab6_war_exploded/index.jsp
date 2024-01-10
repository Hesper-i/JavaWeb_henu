<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>addBooks</title>
  </head>
  <body>
<%--  转到展示页面--%>
    <% response.sendRedirect("BookServlet?operation=show");%>
  </body>
</html>
