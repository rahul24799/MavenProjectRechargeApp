package com.mobilerechargeapk.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mobilerechargeapk.model.Operator;

public class OperatorDao {
	
	public static Operator findOperator(String name)
	{
		Operator operator=null;

		Connection con=ConnectionClass.getConnection();
		try {
			Statement stmt=con.createStatement();
			String Query="select * from operator_details where operator_name='"+name+"'";
		ResultSet rs=stmt.executeQuery(Query);
		if(rs.next()) {
			 operator=new Operator(rs.getInt(1),rs.getString(2));
			 
		}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return operator;
		
	}
     public int findOperatorId()
         {   Connection con=ConnectionClass.getConnection();
	    String query="select operator_id from operator_details where operator_name";
	    int oId=0;
	    try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next())
			{
				oId=rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    
		return oId;
		
	}
     public Operator findOperator1(String operatorName) {
    	 Connection con=ConnectionClass.getConnection();
    	 String Query="select * from operator_details where operator_name='"+operatorName+"'";
    	 Operator operator=null;
    	 Statement stmt;
    	 try {
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(Query);
	    	 if(rs.next()) {
	    		 operator=new Operator(rs.getInt(1),rs.getString(2));
	    	 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	 
		return operator;
    	 
     }
	
	
	

}