package com.mobilerechargeapk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mobilerechargeapk.model.BsnlUser;
import com.mobilerechargeapk.model.User;

public class BsnlDao {
	public boolean insertBsnlnetwork(BsnlUser bsnl) throws SQLException {
		boolean flag=false;
		ConnectionClass conclass=new ConnectionClass();
	    Connection con=conclass.getConnection();
	    String subQuery = "select * from operator_details where operator_name=?";
		PreparedStatement pst = con.prepareStatement(subQuery);
		pst.setString(1,bsnl.getOperator().getOperatorname());
		ResultSet rst = pst.executeQuery();
		int opId = 0;
		if (rst.next()) {
			opId = rst.getInt(1);
		}
		System.out.println(opId);
		
	    String insertQuery="insert into bsnl_plans(plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
	    try {
			PreparedStatement pstmt=con.prepareStatement(insertQuery);
			pstmt.setString(1,bsnl.getPlanName());
			pstmt.setDouble(2, bsnl.getPrice());
			pstmt.setString(3,bsnl.getValidity());
			pstmt.setString(4, bsnl.getBenfits());
			pstmt.setInt(5, opId);
			flag=true;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
		
	}
	public boolean updateBsnl(BsnlUser bsnl) {
		ConnectionClass conclass=new ConnectionClass();
		Connection con=conclass.getConnection();
		boolean flag=false;
		PreparedStatement pstmt=null;
		String updateQuery="update table bsnl_plans set price=?,validity=?,benefits=? where plan_name=?";

		try {
			pstmt=con.prepareStatement(updateQuery);
			pstmt.setString(1,bsnl.getPlanName());
			pstmt.setDouble(2,bsnl.getPrice());
			pstmt.setString(3,bsnl.getValidity());
			pstmt.setString(4,bsnl.getBenfits());
			pstmt.executeUpdate();
			System.out.println("updated succesfully");
		} catch (SQLException e) {
			System.out.println("updated not properly");
			e.printStackTrace();
		}
		return flag;		
	}

	public boolean deleteBsnl(BsnlUser bsnl) {
		boolean flag=false;
		ConnectionClass conclass=new ConnectionClass();
		Connection con=conclass.getConnection();
		String deleteQuery="delete from bsnl_plans where plan_name=?";
	    PreparedStatement pstmt=null;
	  
	    try {
	    	pstmt=con.prepareStatement(deleteQuery);
			pstmt.setString(1,bsnl.getPlanName() );
			pstmt.executeUpdate();
			System.out.println("deleted succesfully");
		
		} catch (SQLException e) {
			System.out.println("deleted not properly");
			e.printStackTrace();	
		}
					
		return flag;
	}
}
