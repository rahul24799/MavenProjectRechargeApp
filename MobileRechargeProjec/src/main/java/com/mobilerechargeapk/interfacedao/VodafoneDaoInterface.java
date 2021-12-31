package com.mobilerechargeapk.interfacedao;

import java.sql.ResultSet;
import java.util.List;

import com.mobilerechargeapk.model.VodafoneUser;

public interface VodafoneDaoInterface {
	public boolean vodafoneNetwork(VodafoneUser vodafone);
	public boolean updateVodafone( String planName, Double price, String validity, String benefits,int vodafoneplanid);
	public boolean deleteVodafone(int vodafoneId);
	public int findvodafoneId(String planName, Double price) ;
	public List<VodafoneUser> showViplan();
	public ResultSet  findVodafonevalidity();

}
