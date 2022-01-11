<%@page import="com.mobilerechargeapp.model.AirtelUser"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.AirtelDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AirtelNetwork</title>
</head>
<style type="text/css">

table {
    background: cornflowerblue;
    padding: 10px;
}
table, tr, td {
    text-align: left;
    height: 40px;
    padding: 3px 10px;
    margin-top:10px;
}
tr:nth-child(even) {
    background-color: #3f56fb;
    color: white;
    padding: 10px;5
    margin-left: 19px; 
}
td.links {
    text-align: center;
}

td.links a {
    color:maroon;
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

}</style>
</head>
<body style="text-align: center;">
 <h1>AIRTEL PLAN</h1>

  <table style="width:100%">
    <tr>
    <td><strong>plan-Id</strong></td>
    <td><strong>PlanName</strong></td>
    <td><strong>Price</strong></td>
    <td><strong>validity</strong></td>
    <td><strong>Benefit</strong></td>
  	<td><strong>Operator</strong></td>
  	</tr>
  	<%
AirtelDAOImpl airtelDao=new AirtelDAOImpl();
List<AirtelUser> ShowPlan=airtelDao.showAirtelplan();
for(int i=0;i<ShowPlan.size();i++)
{
   AirtelUser airtelUser=ShowPlan.get(i);
   int findAirtelId=airtelDao.findairtelId(airtelUser.getPlanName(),airtelUser.getPrice());
	%>
	

	<tr>
<td><%= findAirtelId %>	
<td><%= airtelUser.getPlanName() %></td>
<td><%= airtelUser.getPrice() %></td>
<td><%= airtelUser.getValidity() %></td>
<td><%= airtelUser.getBenfits() %></td>
<td><%= airtelUser.getOperator().getOperatorname() %></td>
<td><a href="DeleteairtelController?airtelId=<%= findAirtelId %>">delete</a></td>
<td><a href="updateairtel.jsp">Edit</a>
</tr>
<%}%>
</table>

 <form>
<a href="addairtel.jsp"><h2>Insert</h2></a>

</form>
</body>
</html>