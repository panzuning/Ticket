package com.ticket.entites;

import java.io.Serializable;

public class Order implements Serializable{

	private static final long serialVersionUID = 1L;

	private String orderId;
	
	private Integer userId;
	
	private Integer payStatu;


	
	public Order(String orderId, Integer userId, Integer payStatu) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.payStatu = payStatu;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPayStatu() {
		return payStatu;
	}

	public void setPayStatu(Integer payStatu) {
		this.payStatu = payStatu;
	}
	
	
}
