package com.ticket.service;

import java.util.List;

import com.ticket.entites.Car;

public interface CarService {

	public List<Car> getAllCar(Car car);

	public void addCar(Car car);

	public Car getCarById(Integer carId);

	public void upateCar(Car car);

	public void deleteCarById(Integer carId);
}
