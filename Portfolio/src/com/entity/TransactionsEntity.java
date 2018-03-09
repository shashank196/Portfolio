package com.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="transactions")
public class TransactionsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emailId")
	private UserEntity userEntity;
	@Column
	private String type;
	@Column
	private Double price;
	@Column
	private String stock;
	@Column
	private Long quantity;
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	public TransactionsEntity(UserEntity userEntity, String type, Double price, String stock,
			Long quantity, Date date) {
		super();
		this.userEntity = userEntity;
		this.type = type;
		this.price = price;
		this.stock = stock;
		this.quantity = quantity;
		this.date = date;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
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
	
	public TransactionsEntity(){
		super();
	}
}
