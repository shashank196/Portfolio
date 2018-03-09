package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name="compute")
@IdClass(ComputePKEntity.class)
public class ComputeEntity {
	
	@Id
	private String emailId;
	@Id
	private String stock;
	@Column
	private Double buy_amount;
	@Column
	private Double sell_amount;
	@Column
	private Integer buy_count;
	@Column
	private Double total_buy;
	@Column
	private Long buy_quantity;
	@Column
	private Long sell_quantity;
	
	
	
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
	public Double getBuy_amount() {
		return buy_amount;
	}
	public void setBuy_amount(Double buy_amount) {
		this.buy_amount = buy_amount;
	}
	public Double getSell_amount() {
		return sell_amount;
	}
	public void setSell_amount(Double sell_amount) {
		this.sell_amount = sell_amount;
	}
	public Integer getBuy_count() {
		return buy_count;
	}
	public void setBuy_count(Integer buy_count) {
		this.buy_count = buy_count;
	}
	public Double getTotal_buy() {
		return total_buy;
	}
	public void setTotal_buy(Double total_buy) {
		this.total_buy = total_buy;
	}
	public Long getBuy_quantity() {
		return buy_quantity;
	}
	public void setBuy_quantity(Long buy_quantity) {
		this.buy_quantity = buy_quantity;
	}
	public Long getSell_quantity() {
		return sell_quantity;
	}
	public void setSell_quantity(Long sell_quantity) {
		this.sell_quantity = sell_quantity;
	}
	
	public ComputeEntity() {
		super();
		this.buy_amount = 0.0;
		this.sell_amount = 0.0;
		this.buy_count = 0;
		this.total_buy = 0.0;
		this.buy_quantity = 0l;
		this.sell_quantity = 0l;

	}
	
}
