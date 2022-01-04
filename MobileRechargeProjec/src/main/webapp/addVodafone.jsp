<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>insertVodafone</title>
</head>

<body style="text-align:center;">
<form action="AddvodafoneController">
 <h1 style="color: rgb(102, 153, 7); font-style: italic;">ADD PLAN </h1>
<label for="PlanName"><strong>PlanName</strong></label>
<input type="text" name="planname" id="planName"><br><br>
<label for="Price"><strong>PlanAmount</strong></label>
<input type="number" name="price" id="Price"><br><br>
<label for="Validity"><strong>Validity</strong></label>
<input type="text" name="validity" id="Validity"><br><br>
<label for="Benefits"><strong>Benefits</strong></label>
<input type="text" name="benefits" id="Benefits"><br><br>
<label for="Operatorname"><strong>OperatorName</strong></label> 
 <input type=""text" name="operatorName" id="Operatorname"  required><br><br>
 <input type="submit" value="ADD"> 
</form>
</body>
</html>