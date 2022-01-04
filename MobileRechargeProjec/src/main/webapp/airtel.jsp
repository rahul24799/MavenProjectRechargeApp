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
table,tr,td{
border:1px solid black;
border-collapse:collapse;

}</style>
</head>
<body style="text-align: center;">
 <h1>AIRTEL PLAN</h1>
  <form>
  <table >
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
	
	<%int airtelplanId=Integer.parseInt(request.getParameter("airtelDel"));
airtelDao.deleteAirtel(airtelplanId); %>
	<tr>
<td><%= findAirtelId %>	
<td><%= airtelUser.getPlanName() %></td>
<td><%= airtelUser.getPrice() %></td>
<td><%= airtelUser.getValidity() %></td>
<td><%= airtelUser.getBenfits() %></td>
<td><%= airtelUser.getOperator().getOperatorname() %></td>
<td><a href="airtel.jsp?airtelDel=<%=airtelUser.getAirtelId()%>">Delete</a> </td>
</tr>
<%}%>
</table>
 </form>
 <form>
<a href="addairtel.jsp">Insert</a>
<a href="updateairtel.jsp">Update</a>

</form>
</body>
</html>