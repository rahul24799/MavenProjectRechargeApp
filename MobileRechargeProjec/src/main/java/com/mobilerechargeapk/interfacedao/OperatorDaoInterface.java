package com.mobilerechargeapk.interfacedao;

import com.mobilerechargeapk.model.Operator;

public interface OperatorDaoInterface {
	public  Operator findOperator(String name);
	public int findOperatorId();
    public Operator findOperator1(int id);

}
