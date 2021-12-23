package com.mobilerechargeapk.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mobilerechargeapk.model.HistoryDetails;

public class HistorydetailsDao {
       public boolean insertDetails(HistoryDetails historyDetails) {
    	   boolean flag=false;
   		ConnectionClass conclass = new ConnectionClass();
   		Connection con = conclass.getConnection();
   		
   		String insertQuery="insert into  history_details (user_id,mobile_number,operator_id,plan_id,Recharge_date)values(?,?,?,?,?)";
   		try {
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1,  historyDetails.getUserId());
			pstmt.setLong(2, historyDetails.getMobileNumber());
			pstmt.setInt(3,historyDetails.getOperatorId());
			pstmt.setInt(4,historyDetails.getPlanId());
			//pstmt.setDate(4,(Date) historyDetails.getRechargeDate());
	        pstmt.setDate(5,new java.sql.Date(historyDetails.getRechargeDate().getTime()));
			flag=pstmt.executeUpdate()>0;


		} catch (SQLException e) {
			System.out.println("Query will be invalid");
			e.printStackTrace();
		}
		return flag;
    	   
       }
}
