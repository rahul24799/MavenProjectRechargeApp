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
	
		
	
	

}