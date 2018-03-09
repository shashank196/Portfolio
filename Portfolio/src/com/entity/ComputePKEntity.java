package com.entity;

import java.io.Serializable;

public class ComputePKEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String emailId;
	private String stock;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	
	public ComputePKEntity(String emailId, String stock) {
		super();
		this.emailId = emailId;
		this.stock = stock;
	}
	
	public ComputePKEntity() {
		super();
	}
}
