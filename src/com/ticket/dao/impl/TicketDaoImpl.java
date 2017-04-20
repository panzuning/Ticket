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
		String sql = "insert into t_ticket (lineid,rider,riderphone,orderid,data_statu,create_time,update_time) values (?,?,?,?,?,?,?)";
		Connection connection = null;
		try {
			connection = JDBUtils.getConnect();
			updateData(sql, connection, ticket.getLineId(),ticket.getRider(),ticket.getRiderphone(),ticket.getOrderId(),0,new Date(),new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBUtils.closeConnect(connection);
		}
		
	}

	@Override
	public List<Ticket> getAllTicket(Ticket ticket) {
		String sql = "select t.*,l.car_num,l.start_station,l.end_station,l.ticket_price,l.pay_statu from t_ticket t,t_line l left join t.lineid = l.line_id where data_statu = 0 ";
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
