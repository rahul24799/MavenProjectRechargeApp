<%@page import="com.mobilerechargeapp.model.AirtelUser"%>

<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.AirtelDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
table,tr,td{
border:1px solid black;
border-collapse:collapse;

}</style>

 <form align="center">
  <table >
    <tr>
   
    <td><strong>PlanName</strong></td>
    <td><strong>Price</strong></td>
    <td><strong>validity</strong></td>
    <td><strong>Benefit</strong></td>
  	<td><strong>Operator</strong></td>
  	
  	</tr>
<%
AirtelDAOImpl airtelDao=new AirtelDAOImpl();;
 List<AirtelUser>ShowPlan=airtelDao.showAirtelplan();
 
for(int i=0;i<ShowPlan.size();i++)
{
	AirtelUser airtelUser=ShowPlan.get(i);
	
%>
<tr>
<td><%= airtelUser.getPlanName() %></td>
<td><%= airtelUser.getPrice() %></td>
<td><%= airtelUser.getValidity() %></td>
<td><%= airtelUser.getBenfits() %></td>
<td><%= airtelUser.getOperator().getOperatorname() %></td>

</tr>
<%}%>
</table>

  

  </form>
</body>
</html>