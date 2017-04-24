package com.ticket.dao;

import java.util.List;

import com.ticket.entites.Order;

public interface OrderDao {

	public void addOrder(Order order);

	public List<Order> getAllOrder(Order order);

	public void deleteOrderById(String orderid);
}
