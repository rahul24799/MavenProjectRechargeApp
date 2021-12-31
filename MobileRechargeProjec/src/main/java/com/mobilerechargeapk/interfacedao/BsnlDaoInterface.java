package com.mobilerechargeapk.interfacedao;

import java.sql.ResultSet;
import java.util.List;

import com.mobilerechargeapk.model.BsnlUser;

public interface BsnlDaoInterface {
	public boolean insertBsnlnetwork(BsnlUser bsnl);
	public boolean updateBsnl(String planName, Double price, String validity, String benefits, int bsnlId);
	public boolean deleteBsnl(int bsnlId);
	public int findbsnlId(String planName, Double price);
	public List<BsnlUser> showBsnlplan();
	public ResultSet  findBsnlvalidity() ;

}
