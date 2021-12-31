package com.mobilerechargeapk.interfacedao;

import java.sql.ResultSet;
import java.util.List;

import com.mobilerechargeapk.model.JioUser;

public interface JioDaoInterface {
	public boolean insertJionet(JioUser jio);
	public boolean updateJio(String planName1, Double price1, String validity1, String benefits1, int jioplanId);
	public boolean deleteJio(int jioplanId);
	public List<JioUser> showJioplan();
	public  int findjioId(String planName, Double price);
	public ResultSet  findJiovalidity(JioUser jioUser);
}
