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
<style type="text/css">
table,tr,td{
border:1px solid black;
border-collapse:collapse;


}</style>
<body>
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
<td><a href="recharge.jsp?planName=<%=jioUser.getPlanName() %>&price=<%= jioUser.getPrice() %>
&operator=<%= jioUser.getOperator().getOperatorname() %>" >Recharge</a></td>
</tr>

<%}%>
</table>

  

  </form>
</body>
</html>