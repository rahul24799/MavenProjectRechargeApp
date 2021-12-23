package com.mobilerechargeapk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mobilerechargeapk.model.Operator;
import com.mobilerechargeapk.model.User;

public class UserDao {

	public boolean insertUser(User user) throws SQLException {
		boolean flag = false;
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		String subQue = "select * from operator_details where operator_name=?";
		PreparedStatement pst = con.prepareStatement(subQue);
		// System.out.println(user.getOperator().getOperatorname());
		pst.setString(1, user.getOperator().getOperatorname());
		ResultSet rs = pst.executeQuery();
		int opId = 0;
		if (rs.next()) {
			opId = rs.getInt(1);
		}
		System.out.println(opId);
		String insertQuery = "insert into userlogin (user_name,Email_id,phone_number,password,wallet,operator_Id) values(?,?,?,?,?,?)";

		PreparedStatement pstmt = con.prepareStatement(insertQuery);

		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getEmailid());
		pstmt.setLong(3, user.getPhonenumber());
		pstmt.setString(4, user.getPassword());
		pstmt.setDouble(5, user.getWallet());
		pstmt.setInt(6, opId);

		flag = pstmt.executeUpdate() > 0;
		System.out.println("value insterted successfully");
		return flag;

	}

	public User validiateUser(String Emailid, String password) {
		String Query = "select * from userlogin where Email_Id='" + Emailid + "' and password='" + password + "'";
		Connection con = ConnectionClass.getConnection();
		User user = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery(Query);
			OperatorDao operatordao = new OperatorDao();
			if (rst.next()) {
				// user = new User(rst.getString(2), Emailid, password);
				Operator operator = operatordao.findOperator1(rst.getInt(7));
				System.out.println(operator);
				user = new User(rst.getString(2), Emailid, rst.getLong(4), password, rst.getDouble(6), operator);
			} else {
				System.out.println("invalid user name and password");
			}
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("invalid Statement ");
		}
		return user;

	}

	public int findUserId(User user) {
		String findId = "select user_id from userlogin where Email_id='" + user.getEmailid() + "'";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		Statement stmt = null;
		int id = 0;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(findId);
			if (rs.next()) {
				id = rs.getInt(1);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return id;

	}

	public static User findUser(String emailId) {
		String Query = "select * from userlogin where Email_id='" + emailId + "'";
		ConnectionClass conclass = new ConnectionClass();
		Connection con = conclass.getConnection();
		Statement stmt = null;
		User user = null;
		OperatorDao operatordao = new OperatorDao();
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(Query);
			if (rs.next()) {
				Operator operator = operatordao.findOperator1(rs.getInt(7));
				user = new User(rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), rs.getDouble(6),
						operator);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;

	}
}
