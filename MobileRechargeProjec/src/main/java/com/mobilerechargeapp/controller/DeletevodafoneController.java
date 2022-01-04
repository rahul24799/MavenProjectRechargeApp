package com.mobilerechargeapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilerechargeapp.daoimpl.VodafoneDAOImpl;

/**
 * Servlet implementation class DeletevodafoneController
 */
@WebServlet("/DeletevodafoneController")
public class DeletevodafoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletevodafoneController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int vodafoneplanId=Integer.parseInt(request.getParameter("ViplanId"));
		VodafoneDAOImpl vodafoneDao=new VodafoneDAOImpl();
		boolean b=vodafoneDao.deleteVodafone(vodafoneplanId);
		if(b==true) {
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
