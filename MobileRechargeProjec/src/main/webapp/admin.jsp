<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adminlogin</title>
</head>
<body style="text-align: center;">
<form action="AdminController" method="post">
<h1 style="color: rgb(102, 153, 7); font-style: italic;">ADMIN LOGIN</h1>
Username:<input type="text" name="username"><br><br>
password:<input type="password" name="password"><br><br>
<input type="submit" value="login">&nbsp;&nbsp;
<input type="reset" value="Reset">
</form>
</body>
</html>