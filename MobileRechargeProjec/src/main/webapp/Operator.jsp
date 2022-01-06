
<%@page import="java.text.ParseException"%>
<%@page import="java.time.Duration"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>

<%@page import="java.util.Date"%>
<%@page import="com.mobilerechargeapp.model.JioUser"%>
<%@page import="com.mobilerechargeapp.model.Operator"%>
<%@page import="com.mobilerechargeapp.daoimpl.OperatorDAOImpl"%>
<%@page import="com.mobilerechargeapp.daoimpl.HistorydetailsDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.HistoryDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.mobilerechargeapp.daoimpl.JioDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Select Your NetWork</h1>


<a href="planjiouser.jsp"><h1>Jio</h1></a><br>
<a href="planairteluser.jsp"><h1>Airtel</h1></a><br>
<a href="planvodafoneUser.jsp"><h1>vodafone</h1></a><br>
<a href="planbsnluser.jsp"><h1>Bsnl</h1></a><br>
<a href="wallet.jsp"><h1>wallet</h1></a>

<%User user =(User)session.getAttribute("CurrentUser");
long daysBetween=0;
if(user.getOperator().equals("jio"))
{
	HistorydetailsDAOImpl hisDao=new HistorydetailsDAOImpl();
	List<HistoryDetails> rechargeHistory=hisDao.findUserHistory(user);
	HistoryDetails history=rechargeHistory.get(0);
	OperatorDAOImpl operDao=new OperatorDAOImpl();
	Operator operator=operDao.findOperator(history.getOperatorId());
	JioUser plan=null;
	if(operator.getOperatorname().equals("jio"))
	{
		System.out.println ("Days: " + daysBetween);
		
		JioDAOImpl jioDao=new JioDAOImpl();
		plan=jioDao.findPlan(history.getPlanId());
		
	}
	
	Date sysDate=new Date();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	

	    LocalDateTime date1 = LocalDateTime.parse(history.getRechargeDate().toString(), dtf);
	    LocalDateTime date2 = LocalDateTime.parse(sysDate.toString(), dtf);
	    daysBetween = Duration.between(date1, date2).toDays();
	    System.out.println ("Days: " + daysBetween);

	
	//int days=new Date(sysDate.getTime()-history.getRechargeDate().getTime());
	//int RemainingValidity=(history.getRechargeDate()-plan.getValidity();
	
	/*
	JioDAOImpl jioDao=new JioDAOImpl();
	jioDao.findJiovalidity(user);
	*/
	
}
%>
<h1><%= daysBetween %> Validity</h1>
</body>
</html>