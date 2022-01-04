<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UpdateAirtelPlan</title>
</head>
 <style>
 div{
width:120px;
display:inline-block;
}
</style>
<body style="text-align: center;">
<form action="UpdateairtrelController">
<h1>UpdatePlan</h1>
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
<label for="airtelplanid"><strong>planId</strong></label>
<input type="number" name="airtelplanId" id="airtelplanid">
</div><br><br>
 <input type="submit" value="UPDATE"> 
</form>
</body>
</html>