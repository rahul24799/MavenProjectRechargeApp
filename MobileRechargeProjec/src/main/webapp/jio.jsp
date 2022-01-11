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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>
table, tr, td {
    text-align: left;
    height: 40px;
    padding: 3px 10px;
    margin-top:10px;
}
tr:hover {background-color:threedlightshadow;}
tr:nth-child(even) {background-color: #f2f2f2;}
<style>


</style>


</head>
<body>
<h1><strong>JIO NETWORK</strong></h1>
  
  <table style="width:100%" >
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
 	


  

<tr>
<td><%= findjioId %></td>
<td><%= jioUser.getPlanName() %></td>
<td><%= jioUser.getPrice() %></td>
<td><%= jioUser.getValidity() %></td>
<td><%= jioUser.getBenfits() %></td>
<td><%= jioUser.getOperator().getOperatorname() %></td>
<td><a href="deleteplan?jioId=<%= findjioId %>">delete</a></td>
<td><a href="updateJio.jsp">Edit</a>

</tr>
<%}%>
</table>
  




</body>
</html>