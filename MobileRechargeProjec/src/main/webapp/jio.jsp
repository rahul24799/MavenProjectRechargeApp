<%@page import="com.mobilerechargeapp.daoimpl.OperatorDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.JioUser"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.JioDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JioNetwork</title>
</head>
<body>
<form>
<h1><strong>JIO NETWORK</strong></h1>

<style type="text/css">
table,tr,td{
border:1px solid black;
border-collapse:collapse;

}</style>
</head>
<body>
  <h1>ShowPlan</h1>
  <form align="center">
  <table >
    <tr>
    <td><strong>plan-Id</strong></td>
    <td><strong>PlanName</strong></td>
    <td><strong>Price</strong></td>
    <td><strong>validity</strong></td>
    <td><strong>Benefit</strong></td>
  	<td><strong>Operator</strong></td>
  	<td><strong>Delete</strong></td>
  	
  	</tr>
<%
JioDAOImpl jioDao=new JioDAOImpl();
 List<JioUser>ShowPlan=jioDao.showJioplan();
 
for(int i=0;i<ShowPlan.size();i++)
{%>
	<tr>
	<td>
	<%= ShowPlan.get(i).getJioId() %></td>
	<td><%=ShowPlan.get(i).getPlanName() %></td>
	<td><%=ShowPlan.get(i).getPrice() %></td>
	<td><%=ShowPlan.get(i).getValidity() %></td>
	<td><%=ShowPlan.get(i).getBenfits() %></td>
	<td><%=ShowPlan.get(i).getOperator().getOperatorname() %></td>
	<td><a href="jio.jsp?jioId=<%=ShowPlan.get(i).getJioId() %>">Delete</a></td>
	
	
</tr>
<%}%>
</table>
<%int JioId=Integer.parseInt(request.getParameter("jioId"));
jioDao.deleteJio(JioId);
%>
  </form>
 
<a href="addjio.jsp">Insert</a><br><br>
<a href="updateJio.jsp">UPDATE</a><br><br>
<a href="deleteJio.jsp">DELETE</a><br><br>


</body>
</html>