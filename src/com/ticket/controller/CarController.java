package com.ticket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticket.entites.Car;
import com.ticket.service.CarService;
import com.ticket.service.impl.CarServiceImpl;

/**
 * Servlet implementation class CarController
 */
public class CarController extends BaseController {
	private static final long serialVersionUID = 1L;

	private CarService carService = new CarServiceImpl();

	public CarController() {
		super();
	}

	public void getAllCar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String carnum = request.getParameter("carnum");
		String cardriver = request.getParameter("cardriver");
		Car car = new Car();
		car.setCar_num(carnum);
		car.setCar_driver(cardriver);
		List<Car> cars = carService.getAllCar(car);
		request.setAttribute("cars", cars);
		request.getRequestDispatcher("/pages/car/list.jsp").forward(request,
				response);
	}

	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String carnum = request.getParameter("carnum");
		String cardriver = request.getParameter("cardriver");
		String carseat = request.getParameter("carseat");
		Integer carSeat = null;
		if (carseat != null) {
			carSeat = Integer.parseInt(carseat);
		}
		Car car = new Car(carnum, cardriver, carSeat);
		carService.addCar(car);
		response.sendRedirect(request.getContextPath()
				+ "/CarController?method=getAllCar");
	}

	public void toUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String carid = request.getParameter("carid");
		Integer carId = Integer.parseInt(carid);
		Car car = carService.getCarById(carId);
		request.setAttribute("car", car);
		request.getRequestDispatcher("/pages/car/update.jsp").forward(request,
				response);
	}

	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String carid = request.getParameter("carid");
		String carnum = request.getParameter("carnum");
		String cardriver = request.getParameter("cardriver");
		String carseat = request.getParameter("carseat");
		Integer carId = Integer.parseInt(carid);
		Integer carSeat = Integer.parseInt(carseat);
		Car car = new Car(carId, carnum, cardriver, carSeat);
		carService.upateCar(car);
		response.sendRedirect(request.getContextPath()
				+ "/CarController?method=getAllCar");
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String carid = request.getParameter("carid");
		Integer carId = Integer.parseInt(carid);
		carService.deleteCarById(carId);
		response.sendRedirect(request.getContextPath()
				+ "/CarController?method=getAllCar");
	}
}
