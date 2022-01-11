<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.JioDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.JioUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShowplanJio</title>

</head>
<style >

body{
overflow: hidden;
}
table {
	/*  background: cornflowerblue; */
	background: inactiveborder;
	padding: 10px;
	position: absolute;
	top:70px;
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
	top:0px;
	width: 100%;
}

.header a:hover {
	background: white;
	color: black;
}
.searchbar{
position: relative;
top:50px;
left:1050px;
}

/* body{
background-image:url("images/backimg.jpg");
} */
</style>
<body>
<div class="searchbar">
<form action="SearchJioPlan.jsp">
<label for="plan"></label>
<input type="text" name="jioplan" id="plan">
<input type="submit" value="search">
</div>

</form>

	<div class="header">
		<a href="Operator.jsp">Home</a> <a href="wallet.jsp">wallet</a> <a
			href="history.jsp">RechargeHistory</a> <a href="aboutus.jsp">AboutUs</a>
		<a href="contectus.jsp">ContectUs</a>
		
		 <a href="logout.jsp">Logout</a>
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
JioDAOImpl jioDao=new JioDAOImpl();
 List<JioUser>ShowPlan=jioDao.showJioplan();
 
for(int i=0;i<ShowPlan.size();i++)
{
	JioUser jioUser=ShowPlan.get(i);
	String planName=jioUser.getPlanName();
	
	
%>
<tr>
				<td><%= jioUser.getPlanName() %></td>
				<td><%= jioUser.getPrice() %></td>
				<td><%= jioUser.getValidity() %></td>
				<td><%= jioUser.getBenfits() %></td>
				<td><%= jioUser.getOperator().getOperatorname() %></td>
				<td class="links"><a
					href="recharge.jsp?planName=<%=jioUser.getPlanName() %>&price=<%= jioUser.getPrice() %>
&operator=<%= jioUser.getOperator().getOperatorname() %>"><button>Recharge</a>
				</button></td>
			</tr>

			<%}%>
		</table>



	</form>
</body>
</html>