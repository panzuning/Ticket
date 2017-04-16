package com.ticket.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ticket.common.utils.JDBUtils;

public class DAO<T> {
	private Class<T> clazz = null;
	private QueryRunner runner = new QueryRunner();

	@SuppressWarnings("unchecked")
	public DAO() {
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		Type[] types = parameterizedType.getActualTypeArguments();
		this.clazz = (Class<T>) types[0];
	}

	public T getInstance(String sql, Connection connection, Object... args) {
		ResultSetHandler<T> rsh = new BeanHandler<>(clazz);
		T t = null;
		try {
			t = runner.query(connection, sql, rsh, args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	public List<T> getAllInstance(String sql, Connection connection, Object... args) {
		ResultSetHandler<List<T>> rsh = new BeanListHandler<>(clazz);
		List<T> list = null;
		try {
			list = runner.query(connection, sql, rsh, args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int updateData(String sql, Connection connection, Object... args) {

		int count = 0;
		try {
			count = runner.update(connection, sql, args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		return count;
	}
	
	@SuppressWarnings({ "unchecked" })
	public <E> E getValue(Connection connection, String sql, Object... args) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		E e = null;
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				e = (E) rs.getObject(1);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			JDBUtils.closeConnect(ps, rs);
		}
		return e;
	}
	
	
	/**
	 * 执行批处理Object [][]parem 第一维表示执行多少次 第二维传入每次需要的参数
	 * @param connection
	 * @param sql
	 * @param parem
	 * @return
	 */
	public int[] batch(Connection connection,String sql,Object [][]parem) {
		int[] batch = null;
		try {
			batch = runner.batch(connection, sql, parem);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		return batch;
	}
	
}
