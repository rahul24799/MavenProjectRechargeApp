<%@page import="com.mobilerechargeapp.model.AirtelUser"%>

<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.AirtelDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShowAirtelPlan{</title>
</head>
<style type="text/css">
table {
	/*  background: cornflowerblue; */
	background: inactiveborder;
	position: absolute;
	padding: 10px;
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
	padding: 10px; 5
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
	padding: 12px 28px;
	text-decoration: none;
	font-weight: bold;
	color: white;
}

.header {
	background: linear-gradient(to right, #3f56fb, #fc466b);
	padding: 0px;
	display: flex;
	justify-content: space-around;
}

.header a:hover {
	background: white;
	color: black;
}

/* .searchbar {
	position: relative;
	top: 60px;
	left: 1050px;
} */
</style>
<body>
	<div class="searchbar">
		<form action="SearchAirtelPlanController">
			<label for="plan"></label> <input type="text" name="airtelplan"
				id="plan"> <input type="submit" value="search">
	</div>
	<div class="header">
		<a href="Operator.jsp">Home</a> <a href="wallet.jsp">wallet</a> <a
			href="history.jsp">RechargeHistory</a> <a href="aboutus.jsp">AboutUs</a>
		<a href="contectus.jsp">ContectUs</a> <a href="logout.jsp">Logout</a>
	</div>
	<form>
		<table style="width: 100%">
			<tr>

				<td><strong>PlanName</strong></td>
				<td><strong>Price</strong></td>
				<td><strong>validity</strong></td>
				<td><strong>Benefit</strong></td>
				<td><strong>Operator</strong></td>


			</tr>
			<%
			AirtelDAOImpl airtelDao = new AirtelDAOImpl();

			List<AirtelUser> ShowPlan = airtelDao.showAirtelplan();
			for (int i = 0; i < ShowPlan.size(); i++) {
				AirtelUser airtelUser = ShowPlan.get(i);
				String planName = airtelUser.getPlanName();
			%>
			<tr>
				<td><%=airtelUser.getPlanName()%></td>
				<td><%=airtelUser.getPrice()%></td>
				<td><%=airtelUser.getValidity()%></td>
				<td><%=airtelUser.getBenfits()%></td>
				<td><%=airtelUser.getOperator().getOperatorname()%></td>
				<td class="links"><a
					href="recharge.jsp?planName=<%=airtelUser.getPlanName()%>&price=<%=airtelUser.getPrice()%>
&operator=<%=airtelUser.getOperator().getOperatorname()%>"><button>Recharge</a>
					</button></td>


			</tr>
			<%
			}
			%>
		</table>



	</form>
</body>
</html>