package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilerechargeapp.daoimpl.JioDAOImpl;
import com.mobilerechargeapp.model.JioUser;
import com.mobilerechargeapp.util.ConnectionClass;

/**
 * Servlet implementation class DeleteJioController
 */
@WebServlet("/DeleteJioController")
public class DeleteJioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteJioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int jioplanId=Integer.parseInt(request.getParameter("planId"));
		
		JioDAOImpl jioDao=new JioDAOImpl();
		boolean b=jioDao.deleteJio(jioplanId);
		if(b==true) {
			response.sendRedirect("jio.jsp");
		}
		else {
			response.sendRedirect("deletejio.jsp");
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
