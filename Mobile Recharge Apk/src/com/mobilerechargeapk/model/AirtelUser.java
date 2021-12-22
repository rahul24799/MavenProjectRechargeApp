package com.mobilerechargeapk.model;

import java.util.Objects;

public class AirtelUser {
	private String planName;
	private double price;
	private  String validity;
	private String benfits;
	private Operator operator;
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
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public AirtelUser() {
		super();
		
	}
	public AirtelUser(String planName, double price, String validity, String benfits, Operator operator) {
		super();
		this.planName = planName;
		this.price = price;
		this.validity = validity;
		this.benfits = benfits;
		this.operator = operator;
	}
	public AirtelUser(String string, double double1, String string2, String string3) {
		this.planName=string;
		this.price=double1;
		this.validity=string2;
		this.benfits=string3;
	}
	@Override
	public String toString() {
		return "AirtelUser [planName=" + planName + ", price=" + price + ", validity=" + validity + ", benfits="
				+ benfits + ", operator=" + operator + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(benfits, operator, planName, price, validity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirtelUser other = (AirtelUser) obj;
		return Objects.equals(benfits, other.benfits) && Objects.equals(operator, other.operator)
				&& Objects.equals(planName, other.planName)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(validity, other.validity);
	}
	
	
}
