package com.ticket.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.ticket.dao.CarDao;
import com.ticket.dao.DAO;
import com.ticket.entites.Car;
import com.ticket.common.utils.*;

public class CarDaoImpl extends DAO<Car> implements CarDao {

	@Override
	public List<Car> getAllCar(Car car) {
		String sql = "select * from t_car where data_statu = 0 ";
		if (car.getCar_num() != null && !"".equals(car.getCar_num())) {
			sql += " and car_num = '" + car.getCar_num() + "'";
		}
		if (car.getCar_driver() != null && !"".equals(car.getCar_driver())) {
			sql += " and car_driver = '" + car.getCar_driver() + "'";
		}
		Connection connection = null;
		List<Car> cars = null;
		try {
			connection = JDBUtils.getConnect();
			cars = getAllInstance(sql, connection);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBUtils.closeConnect(connection);
		}
		return cars;
	}

	@Override
	public void addCar(Car car) {
		String sql = "insert into t_car (car_num,car_driver,car_seat,data_statu,create_time,update_time) values (?,?,?,?,?,?)";
		Connection connection = null;
		try {
			connection = JDBUtils.getConnect();
			updateData(sql, connection, car.getCar_num(),car.getCar_driver(),car.getCar_seat(),0,new Date(),new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBUtils.closeConnect(connection);
		}
		
	}

	@Override
	public Car getCarById(Integer carId) {
		String sql = "select * from t_car where data_statu = 0 and car_id = ?";
		Connection connection = null;
		Car car = null;
		try {
			connection = JDBUtils.getConnect();
			car = getInstance(sql, connection, carId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBUtils.closeConnect(connection);
		}
		return car;
	}

	@Override
	public void upateCar(Car car) {
		String sql = "update t_car set car_num = ?,car_driver = ?,car_seat = ? where car_id = ?";
		Connection connection = null;
		try {
			connection = JDBUtils.getConnect();
			updateData(sql, connection, car.getCar_num(),car.getCar_driver(),car.getCar_seat(),car.getCar_id());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBUtils.closeConnect(connection);
		}
	}

	@Override
	public void deleteCarById(Integer carId) {
		String sql = "update t_car set data_statu = 1 where car_id = ?";
		Connection connection = null;
		try {
			connection = JDBUtils.getConnect();
			updateData(sql, connection,carId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBUtils.closeConnect(connection);
		}
	}
}
