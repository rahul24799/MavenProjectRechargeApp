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
table {
    background: cornflowerblue;
    padding: 10px;
}
table, tr, td {
    text-align: left;
    height: 40px;
    padding: 3px 10px;
    margin-top:10px;
}
tr:nth-child(even) {
    background-color: #3f56fb;
    color: white;
    padding: 10px;5
    margin-left: 19px; 
}
td.links {
    text-align: center;
}

td.links a {
    color:maroon;
    text-decoration: none;
    font-weight: bold;
    font-family: sans-serif;
    font-size: 15px;
   /*  background: aliceblue; */
    padding: 9px;
}
.header a {
    padding: 12px 28px;
    text-decoration: none;
    font-weight: bold;
    color: white;
}

.header {
    background: linear-gradient(to right, #3f56fb, #fc466b);
    padding: 0px;
    display: flex;
    justify-content: space-around;
}
.header a:hover {
    background: white;
    color: black;
}




}</style>
</head>
<body>
<h1>showPlan</h1>
 
  <table style=width:100% >
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
<td><a href="DeletevodafoneController?vodfoneId=<%= findvodafoneId %>">delete</a></td>
<td><a href="UpdateVodafone.jsp">UPDATE</a></td>
</tr>
<%}%>
</table>


<a href="addVodafone.jsp">INSERT</a>


</body>
</html>