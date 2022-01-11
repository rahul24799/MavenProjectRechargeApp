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
<body>
  <h1>Show Plan</h1>
  <form align="center">
  <table style=width:100%>
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