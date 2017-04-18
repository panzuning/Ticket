package com.ticket.entites;

import java.io.Serializable;

public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ticketId;

	private Integer lineId;

	private String orderId;

	private String rider;
	private String riderphone;

	public Ticket() {
		super();
	}

	public Ticket(Integer lineId, String orderId, String rider, String riderphone) {
		super();
		this.lineId = lineId;
		this.orderId = orderId;
		this.rider = rider;
		this.riderphone = riderphone;
	}

	public Ticket(Integer ticketId, Integer lineId, String orderId, String rider, String riderphone) {
		super();
		this.ticketId = ticketId;
		this.lineId = lineId;
		this.orderId = orderId;
		this.rider = rider;
		this.riderphone = riderphone;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Integer getLineId() {
		return lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	public String getRider() {
		return rider;
	}

	public void setRider(String rider) {
		this.rider = rider;
	}

	public String getRiderphone() {
		return riderphone;
	}

	public void setRiderphone(String riderphone) {
		this.riderphone = riderphone;
	}

}
