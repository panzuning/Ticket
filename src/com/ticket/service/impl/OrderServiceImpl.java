package com.ticket.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ticket.dao.OrderDao;
import com.ticket.dao.impl.OrderDaoImpl;
import com.ticket.entites.Line;
import com.ticket.entites.Order;
import com.ticket.entites.Ticket;
import com.ticket.service.LineService;
import com.ticket.service.OrderService;
import com.ticket.service.TicketService;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = new OrderDaoImpl();
	
	private LineService lineService = new LineServiceImpl();
	
	private TicketService tickService = new TicketServiceImpl();
	
	@Override
	public String commitOrder(Line line, String userInfo,Integer userid,String count,String totalcount) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String orderid = ""+ System.currentTimeMillis() + format.format(new Date()) + line.getLine_id() + userid;
		Integer countInt = Integer.parseInt(count);
		Double totalcountDb = Double.parseDouble(totalcount);
		Order order = new Order(orderid,userid,0,countInt,totalcountDb);
		orderDao.addOrder(order);
		String[] userinfo = userInfo.split(",");
		Ticket ticket = new Ticket(line.getLine_id(), orderid, userinfo[0], userinfo[1]);
		tickService.addTicket(ticket);
		line.setTicket_num(line.getTicket_num() - 1);
		lineService.updateLine(line);
		return orderid;
	}

	@Override
	public List<Order> getAllOrder(Order order) {
		return orderDao.getAllOrder(order);
	}

}
