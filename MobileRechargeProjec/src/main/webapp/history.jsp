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
<title></title>
</head>
<body>
	
	<h1>History Details</h1>
	<%
	User user = (User) session.getAttribute("CurrentUser");
	
	HistorydetailsDAOImpl historyDao = new HistorydetailsDAOImpl();
	UserDAOImpl userDao = new UserDAOImpl();
	ResultSet rs = userDao.history(user);
	
	%>
	<h3><%= user%>User</h3>
	<table>
		<tr>
			<th>userId</th>
			<th>operatorId</th>
			<th>mobileNumber</th>
			<th>planId</th>
			<th>RechargeDate</th>
			<th>payment</th>
		</tr>
		<%
		while(rs.next()) {
		%>
		<tr>
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getInt(3)%></td>
			<td><%=rs.getDate(4)%></td>
			<td><%=rs.getDouble(5)%></td>
		</tr>
		<%
		}
		%>
	</table>





</body>
</html>