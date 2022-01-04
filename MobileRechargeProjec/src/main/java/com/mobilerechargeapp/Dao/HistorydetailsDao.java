package com.mobilerechargeapp.Dao;

import com.mobilerechargeapp.model.HistoryDetails;
import com.mobilerechargeapp.model.User;

public interface HistorydetailsDao {
	public boolean insertDetails(HistoryDetails historyDetails);
 	public HistoryDetails rechargeRemainder(User user);
}
