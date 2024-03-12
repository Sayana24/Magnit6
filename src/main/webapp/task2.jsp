<%--
  Created by IntelliJ IDEA.
  User: sayan
  Date: 12.03.2024
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Введите параметры</h1>
<form action="<%=request.getContextPath()%>/Task2Servlet" method="get">
    Введите максимальную сумму: <input type="text" name="maxSum"><br><br>
    Ведите количество товаров: <input type="text" name="quantity"><br><br>
    <input type="submit" value="Далее">
</form>
</body>
</html>
