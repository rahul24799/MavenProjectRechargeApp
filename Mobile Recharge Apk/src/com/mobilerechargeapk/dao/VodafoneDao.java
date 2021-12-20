package com.mobilerechargeapk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mobilerechargeapk.model.User;
import com.mobilerechargeapk.model.VodafoneUser;

public class VodafoneDao {
  public boolean vodafoneNetwork(VodafoneUser vodafone) throws SQLException {
	  boolean flag = false;
	  ConnectionClass conclass=new ConnectionClass();
	  Connection con=conclass.getConnection();
	  
	  String subQueries="select * from operator_details where operator_name=?";
	  PreparedStatement psmt=con.prepareStatement(subQueries);
	  psmt.setString(1,vodafone.getOperator().getOperatorname() );
	  ResultSet rs=psmt.executeQuery();
	    int opId=0;
	   if( rs.next()){
	    opId=rs.getInt(1);
	   }

	  String insertQueries="insert into vodafone_plans(plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
	  try {
		PreparedStatement pstmt=con.prepareStatement(insertQueries);
	
		pstmt.setString(1,vodafone.getPlanName() );
		pstmt.setDouble(2, vodafone.getPrice());
		pstmt.setString(3,vodafone.getValidity());
		pstmt.setString(4,vodafone.getBenfits());
		pstmt.setInt(5,opId );
		 flag=true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return flag;
  }
  
  public boolean updateVodafone(VodafoneUser vodafone) {
	
	  ConnectionClass conclass = new ConnectionClass();
	  Connection con = conclass.getConnection();
	  String updateQuery="update table jio_plans set price=?,validity=?,benefits=? where plan_name=?";
	  boolean flag=false;
	  PreparedStatement pstmt=null;
	  try {
		pstmt=con.prepareStatement(updateQuery);
		pstmt.setString(1,vodafone.getPlanName());
		pstmt.setDouble(2,vodafone.getPrice());
		pstmt.setString(3,vodafone.getValidity());
		pstmt.setString(4,vodafone.getBenfits());
		pstmt.executeUpdate();
		System.out.println("updated succesfully");
	} catch (SQLException e) {
	   System.out.println("updated not properly");
		e.printStackTrace();
	}
	  
	return flag;
	  
  }
  public boolean deleteVodafone(VodafoneUser vodafone) {
	 
	  ConnectionClass conclass=new ConnectionClass();
	  Connection con=conclass.getConnection();
	  String deleteQuery="delete table vodafone_plans where plan_name=?";
	  boolean flag=false;  
	  PreparedStatement pstmt=null;
	  try {
		pstmt=con.prepareStatement(deleteQuery);
		pstmt.setString(1,vodafone.getPlanName());
		pstmt.executeUpdate();
		System.out.println("deleted vodafone plans succesfully");
	} catch (SQLException e) {
		System.out.println("deleted not properly");
		e.printStackTrace();
	}
	  
	return flag;
	  
  }
}
