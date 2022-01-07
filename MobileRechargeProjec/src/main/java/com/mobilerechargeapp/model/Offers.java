package com.mobilerechargeapp.model;

import java.util.Objects;

public class Offers {
   public Operator operator;
   public int planId;
   public String Description;
   public String offerValidity;
public Operator getOperator() {
	return operator;
}
public void setOperator(Operator operator) {
	this.operator = operator;
}
public int getPlanId() {
	return planId;
}
public void setPlanId(int planId) {
	this.planId = planId;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getOfferValidity() {
	return offerValidity;
}
public void setOfferValidity(String offerValidity) {
	this.offerValidity = offerValidity;
}
public Offers() {
	super();
	// TODO Auto-generated constructor stub
}
public Offers(Operator operator, int planId, String description, String offerValidity) {
	super();
	this.operator = operator;
	this.planId = planId;
	Description = description;
	this.offerValidity = offerValidity;
}
@Override
public String toString() {
	return "Offers [operator=" + operator + ", planId=" + planId + ", Description=" + Description + ", offerValidity="
			+ offerValidity + "]";
}
@Override
public int hashCode() {
	return Objects.hash(Description, offerValidity, operator, planId);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Offers other = (Offers) obj;
	return Objects.equals(Description, other.Description) && Objects.equals(offerValidity, other.offerValidity)
			&& Objects.equals(operator, other.operator) && planId == other.planId;
}
   
}
