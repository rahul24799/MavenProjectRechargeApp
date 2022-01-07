package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.daoimpl.OperatorDAOImpl;
import com.mobilerechargeapp.exception.PriceInvalid;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.model.Operator;
import com.mobilerechargeapp.util.ConnectionClass;

/**
 * Servlet implementation class AddJioController
 */
@WebServlet("/AddJioController")
public class AddJioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddJioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
		String planname=request.getParameter("planname");
		Double  price=Double.parseDouble(request.getParameter("price"));
		String validity=request.getParameter("validity");
		String benefits=request.getParameter("benefits");
		String operatorName=request.getParameter("operatorName");
		OperatorDAOImpl operatorDao=new OperatorDAOImpl();
		Operator operator=operatorDao.findOperator(operatorName);
		Connection con=ConnectionClass.getConnection();
		if(price>0) {
			JioUser jioUser=new JioUser(planname,price,validity,benefits,operator);
			JioDAOImpl jioDao=new JioDAOImpl();
	        boolean b = jioDao.insertJionet(jioUser);
			
			if(b == true) {
				response.sendRedirect("jio.jsp");
			}
		}
		else
		{
			throw new PriceInvalid();
		}}
		catch(PriceInvalid e)
		{
			response.sendRedirect("PriceInvalid.jsp?message="+e.getMessage());
		}
			
		

	    
//		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
