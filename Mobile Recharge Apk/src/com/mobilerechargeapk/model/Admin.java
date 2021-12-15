package com.mobilerechargeapk.model;

import java.util.Objects;

public class Admin {
	private int adminId;
    private String adminName;
    private String password;
    
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return adminName;
	}
	public void setName(String name) {
		this.adminName = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Admin(int adminId,String name, String password) {
		super();
		this.adminId=adminId;
		this.adminName = name;
		this.password = password;
		
	}
	@Override
	public String toString() {
		return "Admin [adminId="+adminId+",adminName=" + adminName + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(adminId, adminName, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return adminId == other.adminId && Objects.equals(adminName, other.adminName)
				&& Objects.equals(password, other.password);
	}
	
    
    
}
