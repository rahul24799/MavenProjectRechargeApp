<%@page import="java.sql.ResultSet"%>
<%@page import="com.mobilerechargeapp.daoimpl.UserDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.User"%>
<%@page import="com.mobilerechargeapp.model.HistoryDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.HistorydetailsDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserHistoryDetails</title>
<style type="text/css">

table {
	/*  background: cornflowerblue; */
	background: inactiveborder;
	padding: 10px;
}

table, tr, td {
	text-align: left;
	height: 40px;
	padding: 3px 10px;
	margin-top: 10px;
	font-size: medium;
}
</style>
</head>
<body>

	<h1>History Details</h1>
	<%
	//User user = (User) session.getAttribute("CurrentUser");
	 HistoryDetails history=(HistoryDetails)session.getAttribute("history");
	 
	
	HistorydetailsDAOImpl historyDao = new HistorydetailsDAOImpl();
	UserDAOImpl userDao = new UserDAOImpl();
	ResultSet rs = userDao.history(history.getUserId());
	
	
	%>
	<%=history.getUserId()%>

	<table>
		<tr>
			<td>userName</td>
			<td>operatorName</td>
			<td>planId</td>
			<td>RechargeDate</td>
			<td>payment</td>
			<td>mobileNumber</td>
		</tr>
		<%
		while(rs.next()) {
		%>
		<tr>
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getInt(3) %></td>
			<td><%=rs.getDate(4)%></td>
			<td><%=rs.getDouble(5)%></td>
			<td><%=rs.getLong(6) %></td>
		</tr>
		<%
		}
		%>
	</table>





</body>
</html>