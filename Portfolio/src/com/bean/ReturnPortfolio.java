package com.bean;

import java.util.ArrayList;
import java.util.List;

public class ReturnPortfolio {

	User user;
	List<Compute> details = new ArrayList<Compute>();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Compute> getDetails() {
		return details;
	}
	public void setDetails(List<Compute> details) {
		this.details = details;
	}
	
	
}
