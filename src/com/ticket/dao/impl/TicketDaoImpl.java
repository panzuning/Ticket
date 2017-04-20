package com.ticket.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.ticket.dao.DAO;
import com.ticket.dao.TicketDao;
import com.ticket.entites.Ticket;
import com.ticket.common.utils.*;

public class TicketDaoImpl extends DAO<Ticket> implements TicketDao{

	@Override
	public void addTicket(Ticket ticket) {
		String sql = "insert into t_ticket (lineid,rider,riderphone,orderid,data_statu,create_time,update_time,drawticket) values (?,?,?,?,?,?,?,?)";
		Connection connection = null;
		try {
			connection = JDBUtils.getConnect();
			updateData(sql, connection, ticket.getLineId(),ticket.getRider(),ticket.getRiderphone(),ticket.getOrderId(),0,new Date(),new Date(),0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBUtils.closeConnect(connection);
		}
		
	}

	@Override
	public List<Ticket> getAllTicket(Ticket ticket) {
		String sql = "select t.ticketid ticketId,t.lineid lineId,t.rider,t.riderphone,t.orderid orderId,t.drawticket drawTicket,c.car_num carNum,l.start_station startStation,l.end_station endStation,l.ticket_price ticketPrice,o.pay_statu payStatu from t_ticket t  left join t_line l on t.lineid = l.line_id left join t_car c on c.car_id = l.car_id left join t_order o on o.orderid = t.orderid where t.data_statu = 0 ";
		Connection connection = null;
		List<Ticket> tickets = null;
		try {
			connection = JDBUtils.getConnect();
			tickets = getAllInstance(sql, connection);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBUtils.closeConnect(connection);
		}
		return tickets;
	}

}
