package com.mobilerechargeapk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mobilerechargeapk.model.AirtelUser;
import com.mobilerechargeapk.model.User;

public class AirtelDao {
  public boolean insertAirtelnet(AirtelUser airtel) throws SQLException {
	  boolean flag=false;
	  ConnectionClass conclass=new ConnectionClass();
	  Connection con=conclass.getConnection();
	  String subQuery="select * from operator_details where operator_name=?";
	  PreparedStatement pst=con.prepareStatement(subQuery);
	  pst.setString(1,airtel.getOperator().getOperatorname());
      ResultSet rs=pst.executeQuery();
      int opId=0;
	   if( rs.next()){
	    opId=rs.getInt(1);
	   }
	   String insertQue="insert into jio(plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
	  try {
		PreparedStatement pstmt=con.prepareStatement(insertQue);
		pstmt.setString(1,airtel.getPlanName() );
		pstmt.setDouble(2, airtel.getPrice());
		pstmt.setString(3,airtel.getValidity());
		pstmt.setString(4,airtel.getBenfits());
		pstmt.setObject(5,opId);
		pstmt.execute();
       flag=true;   

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return flag;
  }
  public boolean updateAirtel(AirtelUser airtel) {
	  boolean flag=false;
	  ConnectionClass conclass=new ConnectionClass();
	  Connection con=conclass.getConnection();
	  String updateQuery="update table Airtel_plans set price=?,validity=?,benefits=? where plan_name=?";
      PreparedStatement pstmt=null;
      try {
		pstmt=con.prepareStatement(updateQuery);
		pstmt.setString(1, airtel.getPlanName());
		pstmt.setDouble(2,airtel.getPrice());
		pstmt.setString(3, airtel.getValidity());
		pstmt.setString(4,airtel.getBenfits());
		pstmt.executeUpdate();
		System.out.println("updated succesfully");
		
	} catch (SQLException e) {
		System.out.println("updated not properly");
		e.printStackTrace();
	}
	return false;
	}
  
  public boolean deleteAirtel(AirtelUser airtel) {
	  boolean flag=false;
	  ConnectionClass conclass=new ConnectionClass();
	  Connection con=conclass.getConnection();
	  String deleteQuerey="delete table Airtel_plans where plan_name=?";
	  PreparedStatement pstmt=null;
	  try {
		pstmt=con.prepareStatement(deleteQuerey);
		pstmt.setString(1,airtel.getPlanName());
		pstmt.executeUpdate();
		System.out.println("deleted successfully");
	} catch (SQLException e) {
		System.out.println("deleted not properly");
	}
	return false;
	  
  }
}
