package com.ticket.entites;

import java.io.Serializable;

public class Car implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer car_id;
	private String car_num;
	private String car_driver;
	private Integer car_seat;
	
	public Car() {
		super();
	}
	
	public Car(Integer car_id, String car_num, String car_driver,
			Integer car_seat) {
		super();
		this.car_id = car_id;
		this.car_num = car_num;
		this.car_driver = car_driver;
		this.car_seat = car_seat;
	}


	public Car(String car_num, String car_driver, Integer car_seat) {
		super();
		this.car_num = car_num;
		this.car_driver = car_driver;
		this.car_seat = car_seat;
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

	public String getCar_driver() {
		return car_driver;
	}

	public void setCar_driver(String car_driver) {
		this.car_driver = car_driver;
	}

	public Integer getCar_seat() {
		return car_seat;
	}

	public void setCar_seat(Integer car_seat) {
		this.car_seat = car_seat;
	}

	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", car_num=" + car_num
				+ ", car_driver=" + car_driver + ", car_seat=" + car_seat + "]";
	}

}
