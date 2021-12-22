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
import com.mobilerechargeapk.model.VodafoneUser;

public class VodafoneDao {
	public boolean vodafoneNetwork(VodafoneUser vodafone) throws SQLException {
		boolean flag = false;
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();

		String subQueries = "select * from operator_details where operator_name=?";
		PreparedStatement psmt = con.prepareStatement(subQueries);
		psmt.setString(1, vodafone.getOperator().getOperatorname());
		ResultSet rs = psmt.executeQuery();
		int opId = 0;
		if (rs.next()) {
			opId = rs.getInt(1);
		}

		String insertQueries = "insert into vodafone_plans(plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(insertQueries);
			pstmt.setString(1, vodafone.getPlanName());
			pstmt.setDouble(2, vodafone.getPrice());
			pstmt.setString(3, vodafone.getValidity());
			pstmt.setString(4, vodafone.getBenfits());
			pstmt.setInt(5, opId);
			pstmt.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query will incorrect");
		}
		return flag;
	}

	public boolean updateVodafone( String planName, Double price, String validity, String benefits,int vodafoneplanid) {

		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		String updateQuery = "update vodafone_plans set plan_name=?,price=?,validity=?,benefits=? where vodafoneplan_id =?";
		boolean flag = false;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(updateQuery);
		
			pstmt.setString(1, planName);
			pstmt.setDouble(2, price);
			pstmt.setString(3, validity);
			pstmt.setString(4, benefits);
			pstmt.setInt(5, vodafoneplanid);
		flag=pstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
			System.out.println("updated Query will incorrect");
			e.printStackTrace();
		}

		return flag;

	}

	public boolean deleteVodafone(int vodafoneId) {

		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		String deleteQuery = "delete vodafone_plans where vodafoneplan_id =?";
		boolean flag = false;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1,vodafoneId);
		flag=pstmt.executeUpdate()>0;
			
		} catch (SQLException e) {
		System.out.println("Delete Query will in correct");
			e.printStackTrace();
		}

		return flag;

	}

	public static int findvodafoneId(String planName, Double price) {
		String query = "select vodafoneplan_id from vodafone_plans where plan_name=? and price=?";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		PreparedStatement pstmt;
		int vodafoneId = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, planName);
			pstmt.setDouble(2, price);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				vodafoneId = rs.getInt(1);
			}
		} catch (SQLException e) {
            System.out.println("Query will incorrect");
			e.printStackTrace();
		}

		return vodafoneId;

	}

	public List<VodafoneUser> showViplan() {
		VodafoneUser vodafone = new VodafoneUser();
		List<VodafoneUser> vodafoneList = new ArrayList<VodafoneUser>();
		String showQuery = "select * from vodafone_plans";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			OperatorDao operatordao = new OperatorDao();
			while (rs.next()) {
				Operator operator = operatordao.findOperator(rs.getString(2));
				vodafone = new VodafoneUser(rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5),
						operator);
				vodafoneList.add(vodafone);
			}
		} catch (SQLException e) {
           System.out.println("Query will incorrect");
			e.printStackTrace();
		}
		return vodafoneList;
	}
}
