package com.ticket.service.impl;

import java.util.List;

import com.ticket.dao.CarDao;
import com.ticket.dao.impl.CarDaoImpl;
import com.ticket.entites.Car;
import com.ticket.service.CarService;

public class CarServiceImpl implements CarService{
	
	private CarDao carDao = new CarDaoImpl();

	@Override
	public List<Car> getAllCar(Car car) {
		return carDao.getAllCar(car);
	}

	@Override
	public void addCar(Car car) {
		carDao.addCar(car);
		
	}

	@Override
	public Car getCarById(Integer carId) {
		return carDao.getCarById(carId);
	}

	@Override
	public void upateCar(Car car) {
		carDao.upateCar(car);
		
	}

	@Override
	public void deleteCarById(Integer carId) {
		carDao.deleteCarById(carId);
	}

}
