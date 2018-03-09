package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userTable")
public class UserEntity {
	
	@Id
	private String emailId;
	@Column
	private Long phoneNo;
	@Column
	private String userName;
	
	public UserEntity(String emailId, Long phoneNo, String userName) {
		super();
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.userName = userName;
	}
	
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
	
	public UserEntity(){
		super();
	}
	
}
