package com.mobilerechargeapp.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mobilerechargeapp.Dao.HistorydetailsDao;
import com.mobilerechargeapp.model.HistoryDetails;
import com.mobilerechargeapp.model.User;
import com.mobilerechargeapp.util.ConnectionClass;

public class HistorydetailsDAOImpl implements HistorydetailsDao {
       public boolean insertDetails(HistoryDetails historyDetails) {
    	   boolean flag=false;
   		ConnectionClass conclass = new ConnectionClass();
   		Connection con = conclass.getConnection();
   		
   		String insertQuery="insert into  history_details (user_id,mobile_number,operator_id,plan_id,Recharge_date,Payment)values(?,?,?,?,?,?)";
   		try {
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1,  historyDetails.getUserId());
			pstmt.setLong(2, historyDetails.getMobileNumber());
			pstmt.setInt(3,historyDetails.getOperatorId());
			pstmt.setInt(4,historyDetails.getPlanId());
			//pstmt.setDate(4,(Date) historyDetails.getRechargeDate());
	        pstmt.setDate(5,new java.sql.Date(historyDetails.getRechargeDate().getTime()));
	        pstmt.setDouble(6,historyDetails.getWallet());
			flag=pstmt.executeUpdate()>0;


		} catch (SQLException e) {
			System.out.println("Query will be invalid");
			e.printStackTrace();
		}
		return flag;
	
           }
       
   	public HistoryDetails rechargeRemainder(User user) {
   		ConnectionClass conclass = new ConnectionClass();
   		Connection con = conclass.getConnection();
   		UserDAOImpl userDao=new UserDAOImpl();
   		HistoryDetails hisDetails=null;
   		String Query="select * from  history_details where mobile_number=? and user_id=?";
   		int userId=userDao.findUserId(user);
   		try {
			PreparedStatement pstmt=con.prepareStatement(Query);
			pstmt.setLong(1, user.getPhonenumber());
			pstmt.setInt(2,userId );
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				java.util.Date rechargeDate = null;
				hisDetails=new HistoryDetails(userId, userId, userId, userId, rechargeDate, null);
			}
//			pstmt.setDate(3, rechargeDate);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		
		return hisDetails;
//		Date today=new Date();
   		
   	}
   	
//   	public String findValidity(HistoryDetails historyDetails) {
//   		String Query="Select * from history_details where "
//		return null;
//   		
//   	}
     }

