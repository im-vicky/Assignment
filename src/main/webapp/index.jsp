<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Servlet Assignment</title>
</head>
<body>
<a href="/getservlet">GetServlet</a>

<form action="/firstservlet" method="post">
    FirstNumber : <input type="number" name="number1">
    SecondNumber : <input type="number" name="number2">
    <input type="submit">
</form>
</body>
</html>