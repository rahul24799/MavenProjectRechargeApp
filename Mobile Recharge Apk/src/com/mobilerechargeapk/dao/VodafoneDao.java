package com.mobilerechargeapk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mobilerechargeapk.model.User;
import com.mobilerechargeapk.model.VodafoneUser;

public class VodafoneDao {
  public void vodafoneNetwork(VodafoneUser vodafone) throws SQLException {
	  ConnectionClass conclass=new ConnectionClass();
	  Connection con=conclass.getConnection();
	  User user=new User();
	  String subQueries="select * from operator_details where operator_name=?";
	  PreparedStatement pst=con.prepareStatement(subQueries);
	  pst.setString(1, user.getOperator().getOperatorname());
	  ResultSet rs=pst.executeQuery();
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
	} catch (SQLException e) {
		e.printStackTrace();
	}
  }
}
