<%@page import="com.mobilerechargeapp.model.VodafoneUser"%>
<%@page import="com.mobilerechargeapp.daoimpl.VodafoneDAOImpl"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VodafoneNetwork</title>
<style type="text/css">
table,tr,td{
border:1px solid black;
border-collapse:collapse;

}</style>
</head>
<body>
<h1>showPlan</h1>
  <form align="center">
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
VodafoneDAOImpl vodafoneDao=new VodafoneDAOImpl();
 List<VodafoneUser>ShowViplan=vodafoneDao.showViplan();
 
for(int i=0;i<ShowViplan.size();i++)
{
	VodafoneUser vodafoneUser=ShowViplan.get(i);

	 int findvodafoneId= vodafoneDao.findvodafoneId(vodafoneUser.getPlanName(),vodafoneUser.getPrice());
%>
<tr>
<td><%=findvodafoneId%></td>
<td><%= vodafoneUser.getPlanName() %></td>
<td><%= vodafoneUser.getPrice() %></td>
<td><%= vodafoneUser.getValidity() %></td>
<td><%= vodafoneUser.getBenfits() %></td>
<td><%= vodafoneUser.getOperator().getOperatorname() %></td>
</tr>
<%}%>
</table>

</form>
<a href="addVodafone.jsp">INSERT</a>
<a href="UpdateVodafone.jsp">UPDATE</a>
<a href="DeleteVodafone.jsp">DELETE</a>
</body>
</html>