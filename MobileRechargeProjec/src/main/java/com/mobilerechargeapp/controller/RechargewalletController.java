package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.daoimpl.UserDAOImpl;
import com.mobilerechargeapp.model.User;
import com.mobilerechargeapp.util.ConnectionClass;

/**
 * Servlet implementation class RechargewalletController
 */
@WebServlet("/RechargewalletController")
public class RechargewalletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargewalletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		long cardNo=Long.parseLong(request.getParameter("CardNo"));
//		int cvv = Integer.parseInt(request.getParameter("cvv"));
		String EmailId=request.getParameter("emailid");
		Double amount = Double.parseDouble(request.getParameter("amount"));
//		Connection con=ConnectionClass.getConnection();
		UserDAOImpl userDao=new UserDAOImpl();
		HttpSession session=request.getSession();
        User user=(User)session.getAttribute("CurrentUser");
        user.setWallet(amount);
		int i=userDao.updateuserWallet(user);
		if(user!=null) {
			response.sendRedirect("vodafone.jsp");
		}
		else {
			response.sendRedirect("wallet.jsp");
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
