package com.ticket.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.ticket.common.utils.JDBUtils;
import com.ticket.dao.DAO;
import com.ticket.dao.LineDao;
import com.ticket.entites.Line;

public class LineDaoImpl extends DAO<Line> implements LineDao {

	@Override
	public List<Line> getAllLine(Line line) {
		String sql = "select tl.*,tc.car_num from t_line tl left join t_car tc on tl.car_id = tc.car_id where tl.data_statu = 0 ";
		if(line.getCar_num() != null && !"".equals(line.getCar_num())){
			sql += " and tc.car_num = '"+line.getCar_num() + "'";
		}
		if(line.getStart_station() != null && !"".equals(line.getStart_station())){
			sql += " and tl.start_station = '" + line.getStart_station() + "'";
		}
		if(line.getEnd_station() != null && !"".equals(line.getEnd_station())){
			sql += " and tl.end_station = '" + line.getEnd_station() + "'";
		}
		List<Line> lines = null;
		Connection connection = null;
		try {
			connection = JDBUtils.getConnect();
			lines = getAllInstance(sql, connection);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBUtils.closeConnect(connection);
		}
		return lines;
	}

	@Override
	public Line getLineById(int lineId) {
		String sql = "select tl.*,tc.car_num from t_line tl left join t_car tc on tl.car_id = tc.car_id where tl.data_statu = 0 and line_id = ?";
		Connection connection = null;
		Line line = null;
		try {
			connection = JDBUtils.getConnect();
			line = getInstance(sql, connection, lineId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBUtils.closeConnect(connection);
		}
		return line;
	}

	@Override
	public void updateLine(Line line) {
		String sql = "update t_line set start_station = ?,end_station = ?,start_time = ?,expected_time = ?,ticket_price = ?,ticket_num = ?,car_id = ? where line_id = ?";
		Connection connection = null;
		try {
			connection = JDBUtils.getConnect();
			updateData(sql, connection, line.getStart_station(),
					line.getEnd_station(), line.getStart_time(),
					line.getExpected_time(), line.getTicket_price(),
					line.getTicket_num(), line.getCar_id(), line.getLine_id());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBUtils.closeConnect(connection);
		}

	}

	@Override
	public void deleteLine(int lineId) {
		String sql = "update t_line set data_statu = 1 where line_id = ?";
		Connection connection = null;
		try {
			connection = JDBUtils.getConnect();
			updateData(sql, connection, lineId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBUtils.closeConnect(connection);
		}
	}

	@Override
	public void addLine(Line line) {
		String sql = "INSERT INTO t_line (start_station,end_station,start_time,expected_time,ticket_price,ticket_num,car_id,data_statu,create_time,update_time) values (?,?,?,?,?,?,?,?,?,?)";
		Connection connection = null;
		try {
			connection = JDBUtils.getConnect();
			updateData(sql, connection, line.getStart_station(),
					line.getEnd_station(), line.getStart_time(),
					line.getExpected_time(), line.getTicket_price(),
					line.getTicket_num(), line.getCar_id(), 0,new Date(),new Date());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBUtils.closeConnect(connection);
		}
	}

}
