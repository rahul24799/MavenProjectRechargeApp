
<%@page import="com.mobilerechargeapp.model.BsnlUser"%>
<%@page import="com.mobilerechargeapp.daoimpl.BsnlDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.VodafoneUser"%>
<%@page import="com.mobilerechargeapp.daoimpl.VodafoneDAOImpl"%>
<%@page import="com.mobilerechargeapp.model.AirtelUser"%>
<%@page import="com.mobilerechargeapp.daoimpl.AirtelDAOImpl"%>
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
<title>selectyour network</title>
<style>


</style>
</head>
<body>
<h1>Select Your NetWork</h1>

<nav>
<a href="planjiouser.jsp"><h1>Jio</h1></a><br>
<a href="planairteluser.jsp"><h1>Airtel</h1></a><br>
<a href="planvodafoneUser.jsp"><h1>vodafone</h1></a><br>
<a href="planbsnluser.jsp"><h1>Bsnl</h1></a><br>
<a href="wallet.jsp"><h1>wallet</h1></a>
</nav>
<%User user =(User)session.getAttribute("CurrentUser");
long validity=0;


	HistorydetailsDAOImpl hisDao=new HistorydetailsDAOImpl();
	List<HistoryDetails> rechargeHistory=hisDao.findUserHistory(user);
	if(rechargeHistory.size()>0)
	{
	HistoryDetails history=rechargeHistory.get(0);
	OperatorDAOImpl operDao=new OperatorDAOImpl();
	Operator operator=operDao.findOperator(history.getOperatorId());
	Date sysDate=new Date();
	long timediff=sysDate.getTime()-history.getRechargeDate().getTime();
	long days=timediff/(1000*60*60*24)%365;
	if(operator!=null)
	{
	JioUser planJio=null;
	AirtelUser	planAirtel=null;
	VodafoneUser planVodafone=null;
	BsnlUser planBsnl=null;
	if(operator.getOperatorname().equals("jio"))
	{
		
		JioDAOImpl jioDao=new JioDAOImpl();
		planJio=jioDao.findPlan(history.getPlanId());
		 System.out.println(planJio);
		validity=Integer.valueOf(planJio.getValidity().split(" ")[0])-days;
	    System.out.println ("Days: "+validity );
		
		
	}
	else if(operator.getOperatorname().equals("Airtel")){
		AirtelDAOImpl airtelDao=new AirtelDAOImpl();
	planAirtel=airtelDao.findPlan(history.getPlanId());
	validity=Integer.valueOf(planAirtel.getValidity().split(" ")[0])-days;
    System.out.println ("Days: "+validity );
	}
	else if(operator.getOperatorname().equals("Vodafone")){
		VodafoneDAOImpl vodafoneDao=new VodafoneDAOImpl();
		planVodafone=vodafoneDao.findPlan(history.getPlanId());
		validity=Integer.valueOf(planVodafone.getValidity().split(" ")[0])-days;
	    System.out.println ("Days: "+validity );
	}
	else if(operator.getOperatorname().equals("BSNL")) {
		BsnlDAOImpl bsnlDao=new BsnlDAOImpl();
		planBsnl=bsnlDao.findPlan(history.getPlanId());
		validity=Integer.valueOf(planBsnl.getValidity().split(" ")[0])-days;
	    System.out.println ("Days: "+validity );
		
	}
	
	
	
	/* if(plan!=null)
	{
	validity=Integer.valueOf(plan.getValidity().split(" ")[0])-days;
	    System.out.println ("Days: "+validity );
	
	}    */
	}
	}
	
	

%>
<%-- <%if(validity<=10) { %> --%>
<h1><%=  validity %> Validity Recharge Fast</h1>


<%-- <%} %> --%>
</body>
</html>