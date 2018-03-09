package com.bean;

public class User {
	
	private String emailId;
	private Long phoneNo;
	private String userName;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public User(String emailId, Long phoneNo, String userName) {
		super();
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.userName = userName;
	}
	
	public User(){
		super();
	}
	
}
