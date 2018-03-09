package com.bean;

import java.util.Date;

public class Transactions {
	
	private User user;
	private String type;
	private Double price;
	private String stock;
	private Long quantity;
	private Date date;
	
	public Transactions(User user, String type, Double price, String stock, Long quantity, Date date) {
		super();
		this.user = user;
		this.type = type;
		this.price = price;
		this.stock = stock;
		this.quantity = quantity;
		this.date = date;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Transactions(){
		super();
	}
	
}
