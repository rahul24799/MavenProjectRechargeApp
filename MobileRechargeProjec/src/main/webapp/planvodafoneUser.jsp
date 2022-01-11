<%@page import="com.mobilerechargeapp.model.JioUser"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.VodafoneDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.VodafoneUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShowPlanVodafone</title>
</head>

<style type="text/css">
table {
   /*  background: cornflowerblue; */
   background:inactiveborder;
    padding: 10px;
}
table, tr, td {
    text-align: left;
    height: 40px;
    padding: 3px 10px;
    margin-top:10px;
    font-size: medium;
}
tr:nth-child(even) {
    background-color: #3f56fb;
    color: white;
    padding: 10px;5
    margin-left: 19px; 
}
tr:hover {background-color:threedlightshadow;}
td.links {
    text-align: center;
}

td.links a {
    color:rgba(#3f56fb, #fc466b);
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
</style>
<body>
	<div class="header">
		<a href="wallet.jsp">wallet</a> <a href="history.jsp">RechargeHistory</a>
		<a href="aboutus.jsp">AboutUs</a> <a href="contectus.jsp">ContectUs</a>
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
VodafoneDAOImpl vodafoneDao=new VodafoneDAOImpl();
 List<VodafoneUser>ShowPlan=vodafoneDao.showViplan();
 
for(int i=0;i<ShowPlan.size();i++)
{
	VodafoneUser vodafoneUser=ShowPlan.get(i);
	String planName=vodafoneUser.getPlanName();
%>
			<tr>

				<td><%= vodafoneUser.getPlanName() %></td>
				<td><%= vodafoneUser.getPrice() %></td>
				<td><%= vodafoneUser.getValidity() %></td>
				<td><%= vodafoneUser.getBenfits() %></td>
				<td><%= vodafoneUser.getOperator().getOperatorname() %></td>
				<td><a
					href="recharge.jsp?planName=<%=vodafoneUser.getPlanName() %>&price=<%= vodafoneUser.getPrice() %>
&operator=<%= vodafoneUser.getOperator().getOperatorname() %>">Recharge</a></td>

			</tr>
			<%}%>
		</table>



	</form>
</body>
</html>