<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdatedBsnlNetwork</title>
</head>

<body style="text-align: center;">
<form action="updatebsnlController" method="get">
<h1>Update Plan</h1>
<div>
<label for="planName"><strong>PlanName</strong></label>
<input type="text" name="planname" id="planName">
</div><br><br>
<div>
<label for="Price"><strong>PlanAmount</strong></label>
<input type="number" name="price" id="Price">
</div><br><br>
<div>
<label for="Validity"><strong>Validity</strong></label>
<input type="text" name="validity" id="Validity">
</div><br><br>
<div>
<label for="Benefits"><strong>Benefits</strong></label>
<input type="text" name="benefits" id="Benefits">
</div><br><br>
<div>
<label for="Bsnlplanid"><strong>planId</strong></label>
<input type="number" name="bsnlplanId" id="Bsnlid">
</div>
 <input type="submit" value="UPDATE"> 
</form>
</body>
</html>