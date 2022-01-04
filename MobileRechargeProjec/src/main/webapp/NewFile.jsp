<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<select onselect="show()">
<option value="jio">Jio</option>
<option>Airtel</option>
<option>Jio</option>
<option>Jio</option>
</select>
<div id="jio" style="display:none;">
<form>

Jio Plans
</form>
</div>
<div id="airtel" style="display:none;">
<form>

Airtel Plans
</form>
</div>
</body>
</html>