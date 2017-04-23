package com.ticket.common.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBUtils {
	
	private static ThreadLocal<Connection> local = new ThreadLocal<>();
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnect() {
		Connection connection = null;
		try {
			String driverClassName = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/ticket";
			String username = "root";
			String password = "root";
			//通过反射得到数据库管理驱动类，
			Class.forName(driverClassName);
			//通过驱动管理拿到数据连接链接
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return connection;
	}

	/**
	 * 关闭连接
	 * @param st
	 * @param rs
	 */
	public static void closeConnect(Statement st, ResultSet rs) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭连接
	 * @param st
	 * @param rs
	 * @param connection
	 */
	public static void closeConnect(Statement st, ResultSet rs, Connection connection) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 关闭连接
	 * @param connection
	 */
	public static void closeConnect(Connection connection) {
//		Thread currentThread = Thread.currentThread();
//		long id = currentThread.getId();
		if (connection != null) {
			try {
				connection.close();
				//map.remove(id);
				local.remove();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		local.remove();
	}
	
}
