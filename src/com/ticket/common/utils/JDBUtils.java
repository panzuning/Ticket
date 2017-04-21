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
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnect() {
		InputStream is = null;
		Connection connection = null;
		try {
			//创建Properties对象，获取类路径下的properties文件
			Properties properties = new Properties();
			//根据文件名获取输入流
			is = JDBUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
			//加载
			properties.load(is);
			//根据文件中对应用的名称获取数据（比如：username=root）
			String driverClassName = properties.getProperty("driverClassName");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			//通过反射得到数据库管理驱动类，
			Class.forName(driverClassName);
			//通过驱动管理拿到数据连接链接
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//最后关闭流
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
