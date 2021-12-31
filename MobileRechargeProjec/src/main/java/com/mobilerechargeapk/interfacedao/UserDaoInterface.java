package com.mobilerechargeapk.interfacedao;

import com.mobilerechargeapk.model.User;

public interface UserDaoInterface {
	public boolean insertUser(User user);
	public User validiateUser(String Emailid, String password);
	public int findUserId(User user);
	public  User findUser(String emailId);
	public int updateuserWallet(User user);
    public int rechargeWalletupdate(double planPrice, User user);
}