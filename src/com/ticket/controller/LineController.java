package com.ticket.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticket.entites.Car;
import com.ticket.entites.Line;
import com.ticket.service.CarService;
import com.ticket.service.LineService;
import com.ticket.service.impl.CarServiceImpl;
import com.ticket.service.impl.LineServiceImpl;

/**
 * Servlet implementation class LineController
 */
public class LineController extends BaseController {
	private static final long serialVersionUID = 1L;

	private LineService lineService = new LineServiceImpl();
	private CarService carService = new CarServiceImpl();

	public LineController() {
		super();
	}

	protected void getAllLine(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String carnum = request.getParameter("carnum");
		String startstation = request.getParameter("startstation");
		String endstation = request.getParameter("endstation");
		System.out.println(startstation);
		Line line = new Line();
		line.setCar_num(carnum);
		line.setStart_station(startstation);
		line.setEnd_station(endstation);
		List<Line> lines = lineService.getAllLine(line);
		request.setAttribute("lines", lines);
		request.getRequestDispatcher("/pages/line/list.jsp").forward(request,
				response);
	}

	protected void toUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String lineid = request.getParameter("lineid");
		Line line = lineService.getLineById(lineid);
		List<Car> cars = carService.getAllCar(new Car());
		request.setAttribute("line", line);
		request.setAttribute("cars", cars);
		request.getRequestDispatcher("/pages/line/update.jsp").forward(request,
				response);
	}

	protected void update(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ParseException {
		String lineId = request.getParameter("lineid");
		String startStation = request.getParameter("startStation");
		String endStation = request.getParameter("endStation");
		String starttime = request.getParameter("starttime");
		String expectedtime = request.getParameter("expectedtime");
		String cars = request.getParameter("cars");
		String ticketprice = request.getParameter("ticketprice");
		String ticketnum = request.getParameter("ticketnum");
		Integer line_id = null;
		if(lineId != null){
			line_id = Integer.parseInt(lineId);
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date start_time = null;
		if(starttime != null){
			start_time = format.parse(starttime);
		}
		Date expected_time = null;
		if(expectedtime != null){
			expected_time = format.parse(expectedtime);
		}
		Integer car_id = null;
		if(cars != null){
			car_id = Integer.parseInt(cars);
		}
		Double ticket_price = null;
		if(ticketprice != null){
			ticket_price = Double.parseDouble(ticketprice);
		}
		Integer ticket_num = null;
		if(ticketnum != null){
			ticket_num = Integer.parseInt(ticketnum);
		}
		
		Line line = new Line(line_id, startStation, endStation, start_time, expected_time, ticket_price, ticket_num, car_id);
		lineService.updateLine(line);
		response.sendRedirect(request.getContextPath()
				+ "/LineController?method=getAllLine");
	}

	protected void delete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String lineid = request.getParameter("lineid");
		int lineId = Integer.parseInt(lineid);
		lineService.deleteLine(lineId);
		response.sendRedirect(request.getContextPath()
				+ "/LineController?method=getAllLine");
	}

	protected void toAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Car> cars = carService.getAllCar(new Car());
		request.setAttribute("cars", cars);
		request.getRequestDispatcher("/pages/line/create.jsp").forward(request,
				response);
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		
		String startStation = request.getParameter("startStation");
		String endStation = request.getParameter("endStation");
		String starttime = request.getParameter("starttime");
		String expectedtime = request.getParameter("expectedtime");
		String cars = request.getParameter("car");
		String ticketprice = request.getParameter("ticketprice");
		String ticketnum = request.getParameter("ticketnum");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date start_time = null;
		if(starttime != null){
			start_time = format.parse(starttime);
		}
		Date expected_time = null;
		if(expectedtime != null){
			expected_time = format.parse(expectedtime);
		}
		Integer car_id = null;
		if(cars != null){
			car_id = Integer.parseInt(cars);
		}
		Double ticket_price = null;
		if(ticketprice != null){
			ticket_price = Double.parseDouble(ticketprice);
		}
		Integer ticket_num = null;
		if(ticketnum != null){
			ticket_num = Integer.parseInt(ticketnum);
		}
		
		Line line = new Line(startStation, endStation, start_time, expected_time, ticket_price, ticket_num, car_id);
		lineService.addLine(line);
		response.sendRedirect(request.getContextPath()
				+ "/LineController?method=getAllLine");
	}

}
