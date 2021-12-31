package com.mobilerechargeapk.interfacedao;

import com.mobilerechargeapk.model.HistoryDetails;
import com.mobilerechargeapk.model.User;

public interface HistorydetailsDaoInterface {
	public boolean insertDetails(HistoryDetails historyDetails);
 	public HistoryDetails rechargeRemainder(User user);
}
