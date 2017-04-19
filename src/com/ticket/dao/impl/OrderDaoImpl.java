package com.ticket.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.ticket.dao.DAO;
import com.ticket.dao.OrderDao;
import com.ticket.entites.Order;
import com.ticket.common.utils.*;

public class OrderDaoImpl extends DAO<Order> implements OrderDao {

	@Override
	public void addOrder(Order order) {

		String sql = "insert into t_order (orderid,pay_statu,userid,data_statu,create_time,update_time,count,totalcount) values (?,?,?,?,?,?,?,?)";
		Connection connection = null;
		try {
			connection = JDBUtils.getConnect();
			updateData(sql, connection, order.getOrderId(), 0, order.getUserId(), 0, new Date(), new Date(),order.getCount(),order.getTotalcount());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBUtils.closeConnect(connection);
		}
	}

	@Override
	public List<Order> getAllOrder(Order order) {
		String sql = "select orderid orderId,pay_statu payStatu,count,totalcount from t_order where data_statu = 0 ";
		if(order.getOrderId() != null && !"".equals(order.getOrderId())){
			sql += " and orderid = '" + order.getOrderId() + "'";
		}
		if(order.getPayStatu() != null){
			sql += " and pay_statu = " + order.getPayStatu();
		}
		Connection connection = null;
		List<Order> orders = null;
		try {
			connection = JDBUtils.getConnect();
			orders = getAllInstance(sql, connection);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBUtils.closeConnect(connection);
		}
		return orders;
	}

}
