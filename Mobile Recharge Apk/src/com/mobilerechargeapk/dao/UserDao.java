package com.mobilerechargeapk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mobilerechargeapk.model.User;

public class UserDao {
	  
		public void insertUser(User user) {
		String insertQuery="insert into user_table (user_name,Email_id,phone_number,password,wallet,operator_Id) values(?,?,?,?,?,?)";
		ConnectionClass conclass=new ConnectionClass();
		Connection con=conclass.getConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(insertQuery);
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getEmailid());
			pstmt.setLong(3, user.getPhonenumber());
			pstmt.setString(4, user.getPassword());
			pstmt.setDouble(5,user.getWallet());
			pstmt.setObject(6, user.getOperator().getOperatorId());
			pstmt.executeUpdate();
			System.out.println("value insterted successfully");
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("value not setted in the query");
		}
		
	}
		public User validiateUser(String Emailid,String password)
		{
			String Query="select * from user_table where Email_Id='"+Emailid+"'";
			Connection con=ConnectionClass.getConnection();
			User user=null;
			try {
				Statement stmt=con.createStatement();
				ResultSet rst=stmt.executeQuery(Query);
				if(rst.next()) {
					user=new User(rst.getString(2),Emailid);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.out.println("invalid Statement ");
			}
			return user;
			
		}
	
	}


