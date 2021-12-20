package com.mobilerechargeapk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mobilerechargeapk.model.JioUser;
import com.mobilerechargeapk.model.Operator;
import com.mobilerechargeapk.model.User;

public class JioDao {
	public boolean insertJionet(JioUser jio) throws SQLException {
		boolean flag = false;
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		String insertQuery = "insert into jio_plans(plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, jio.getPlanName());
			pstmt.setDouble(2, jio.getPrice());
			pstmt.setString(3, jio.getValidity());
			pstmt.setString(4, jio.getBenfits());
			String subQuery = "select * from operator_details where operator_name=?";
			PreparedStatement pst = con.prepareStatement(subQuery);
			pst.setString(1, jio.getOperator().getOperatorname());
			ResultSet rs = pst.executeQuery();
			int opId = 0;
			if (rs.next()) {
				opId = rs.getInt(1);
			}
			System.out.println(opId);
			pstmt.setInt(5, opId);
			pstmt.executeUpdate();
//			ResultSet r=pstmt.executeQuery();
			flag = true;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

	public boolean updateJio(String planName1, Double price1, String validity1, String benefits1) {
		String updateQuery = "update table jio_plans set price=?,validity=?,benefits=? where jioplan_id=?";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		boolean flag = false;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, planName1);
			pstmt.setDouble(2, price1);
			pstmt.setString(3, validity1);
			pstmt.setString(4, benefits1);
			
		
			flag = pstmt.executeUpdate() > 0;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteJio(JioUser jio) {
		String deleteQuery = "delete table jio_plans where plan_name=?";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		boolean flag = false;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setString(1, jio.getPlanName());
			pstmt.executeUpdate();
			System.out.println("deleted succesfully");
		} catch (SQLException e) {
			System.out.println("deleted not properly");
			e.printStackTrace();
		}
		return flag;
	}
//	
//	public List<JioUser>showplan()
//	{
//		List<JioUser> jioList=new ArrayList<JioUser>();
//		String showQuery="select * from jio_plans";
//		ConnectionClass conclass=new ConnectionClass();
//		Connection con=conclass.getConnection();
//		
//		try {
//			Statement stmt=con.createStatement();
//			ResultSet rs=stmt.executeQuery(showQuery);
//			while(rs.next()) {
//				String subQuery = "select * from operator_details where operator_name=?";
//				PreparedStatement pst = con.prepareStatement(subQuery);
//				JioUser jio;
//				pst.setString(1,jio.getOperator().getOperatorname());
//				ResultSet rst = pst.executeQuery();
//				int opId = 0;
//				if (rs.next()) {
//					opId = rs.getInt(1);
//				}
////				JioUser jio1=new JioUser(rs.getString(2),Double.parseDouble(rs.getString(3)),rs.getString(4),rs.getString(5),
////						Integer.parseInt(rs.getString(6)));
////			}
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		return null;
////		
//	}
	
	
}
