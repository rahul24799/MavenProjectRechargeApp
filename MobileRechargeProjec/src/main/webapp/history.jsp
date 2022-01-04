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
<%
HistoryDetails historyD=new HistoryDetails();
HistorydetailsDAOImpl historyDao=new HistorydetailsDAOImpl ();
boolean historyD=historyDao.insertDetails(historyDetails);

%>
  <ol>
  <li>
  
  
  </ol>



  
</body>
</html>