package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class suppliers {
	
	@Id
	private String supplier_code;
	
	private String fullname;
	private String location;
	private String mobile;
	
	
	
	public String getSupplier_code() {
		return supplier_code;
	}
	public void setSupplier_code(String supplier_code) {
		this.supplier_code = supplier_code;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	@Override
	public String toString() {
		return "supplier_code: " + supplier_code + ", fullname: " + fullname + ", location: "
				+ location + ", mobile: " + mobile;
	}
	
	
}
