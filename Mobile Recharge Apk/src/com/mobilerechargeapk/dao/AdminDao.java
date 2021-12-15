package com.mobilerechargeapk.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mobilerechargeapk.model.Admin;

public class AdminDao {
    public boolean validateAdmin(String userName,String password)
    {
    	Connection con=ConnectionClass.getConnection();
    	String insertQuery="select * from Admin_table where Admin_name='"+userName+"' and password='"+password+"' ";
    	boolean flag=false;
    	try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(insertQuery);
			if(rs.next()) {
				System.out.println("validate successfully");
				flag=true;
			}
			else {
				flag=false;
			}
			
		} catch (SQLException e) {
		System.out.println("query not excuted correctly");
			e.printStackTrace();
		}
    	
		return flag;
    	
    	
    }
}
