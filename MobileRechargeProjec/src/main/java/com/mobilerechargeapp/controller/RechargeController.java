package com.mobilerechargeapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.daoimpl.AirtelDAOImpl;
import com.mobilerechargeapp.daoimpl.BsnlDAOImpl;
import com.mobilerechargeapp.daoimpl.HistorydetailsDAOImpl;
import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.daoimpl.OperatorDAOImpl;
import com.mobilerechargeapp.daoimpl.UserDAOImpl;
import com.mobilerechargeapp.daoimpl.VodafoneDAOImpl;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.model.User;

/**
 * Servlet implementation class RechargeController
 */
@WebServlet("/RechargeController")
public class RechargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		long mobilenumber=Long.parseLong(request.getParameter("mobileNumber"));
		double price=Double.parseDouble(request.getParameter("price"));
		 UserDAOImpl userDao=new UserDAOImpl();
	     JioDAOImpl jioDao=new  JioDAOImpl();
	 	int planId = 0;
	 	HttpSession session=request.getSession();
        User user=(User)session.getAttribute("CurrentUser");
		int userId = userDao.findUserId(user);
		int operatorId = user.getOperator().getOperatorId();
		String operatorName=user.getOperator().getOperatorname();
		 AirtelDAOImpl airtelDao=new  AirtelDAOImpl();
		 VodafoneDAOImpl vodafoneDao=new  VodafoneDAOImpl();
		 BsnlDAOImpl bsnlDao=new  BsnlDAOImpl();
		 String planName = null;
		 if(user.getWallet()>price) {
		Double amount = null;
		if (operatorName.equals("jio")) {
				planId = jioDao.findjioId(planName, price);
				// System.out.println(planId);
			} else if (operatorName.equals("Airtel")) {
				planId = airtelDao.findairtelId(planName, price);
			} else if (operatorName.equals("Vodafone")) {
				planId = vodafoneDao.findvodafoneId(planName, price);
			} else {
				planId =bsnlDao.findbsnlId(planName,price);
			}
		 UserDAOImpl userdao=new UserDAOImpl();
		 int i=userdao.rechargeWalletupdate(price, user);
		 if(i>0)
		 {
			 System.out.println("amount is deducted");
		 }
		 }
		 else
		 {
			 System.out.println("insufficient balance");
		 }
		if(operatorName!=null){
		response.sendRedirect("jio.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
