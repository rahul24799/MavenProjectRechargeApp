package com.mobilerechargeapk.model;

import java.util.Objects;

public class BsnlUser {
	private int bsnlplanId;
	private String planName;
	private double price;
	private  String validity;
	private String benfits;
	private int operatorId;
	public int getBsnlplanId() {
		return bsnlplanId;
	}
	public void setBsnlplanId(int bsnlplanId) {
		this.bsnlplanId = bsnlplanId;
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
	public BsnlUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BsnlUser(int bsnlplanId, String planName, double price, String validity, String benfits, int operatorId) {
		super();
		this.bsnlplanId = bsnlplanId;
		this.planName = planName;
		this.price = price;
		this.validity = validity;
		this.benfits = benfits;
		this.operatorId = operatorId;
	}
	@Override
	public String toString() {
		return "BsnlUser [bsnlplanId=" + bsnlplanId + ", planName=" + planName + ", price=" + price + ", validity="
				+ validity + ", benfits=" + benfits + ", operatorId=" + operatorId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(benfits, bsnlplanId, operatorId, planName, price, validity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BsnlUser other = (BsnlUser) obj;
		return Objects.equals(benfits, other.benfits) && bsnlplanId == other.bsnlplanId
				&& operatorId == other.operatorId && Objects.equals(planName, other.planName)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(validity, other.validity);
	}
	
	

}
