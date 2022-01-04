<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RechargeyourNumber</title>
</head>
<body style="text-align:center";>
<form action="RechargeController">
<label for="MobileNumber"><strong>MOBILE NUMBER</strong></label>
<input type="number" name="mobileNumber" id="MobileNumber"><br>
<br>
<label for="Price"><strong>AMOUNT</strong></label>
<input type="number" name="price" id="Price"><br>
<br>
<input type="submit" value="Recharge">
</form>
</body>
</html>