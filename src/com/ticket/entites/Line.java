package com.ticket.entites;

import java.io.Serializable;
import java.util.Date;

public class Line implements Serializable {

	private static final long serialVersionUID = 1L;
	// 线路id
	private Integer line_id;
	// 始发站
	private String start_station;
	// 终点站
	private String end_station;
	// 发车时间
	private Date start_time;
	// 预计时间
	private Date expected_time;
	// 票价
	private Double ticket_price;
	// 票数
	private Integer ticket_num;
	// 对应的车次
	private Integer car_id;
	private String car_num;

	public Line() {
		super();
	}

	public Line(Integer line_id, String start_station, String end_station, Date start_time, Date expected_time,
			Double ticket_price, Integer ticket_num, Integer car_id) {
		super();
		this.line_id = line_id;
		this.start_station = start_station;
		this.end_station = end_station;
		this.start_time = start_time;
		this.expected_time = expected_time;
		this.ticket_price = ticket_price;
		this.ticket_num = ticket_num;
		this.car_id = car_id;
	}

	public Line(String start_station, String end_station, Date start_time, Date expected_time, Double ticket_price,
			Integer ticket_num, Integer car_id) {
		super();
		this.start_station = start_station;
		this.end_station = end_station;
		this.start_time = start_time;
		this.expected_time = expected_time;
		this.ticket_price = ticket_price;
		this.ticket_num = ticket_num;
		this.car_id = car_id;
	}

	public Integer getCar_id() {
		return car_id;
	}

	public void setCar_id(Integer car_id) {
		this.car_id = car_id;
	}

	public String getCar_num() {
		return car_num;
	}

	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}

	public Integer getLine_id() {
		return line_id;
	}

	public void setLine_id(Integer line_id) {
		this.line_id = line_id;
	}

	public String getStart_station() {
		return start_station;
	}

	public void setStart_station(String start_station) {
		this.start_station = start_station;
	}

	public String getEnd_station() {
		return end_station;
	}

	public void setEnd_station(String end_station) {
		this.end_station = end_station;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getExpected_time() {
		return expected_time;
	}

	public void setExpected_time(Date expected_time) {
		this.expected_time = expected_time;
	}

	public Double getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(Double ticket_price) {
		this.ticket_price = ticket_price;
	}

	public Integer getTicket_num() {
		return ticket_num;
	}

	public void setTicket_num(Integer ticket_num) {
		this.ticket_num = ticket_num;
	}

	@Override
	public String toString() {
		return "Line [line_id=" + line_id + ", start_station=" + start_station + ", end_station=" + end_station
				+ ", start_time=" + start_time + ", expected_time=" + expected_time + ", ticket_price=" + ticket_price
				+ ", ticket_num=" + ticket_num + "]";
	}

}
