package com.mobilerechargeapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilerechargeapp.daoimpl.AdminDAOImpl;
import com.mobilerechargeapp.daoimpl.UserDAOImpl;
import com.mobilerechargeapp.exception.ErrorFound;
import com.mobilerechargeapp.model.Admin;
import com.mobilerechargeapp.model.User;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String emailId=request.getParameter("email");
		String password=request.getParameter("password");
		PrintWriter pw=response.getWriter();
		pw.write("EmailId"+emailId);
		pw.write("PASSWORD"+password);
		boolean admin=false;
		User user=null;
		AdminDAOImpl adminDao=new AdminDAOImpl ();
		admin=adminDao.validateAdmin(emailId, password);
		UserDAOImpl userDao=new UserDAOImpl ();
	    user=userDao.validiateUser(emailId, password);
	    try {
		if(admin)
		{
			response.sendRedirect("adminhome.jsp");
		}
		else if(user!=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("CurrentUser", user);
			session.setAttribute("amount",user.getWallet());
			response.sendRedirect("Operator.jsp");
		}
		else
		{
		   throw new ErrorFound();
		}
	    }catch(ErrorFound e)
	    {
	    	HttpSession session=request.getSession();
			session.setAttribute("invalid", e.getMessage());
			response.sendRedirect("index.jsp");
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
