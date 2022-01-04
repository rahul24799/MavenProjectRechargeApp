<%@page import="com.mobilerechargeapp.model.HistoryDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.HistorydetailsDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> </title>
</head>
<body>
  <table >
    <tr>
    <td><class="text-center">UserId</td>
    <td><class="text-center">Mobile Number</td>
    <td><class="text-center">Operator id</td>
    <td><class="text-center">plan Id</td>
    <td><class="text-center">Date</td>
  	<td><class="text-center">Payment</td>
  	</tr>
<%
HistorydetailsDAOImpl historyDao= new HistorydetailsDAOImpl();
 =historyDao.insertDetails();
 
for(int i=0;i<insertDetails.size();i++)
{
	HistoryDetails historyDetails=insertDetails

	int findjioId=jioDao.findjioId(jioUser.getPlanName(),jioUser.getPrice());
%>
<tr>
<td><%= findjioId %></td>
<td><%= jioUser.getPlanName() %></td>
<td><%= jioUser.getPrice() %></td>
<td><%= jioUser.getValidity() %></td>
<td><%= jioUser.getBenfits() %></td>
<td><%= jioUser.getOperator().getOperatorname() %></td>
</tr>
<%}%>
</table>

  
</body>
</html>