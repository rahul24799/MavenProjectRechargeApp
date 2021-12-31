package com.MobileRecharge.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilerechargeapk.dao.ConnectionClass;
import com.mobilerechargeapk.dao.OperatorDao;
import com.mobilerechargeapk.dao.UserDaoImpl;
import com.mobilerechargeapk.model.Operator;
import com.mobilerechargeapk.model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		long phonenumber=Long.parseLong(request.getParameter("phonenumber"));
		String password=request.getParameter("password");
		
		Double wallet=Double.parseDouble(request.getParameter("wallet"));
		
		Connection con=ConnectionClass.getConnection();
		User user=new User();
		UserDaoImpl userDao=new UserDaoImpl();
		PrintWriter pw=response.getWriter();
		pw.write(username);
		pw.write(email);
		   
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
