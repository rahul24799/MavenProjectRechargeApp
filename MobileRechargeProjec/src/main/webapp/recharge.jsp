<%@page import="com.mobilerechargeapp.daoimpl.BsnlDAOImpl"%>
<%@page import="com.mobilerechargeapp.daoimpl.VodafoneDAOImpl"%>
<%@page import="com.mobilerechargeapp.daoimpl.AirtelDAOImpl"%>
<%@page import="java.util.Date"%>
<%@page import="com.mobilerechargeapp.daoimpl.JioDAOImpl"%>
<%@page import="com.mobilerechargeapp.daoimpl.OperatorDAOImpl"%>
<%@page import="com.mobilerechargeapp.daoimpl.UserDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.User"%>
<%@page import="com.mobilerechargeapp.model.HistoryDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RechargeyourNumber</title>
</head>
<body style="text-align:center";>
<form action="RechargeController">
<h1>RECHARGE YOUR NETWORK</h1>
<label for="MobileNumber"><strong>MOBILE NUMBER</strong></label>
<input type="number" name="mobileNumber" id="MobileNumber"><br>
<!--<br>
<label for="Price"><strong>AMOUNT</strong></label>
<input type="number" name="price" id="Price"><br>
<br>-->
<%
User user=(User)session.getAttribute("CurrentUser");
	UserDAOImpl userDao=new UserDAOImpl();
	int userId=userDao.findUserId(user);
	OperatorDAOImpl operDao=new OperatorDAOImpl();
	String operator=request.getParameter("operator");
	int operatorId=operDao.findOperatorId(operator);
	String planName=request.getParameter("planName");
	double amount=Double.parseDouble(request.getParameter("price"));
	int planId;
	 JioDAOImpl jioDao=new JioDAOImpl();
     planId=jioDao.findjioId(planName, amount);
	 AirtelDAOImpl airtelDao=new AirtelDAOImpl();
	 planId=airtelDao.findairtelId(planName, amount);
	 VodafoneDAOImpl vodafoneDao=new VodafoneDAOImpl();
	 planId=vodafoneDao.findvodafoneId(planName, amount);
	 BsnlDAOImpl bsnlDao=new BsnlDAOImpl();
	 planId=bsnlDao.findbsnlId(planName, amount);
	Date today=new Date();
HistoryDetails hDetails=new HistoryDetails(userId,operatorId,0,planId,today,amount);
session.setAttribute("history", hDetails);

%>

<input type="submit" value="Recharge">
</form>
</body>
</html>