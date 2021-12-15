package com.mobilerechargeapk.model;

import java.util.Objects;

public class JioUser {
	private int jioplanId;
	private String planName;
	private double price;
	private  String validity;
	private String benfits;
	private int operatorId;
	public int getJioplanId() {
		return jioplanId;
	}
	public void setJioId(int jioId) {
		this.jioplanId = jioId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getBenfits() {
		return benfits;
	}
	public void setBenfits(String benfits) {
		this.benfits = benfits;
	}
	public int getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}
	public JioUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JioUser(int jioId, String planName, double price, String validity, String benfits, int operatorId) {
		super();
		this.jioplanId = jioId;
		this.planName = planName;
		this.price = price;
		this.validity = validity;
		this.benfits = benfits;
		this.operatorId = operatorId;
	}
	@Override
	public String toString() {
		return "JioplanUser [jioId=" + jioplanId + ", planName=" + planName + ", price=" + price + ", validity=" + validity
				+ ", benfits=" + benfits + ", operatorId=" + operatorId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(benfits, jioplanId, operatorId, planName, price, validity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JioUser other = (JioUser) obj;
		return Objects.equals(benfits, other.benfits) && jioplanId == other.jioplanId && operatorId == other.operatorId
				&& Objects.equals(planName, other.planName)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(validity, other.validity);
	}
	
	

}
