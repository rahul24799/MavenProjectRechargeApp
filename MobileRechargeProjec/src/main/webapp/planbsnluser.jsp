<%@page import="com.mobilerechargeapp.model.BsnlUser"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.BsnlDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table,tr,td{
border:1px solid black;
border-collapse:collapse;

}</style>

</head>
<body>
<form align="center">
  <table >
    <tr>
   
    <td><strong>PlanName</strong></td>
    <td><strong>Price</strong></td>
    <td><strong>validity</strong></td>
    <td><strong>Benefit</strong></td>
  	<td><strong>Operator</strong></td>
<%
BsnlDAOImpl bsnlDao=new BsnlDAOImpl();
List<BsnlUser> ShowPlan=bsnlDao.showBsnlplan();
 
for(int i=0;i<ShowPlan.size();i++){
	BsnlUser bsnlUser=ShowPlan.get(i);
	String planName=bsnlUser.getPlanName();
	%>
	<tr>
<td><%= bsnlUser.getPlanName() %></td>
<td><%= bsnlUser.getPrice() %></td>
<td><%= bsnlUser.getValidity() %></td>
<td><%= bsnlUser.getBenfits() %></td>
<td><%= bsnlUser.getOperator().getOperatorname() %></td>
<td><a href="recharge.jsp?planName=<%=bsnlUser.getPlanName() %>&price=<%=  bsnlUser.getPrice() %>
&operator=<%= bsnlUser.getOperator().getOperatorname() %>" >Recharge</a></td>
</tr>
<%}%>
  	
  	</table>
  	</form>
</body>
</html>