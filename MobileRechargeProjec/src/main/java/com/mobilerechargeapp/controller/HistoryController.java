package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilerechargeapp.daoimpl.HistorydetailsDAOImpl;
import com.mobilerechargeapp.model.HistoryDetails;

/**
 * Servlet implementation class HistorydetailsController
 */
@WebServlet("/HistorydetailsController")
public class HistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		SimpleDateFormat sdf=new SimpleDateFormat();
		int userId=Integer.parseInt(request.getParameter("userId"));
		long mobileNumber=Long.parseLong(request.getParameter("mobilenumber"));
		int operatorId=Integer.parseInt(request.getParameter("operatorId"));
		int planId=Integer.parseInt(request.getParameter("planId"));
		Date  rechargeDate1 = new Date();
        Date rechargeDate=null;
		try {
			rechargeDate = sdf.parse(request.getParameter("Date"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double amount=Double.parseDouble(request.getParameter("wallet"));
		
	
		HistoryDetails historyDetails = new HistoryDetails(userId, operatorId, mobileNumber, planId,
				rechargeDate, amount);
		HistorydetailsDAOImpl historyDao = new HistorydetailsDAOImpl();
		boolean b = historyDao.insertDetails(historyDetails);
	
		if(b == true) {
			response.sendRedirect("vodafone.jsp");
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
