package com.ticket.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBUtils {
	
	private static ThreadLocal<Connection> local = new ThreadLocal<>();
	
	public static Connection getConnect() {
		InputStream is = null;
		Connection connection = null;
		try {
			Properties properties = new Properties();
			is = JDBUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
			properties.load(is);
			String driverClassName = properties.getProperty("driverClassName");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			Class.forName(driverClassName);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return connection;
	}

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
	
	
	//通过C3P0创建连接
	static ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("helloc3p0");
	public static Connection getConnectByC3P0(){
//		Thread currentThread = Thread.currentThread();
//		long id = currentThread.getId();
		Connection connection = null;
		try {
			//connection = map.get(id);
			if (connection == null) {
				connection = comboPooledDataSource.getConnection();
				//map.put(id, connection);
				local.set(connection);
			}
			connection = local.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
