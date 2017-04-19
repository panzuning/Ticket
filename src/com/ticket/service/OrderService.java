package com.ticket.service;

import java.util.List;

import com.ticket.entites.Line;
import com.ticket.entites.Order;

public interface OrderService {

	public String commitOrder(Line line,String userInfo,Integer userId,String count,String totalcount);

	public List<Order> getAllOrder(Order order);
}
