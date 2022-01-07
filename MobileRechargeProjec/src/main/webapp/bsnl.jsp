<%@page import="com.mobilerechargeapp.model.BsnlUser"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.BsnlDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>bsnlShowPlan</title>
<style type="text/css">
table,tr,td{
border:1px solid black;
border-collapse:collapse;

}</style>
</head>
<body>
<body>
  <h1>Show Plan</h1>
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
BsnlDAOImpl bsnlDao=new BsnlDAOImpl();
List<BsnlUser> showBsnlplan=bsnlDao.showBsnlplan();
 
for(int i=0;i<showBsnlplan.size();i++)
{
	BsnlUser bsnlUser=showBsnlplan.get(i);
	int findbsnlId=bsnlDao.findbsnlId(bsnlUser.getPlanName(),bsnlUser.getPrice());
%>
<tr>
<td><%= findbsnlId %></td>
<td><%= bsnlUser.getPlanName() %></td>
<td><%= bsnlUser.getPrice() %></td>
<td><%= bsnlUser.getValidity() %></td>
<td><%= bsnlUser.getBenfits() %></td>
<td><%= bsnlUser.getOperator().getOperatorname() %></td>
<td><a href="DeletebsnlController?bsnlId=<%=findbsnlId %>">delete</a></td>
<td><a href="updatebsnl.jsp">Update</a>
<%-- <td><a href="updatebsnl.jsp?planName=<%=bsnlUser.getPlanName() %>">edit</a></td> --%>
</tr>
<%}%>
</table>
  </form>
  <a href="addbsnl.jsp">ADD NEW PLANS</a><br>

</body>
</html>