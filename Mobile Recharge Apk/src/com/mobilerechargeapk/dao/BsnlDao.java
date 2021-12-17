package com.mobilerechargeapk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mobilerechargeapk.model.BsnlUser;

public class BsnlDao {
	public boolean insertBsnlnetwork(BsnlUser bsnl) {
		ConnectionClass conclass=new ConnectionClass();
	    Connection con=conclass.getConnection();
	    String insertQueries="insert into bsnl_plans(plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
	    try {
			PreparedStatement pstmt=con.prepareStatement(insertQueries);
			pstmt.setString(1,bsnl.getPlanName());
			pstmt.setDouble(2, bsnl.getPrice());
			pstmt.setString(3,bsnl.getValidity());
			pstmt.setString(4, bsnl.getBenfits());
			pstmt.set
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

}
