package com.mobilerechargeapk.model;

import java.util.Objects;

public class HistoryDetails {
	private int historyId;
	private int userId;
	private int operator_id;
	private String validity;
	public int getHistoryId() {
		return historyId;
	}
	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOperator_id() {
		return operator_id;
	}
	public void setOperator_id(int operator_id) {
		this.operator_id = operator_id;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public HistoryDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistoryDetails(int historyId, int userId, int operator_id, String validity) {
		super();
		this.historyId = historyId;
		this.userId = userId;
		this.operator_id = operator_id;
		this.validity = validity;
	}
	@Override
	public String toString() {
		return "HistoryDetails [historyId=" + historyId + ", userId=" + userId + ", operator_id=" + operator_id
				+ ", validity=" + validity + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(historyId, operator_id, userId, validity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoryDetails other = (HistoryDetails) obj;
		return historyId == other.historyId && operator_id == other.operator_id && userId == other.userId
				&& Objects.equals(validity, other.validity);
	}
	

}
