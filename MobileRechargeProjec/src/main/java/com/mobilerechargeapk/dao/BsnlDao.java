package com.mobilerechargeapk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mobilerechargeapk.interfacedao.BsnlDaoInterface;
import com.mobilerechargeapk.model.AirtelUser;
import com.mobilerechargeapk.model.BsnlUser;
import com.mobilerechargeapk.model.JioUser;
import com.mobilerechargeapk.model.Operator;
import com.mobilerechargeapk.model.User;

public class BsnlDao implements BsnlDaoInterface{
	public boolean insertBsnlnetwork(BsnlUser bsnl)  {
		boolean flag = false;
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		String subQuery = "select * from operator_details where operator_name=?";
		try {
		PreparedStatement pst = con.prepareStatement(subQuery);
		pst.setString(1, bsnl.getOperator().getOperatorname());
		ResultSet rst = pst.executeQuery();
		int opId = 0;
		if (rst.next()) {
			opId = rst.getInt(1);
		}
		System.out.println(opId);

		String insertQuery = "insert into bsnl_plans(plan_name,price,validity,benefits,operator_id)values(?,?,?,?,?)";
		
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, bsnl.getPlanName());
			pstmt.setDouble(2, bsnl.getPrice());
			pstmt.setString(3, bsnl.getValidity());
			pstmt.setString(4, bsnl.getBenfits());
			pstmt.setInt(5, opId);
			flag=pstmt.executeUpdate()>0;
		
		} catch (SQLException e) 
		{

			e.printStackTrace();
		}
		return flag;

	}

	public boolean updateBsnl(String planName, Double price, String validity, String benefits, int bsnlId) {
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		boolean flag = false;
		PreparedStatement pstmt = null;
		String updateQuery = "update bsnl_plans set plan_name=?,price=?,validity=?,benefits=? where bsnlplan_id=?";

		try {
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, planName);
			pstmt.setDouble(2, price);
			pstmt.setString(3, validity);
			pstmt.setString(4, benefits);
			pstmt.setInt(5, bsnlId);
			flag = pstmt.executeUpdate() > 0;
			System.out.println("updated succesfully");
		} catch (SQLException e) {
			System.out.println("updated not properly");
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteBsnl(int bsnlId) {
		boolean flag = false;
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		String deleteQuery = "delete from bsnl_plans where bsnlplan_id=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, bsnlId);
			flag = pstmt.executeUpdate() > 0;
	
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query is Error");
		}

		return flag;
	}

	public int findbsnlId(String planName, Double price) {
		String query = "select bsnlplan_id from BSNL_plans where plan_name=? and price=?";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		PreparedStatement pstmt;
		int bsnlId = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, planName);
			pstmt.setDouble(2, price);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bsnlId = rs.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return bsnlId;

	}

	public List<BsnlUser> showBsnlplan() {
		BsnlUser bsnl = new BsnlUser();
		List<BsnlUser> bsnlList = new ArrayList<BsnlUser>();
		String showQuery = "select * from BSNL_plans ";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(showQuery);
			OperatorDao operatordao = new OperatorDao();
			while (rs.next()) {
				Operator operator = operatordao.findOperator1(rs.getInt(6));
				bsnl = new BsnlUser(rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), operator);
				bsnlList.add(bsnl);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return bsnlList;
	}
	public ResultSet  findBsnlvalidity() {
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		BsnlDao bsnlDao=new BsnlDao();
		BsnlUser bsnlUser=new BsnlUser();
		int BsnlUserId=bsnlDao. findbsnlId(bsnlUser.getPlanName(),bsnlUser.getPrice());
		String Query = "select validity from jio_plans where jioplan_id="+BsnlUserId;
		ResultSet rs=null;
		try {
			
			Statement stmt=con.createStatement();
		     rs = stmt.executeQuery(Query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}

}
