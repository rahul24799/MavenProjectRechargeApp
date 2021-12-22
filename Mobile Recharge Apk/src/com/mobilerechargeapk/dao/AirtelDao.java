package com.mobilerechargeapk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mobilerechargeapk.model.AirtelUser;
import com.mobilerechargeapk.model.JioUser;
import com.mobilerechargeapk.model.Operator;
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
	   String insertQue="insert into Airtel_plans (plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
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
  int airtelplanId = 0;
  public boolean updateAirtel(String planname, Double price, String validity, String benefits,int airtelplanId) {
	  
	  boolean flag=false;
	 
	  ConnectionClass conclass=new ConnectionClass();
	  Connection con=conclass.getConnection();
	  String updateQuery="update  Airtel_plans set plan_name=?,price=?,validity=?,benefits=? where airtelplan_id=?";
      PreparedStatement pstmt=null;
      try {
		pstmt=con.prepareStatement(updateQuery);
		
		pstmt.setString(1, planname);
		pstmt.setDouble(2,price);
		pstmt.setString(3,validity);
		pstmt.setString(4,benefits);
		pstmt.setInt(5,airtelplanId);
		
		pstmt.executeUpdate();
		
		
	} 
      catch (SQLException e) {
		System.out.println("updated not properly");
		e.printStackTrace();
	}
	return flag;
	}

  public boolean deleteAirtel(int airtelplanId) {
	  boolean flag=false;
	  ConnectionClass conclass=new ConnectionClass();
	  Connection con=conclass.getConnection();
	  String deleteQuerey="delete from Airtel_plans where airtelplan_id=?";
	  PreparedStatement pstmt=null;
	  try {
		pstmt=con.prepareStatement(deleteQuerey);
		pstmt.setInt(1,airtelplanId);
	    flag=pstmt.executeUpdate()>0;
	
	} catch (SQLException e) {
		System.out.println("deleted not properly");
	}
	return flag;
	  
  }
  public List<AirtelUser>showAirtelplan()
	{
		AirtelUser airtel=null;
		List<AirtelUser> AirtelList=new ArrayList<AirtelUser>();
		String showQuery="select * from jio_plans";
		ConnectionClass conclass=new ConnectionClass();
		Connection con=conclass.getConnection();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(showQuery);
			OperatorDao operatordao=new OperatorDao();
			while(rs.next()) {
				Operator operator=operatordao.findOperator(rs.getString(2));
				 airtel=new AirtelUser(rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),operator);
				 AirtelList.add(airtel);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return AirtelList;
		}
  
  public static int  findairtelId(String planName,Double price) {
		String query="select airtelplan_id from Airtel_plans where plan_name=? and price=?"; 
		ConnectionClass conclass=new ConnectionClass();
		Connection con = conclass.getConnection();
		PreparedStatement pstmt;
		int airtelplanId=0;
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, planName);
			pstmt.setDouble(2, price);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				airtelplanId=rs.getInt(1);
			}
			}
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return airtelplanId;
		
	}

}
