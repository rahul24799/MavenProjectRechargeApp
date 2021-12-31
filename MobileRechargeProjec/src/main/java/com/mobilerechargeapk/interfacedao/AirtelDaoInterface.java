package com.mobilerechargeapk.interfacedao;

import java.sql.ResultSet;
import java.util.List;

import com.mobilerechargeapk.model.AirtelUser;

public interface AirtelDaoInterface {
	 public boolean insertAirtelnet(AirtelUser airtel);
	 public boolean updateAirtel(String planname, Double price, String validity, String benefits,int airtelplanId);
	 public boolean deleteAirtel(int airtelplanId);
	 public List<AirtelUser>showAirtelplan();
	 public  int  findairtelId(String planName,Double price);
	 public ResultSet  findAirtelvalidity();
	 
}