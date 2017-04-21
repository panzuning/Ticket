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
		//数据格式化，用于生成订单号
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String orderid = ""+ System.currentTimeMillis() + format.format(new Date()) + line.getLine_id() + userid;
		Integer countInt = Integer.parseInt(count);
		Double totalcountDb = Double.parseDouble(totalcount);
		//封装订单信息，订单表需要的字段有，订单号，用户id（用于标识是哪个用户购买的），订单状态（0，为未支付），数量，总金额
		Order order = new Order(orderid,userid,0,countInt,totalcountDb);
		//将订单信息保存在订单表中
		orderDao.addOrder(order);
		//封装车票信息，车票表需要的字段有，路线的ID（用于关联路线表，获取车站，车牌号等信息），订单ID（用于查询订单表是属于哪个订单买的票），用户信息（购票人，购票人的电话）
		String[] userinfo = userInfo.split(",");
		Ticket ticket = new Ticket(line.getLine_id(), orderid, userinfo[0], userinfo[1]);
		//将车票信息保存在车票表中
		tickService.addTicket(ticket);
		//更新库存
		line.setTicket_num(line.getTicket_num() - 1);
		lineService.updateLine(line);
		//返回订单号
		return orderid;
	}

	@Override
	public List<Order> getAllOrder(Order order) {
		return orderDao.getAllOrder(order);
	}

}
