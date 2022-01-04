package com.mobilerechargeapp.Dao;

import com.mobilerechargeapp.model.User;

public interface UserDao {
	public boolean insertUser(User user);
	public User validiateUser(String Emailid, String password);
	public int findUserId(User user);
	public  User findUser(String emailId);
	public int updateuserWallet(User user);
    public int rechargeWalletupdate(double planPrice, User user);
}