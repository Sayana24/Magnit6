<%--
  Created by IntelliJ IDEA.
  User: sayan
  Date: 13.03.2024
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Введите параметры</h1>
<form action="<%=request.getContextPath()%>/Task3Servlet" method="get">
    Введите название продукта: <input type="text" name="productName"><br><br>
    <input type="submit" value="Далее">
</form>
</body>
</html>
