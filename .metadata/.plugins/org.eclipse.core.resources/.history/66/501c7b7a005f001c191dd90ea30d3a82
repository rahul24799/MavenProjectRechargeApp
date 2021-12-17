package com.mobilerechargeapk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mobilerechargeapk.model.User;

public class UserDao {
	  
		public void insertUser(User user) throws SQLException {
			ConnectionClass conclass=new ConnectionClass();
			Connection con=conclass.getConnection();
			String subQue="select * from operator_table where operator_name=?";	
	    PreparedStatement pst=con.prepareStatement(subQue);
	   // System.out.println(user.getOperator().getOperatorname());
	    pst.setString(1, user.getOperator().getOperatorname());
	    ResultSet rs=pst.executeQuery();
	    int opId=0;
	   if( rs.next()){
	    opId=rs.getInt(1);
	   }	
	    System.out.println(opId);
			String insertQuery="insert into user_table (user_name,Email_id,phone_number,password,wallet,operator_Id) values(?,?,?,?,?,?)";

		PreparedStatement pstmt=con.prepareStatement(insertQuery);


			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getEmailid());
			pstmt.setLong(3, user.getPhonenumber());
			pstmt.setString(4, user.getPassword());
			pstmt.setDouble(5,user.getWallet());
			pstmt.setInt(6, opId);
		
			pstmt.executeUpdate();
			System.out.println("value insterted successfully");
		
		
	}
		public User validiateUser(String Emailid,String password)
		{
			String Query="select * from user_table where Email_Id='"+Emailid+"' and password='"+password+"'";
			Connection con=ConnectionClass.getConnection();
			User user=null;
			try {
				Statement stmt=con.createStatement();
				ResultSet rst=stmt.executeQuery(Query);
				if(rst.next()) {
					user=new User(rst.getString(2),Emailid,password);
				}
				else {
					System.out.println("invalid user name and password");
				}
         	} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("invalid Statement ");
			}
			return user;
			
		}
	
	}


