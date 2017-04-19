package com.ticket.entites;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	private String orderId;

	private Integer userId;

	private Integer payStatu;

	private Integer count;

	private Double totalcount;
	
	
	
	public Order(String orderId, Integer payStatu, Integer count, Double totalcount) {
		super();
		this.orderId = orderId;
		this.payStatu = payStatu;
		this.count = count;
		this.totalcount = totalcount;
	}

	public Order(String orderId, Integer userId, Integer payStatu, Integer count, Double totalcount) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.payStatu = payStatu;
		this.count = count;
		this.totalcount = totalcount;
	}

	public Order() {
		super();
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(Double totalcount) {
		this.totalcount = totalcount;
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
