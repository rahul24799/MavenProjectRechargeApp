package com.mobilerechargeapk.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mobilerechargeapk.interfacedao.AdminDaoInterface;
import com.mobilerechargeapk.model.Admin;

public class AdminDaoImpl implements AdminDaoInterface {
    public boolean validateAdmin(String userName,String password)
    {
    	Connection con=ConnectionClass.getConnection();
    	String insertQuery="select * from Admin where Admin_name='"+userName+"' and password='"+password+"' ";
    	boolean flag=false;
    	try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(insertQuery);
			if(rs.next()) {
				//System.out.println(rs.getString(1));
				flag=true;
			}
			
		} catch (SQLException e) {
		System.out.println("query not excuted correctly");
			e.printStackTrace();
		}
    	
		return flag;
    	
    	
    }
}
