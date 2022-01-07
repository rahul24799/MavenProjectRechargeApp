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
table,tr,td{
border:1px solid black;
border-collapse:collapse;


}</style>
<body>
 <form align="center" >
  <table>
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
<td><a href="recharge.jsp?planName=<%=vodafoneUser.getPlanName() %>&price=<%= vodafoneUser.getPrice() %>
&operator=<%= vodafoneUser.getOperator().getOperatorname() %>" >Recharge</a></td>

</tr>
<%}%>
</table>

  

  </form>
</body>
</html>