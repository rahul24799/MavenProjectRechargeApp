<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align:center";>
<form action="RechargewalletController" method="get">
<h2>WALLET TOPUP</h2>
<label for="EmailId" >EmailID:</label>
<input type="text" name="emailid" id=EmailId"autofocus required ><br>
<br>
<label for="Amount" >AMOUNT:</label>
<input type="number" name="amount" id="Amount"required placeholder="Enter amount"><br>
<br>
<input type="submit" value="RECHARGE">
</form>
</body>
</html>