<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Информация о заказе" %>
</h1>
<br/>
<form action="<%=request.getContextPath()%>/Task1Servlet" method="get">
    Номер заказа: <input type="text" name="number"><br><br>
    <input type="submit" value="Показать">
</form>
</body>
</html>