package com.ticket.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ticket.dao.OrderDao;
import com.ticket.dao.impl.OrderDaoImpl;
import com.ticket.entites.Order;
import com.ticket.entites.Ticket;
import com.ticket.service.OrderService;
import com.ticket.service.TicketService;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = new OrderDaoImpl();
	
	private TicketService tickService = new TicketServiceImpl();
	
	@Override
	public String commitOrder(String lineid, String userInfo,Integer userid) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String orderid = format.format(new Date()) + lineid + userid;
		Order order = new Order(orderid,userid,0);
		orderDao.addOrder(order);
		String[] userinfo = userInfo.split(",");
		Integer lineId = Integer.parseInt(lineid);
		Ticket ticket = new Ticket(lineId, orderid, userinfo[0], userinfo[1]);
		tickService.addTicket(ticket);
		return orderid;
	}

}
