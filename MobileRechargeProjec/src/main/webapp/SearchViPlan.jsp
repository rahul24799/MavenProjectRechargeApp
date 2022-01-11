<%@page import="com.mobilerechargeapp.model.VodafoneUser"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table style="width: 100%">
		<tr>

			<td><strong>PlanName</strong></td>
			<td><strong>Price</strong></td>
			<td><strong>validity</strong></td>
			<td><strong>Benefit</strong></td>
			<td><strong>Operator</strong></td>


		</tr>
		<%
          
		List<VodafoneUser> vodafoneUser=(List<VodafoneUser>)session.getAttribute("list");	
			for(int i=0;i<vodafoneUser.size();i++)
			{
			VodafoneUser vodafoneUser1=vodafoneUser.get(i);
	
	
           %>

		<tr>
			<td><%= vodafoneUser1.getPlanName() %></td>
			<td><%= vodafoneUser1.getPrice() %></td>
			<td><%=vodafoneUser1.getValidity() %></td>
			<td><%= vodafoneUser1.getBenfits() %></td>
			<td><%= vodafoneUser1.getOperator().getOperatorname() %></td>
			<td class="links"><a
				href="recharge.jsp?planName=<%=vodafoneUser1.getPlanName() %>&price=<%= vodafoneUser1.getPrice() %>
&operator=<%= vodafoneUser1.getOperator().getOperatorname() %>"><button>Recharge</a>
				</button></td>
		</tr>

		<%}%>
	</table>
</body>
</html>