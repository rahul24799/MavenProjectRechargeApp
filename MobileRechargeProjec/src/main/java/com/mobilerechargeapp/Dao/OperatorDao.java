package com.mobilerechargeapp.Dao;

import com.mobilerechargeapp.model.Operator;

public interface OperatorDao {
	public  Operator findOperator(String name);
	public int findOperatorId();
    public Operator findOperator1(int id);

}
