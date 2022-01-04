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
 {
   JioUser jioUser=ShowPlan.get(i);
    int findjioId=jioDao.findjioId(jioUser.getPlanName(),jioUser.getPrice());
 	%>
 	
<%int jioplanId=Integer.parseInt(request.getParameter("airtelDel"));

  %>

<tr>
<td><%= findjioId %></td>
<td><%= jioUser.getPlanName() %></td>
<td><%= jioUser.getPrice() %></td>
<td><%= jioUser.getValidity() %></td>
<td><%= jioUser.getBenfits() %></td>
<td><%= jioUser.getOperator().getOperatorname() %></td>
<td><%=  %>

</tr>
<%}%>
</table>
  </form>
 
<a href="addjio.jsp">Insert</a><br><br>
<a href="updateJio.jsp">UPDATE</a><br><br>
<a href="deleteJio.jsp">DELETE</a><br><br>


</body>
</html>