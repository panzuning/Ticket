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
 * 
 * 
 * 每个请求入口类，基类为servlet，通过继承BaseController的get方法判断调用的是那个方法
 */
public class CarController extends BaseController {
	private static final long serialVersionUID = 1L;

	private CarService carService = new CarServiceImpl();

	public CarController() {
		super();
	}

	/**
	 * 获取所有的车辆信息的请求方法入口
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getAllCar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取请求的参数
		String carnum = request.getParameter("carnum");
		String cardriver = request.getParameter("cardriver");
		//创建一个车辆的实例，也就是对象
		Car car = new Car();
		//为该对象属性赋值
		car.setCar_num(carnum);
		car.setCar_driver(cardriver);
		//从数据库查出符合条件的车辆信息集合
		List<Car> cars = carService.getAllCar(car);
		//将集合保存到request域中，在页面通过EL表达式${requestScope.cars}获取
		request.setAttribute("cars", cars);
		//转发到/pages/car/list.jsp这个页面下，使用转发可以保证request域中的数据不会丢失，重定向无法对request携带数据，不属于同一个请求
		request.getRequestDispatcher("/pages/car/list.jsp").forward(request,
				response);
	}

	/**
	 * 添加车辆请求入口方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取请求URL中的请求参数
		String carnum = request.getParameter("carnum");
		String cardriver = request.getParameter("cardriver");
		String carseat = request.getParameter("carseat");
		Integer carSeat = null;
		//String 类型转换为Integer类型，判断String是否为null，如果为null，将会报数据格式异常
		if (carseat != null) {
			carSeat = Integer.parseInt(carseat);
		}
		//数据封装
		Car car = new Car(carnum, cardriver, carSeat);
		//将数据保存到数据库中，调用carService中的addCar方法
		carService.addCar(car);
		//不携带任何数据 ，使用重定向
		response.sendRedirect(request.getContextPath()
				+ "/CarController?method=getAllCar");
	}

	/**
	 * 车辆更新，用于回显数据的请求接口
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取请求URL参数carid，需要通过id查询该车辆信息进行回显
		String carid = request.getParameter("carid");
		//类型转换
		Integer carId = Integer.parseInt(carid);
		//通过ID查询车辆信息
		Car car = carService.getCarById(carId);
		//将车辆信息保存在request域中
		request.setAttribute("car", car);
		//转发到/pages/car/update.jsp页面下
		request.getRequestDispatcher("/pages/car/update.jsp").forward(request,
				response);
	}

	
	/**
	 * 车辆信息进行更新操作接口
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取发送过来的请求车辆信息
		String carid = request.getParameter("carid"); //车辆ID，用于判断是哪个车辆信息进行更新
		String carnum = request.getParameter("carnum"); //车牌号
		String cardriver = request.getParameter("cardriver");//司机
		String carseat = request.getParameter("carseat"); //座位数
		Integer carId = Integer.parseInt(carid);
		Integer carSeat = Integer.parseInt(carseat);
		//封装车辆信息
		Car car = new Car(carId, carnum, cardriver, carSeat);
		//进行车辆数据更新
		carService.upateCar(car);
		//重定向
		response.sendRedirect(request.getContextPath()
				+ "/CarController?method=getAllCar");
	}
	
	/**
	 * 车辆删除请求接口，根据车辆ID进行删除
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String carid = request.getParameter("carid");
		Integer carId = Integer.parseInt(carid);
		carService.deleteCarById(carId);
		response.sendRedirect(request.getContextPath()
				+ "/CarController?method=getAllCar");
	}
}
