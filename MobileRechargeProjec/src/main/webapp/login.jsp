<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align: center">
<Form action="AdminController">
<h1 style="color: rgb(102, 153, 7); font-style: italic;" > Login </h1>
<label for="Email"><strong>Email-id:</strong></label>
<input type="email" name="email" id="Email" autofocus required  pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+"><br><br>
<label for="PASSWORD"><strong>Password:</strong></label>
<input type="password" name="password" id="PASSWORD" required><br><br>
<input type="submit" value="login">
<a href="index.jsp">Create account?</a>
 </Form>
</body>
</html>