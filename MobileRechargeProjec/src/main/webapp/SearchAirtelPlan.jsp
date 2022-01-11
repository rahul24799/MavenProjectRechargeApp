<%@page import="com.mobilerechargeapp.model.AirtelUser"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SearchAirtelPlan</title>
<style>
body {
	overflow: hidden;
}

table {
	/*  background: cornflowerblue; */
	background: inactiveborder;
	padding: 10px;
	position: absolute;
	top: 70px;
}

table, tr, td {
	text-align: left;
	height: 40px;
	padding: 3px 10px;
	margin-top: 10px;
	font-size: medium;
}

tr:nth-child(even) {
	background-color: #3f56fb;
	color: white;
	padding: 10px;
	margin-left: 19px;
}

tr:hover {
	background-color: threedlightshadow;
}

td.links {
	text-align: center;
}

td.links a {
	color: rgba(#3f56fb, #fc466b);
	text-decoration: none;
	font-weight: bold;
	font-family: sans-serif;
	font-size: 15px;
	/*  background: aliceblue; */
	padding: 9px;
}

.header a {
	padding: 12px 18px;
	text-decoration: none;
	font-weight: bold;
	color: white;
}

.header {
	background: linear-gradient(to right, #3f56fb, #fc466b);
	padding: 0px;
	display: flex;
	justify-content: space-around;
	position: absolute;
	top: 30px;
	width: 100%;
}

.header a:hover {
	background: white;
	color: black;
}
</style>
</head>
<body>
	<form>
		<div class="header">
			<a href="Operator.jsp">Home</a> <a href="wallet.jsp">wallet</a> <a
				href="history.jsp">RechargeHistory</a> <a href="aboutus.jsp">AboutUs</a>
			<a href="contectus.jsp">ContectUs</a> <a href="logout.jsp">Logout</a>
		</div>
	</form>
	<table style="width: 100%">
		<tr>

			<td><strong>PlanName</strong></td>
			<td><strong>Price</strong></td>
			<td><strong>validity</strong></td>
			<td><strong>Benefit</strong></td>
			<td><strong>Operator</strong></td>


		</tr>
		<%
          
		List<AirtelUser> airtelUser=(List<AirtelUser>)session.getAttribute("list");	
			for(int i=0;i<airtelUser.size();i++)
			{
				AirtelUser airtelUser1=airtelUser.get(i);
	
	
           %>

		<tr>
			<td><%= airtelUser1.getPlanName() %></td>
			<td><%= airtelUser1.getPrice() %></td>
			<td><%= airtelUser1.getValidity() %></td>
			<td><%= airtelUser1.getBenfits() %></td>
			<td><%= airtelUser1.getOperator().getOperatorname() %></td>
			<td class="links"><a
				href="recharge.jsp?planName=<%=airtelUser1.getPlanName()%>&price=<%=airtelUser1.getPrice()%>
&operator=<%=airtelUser1.getOperator().getOperatorname()%>"><button>Recharge</a>
		</tr>

		<%}%>
	</table>
</body>
</html>