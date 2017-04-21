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

/**
 * 通用工具类
 * @author Administrator
 *
 * @param <T>
 */
public class DAO<T> {
	
	private Class<T> clazz = null;
	//数据库查询通用的工具类，内部实现不需要了解，会用里面的方法就行
	private QueryRunner runner = new QueryRunner();

	@SuppressWarnings("unchecked")
	public DAO() {
		//构造方法里，通过反射获取子类中的范型
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		Type[] types = parameterizedType.getActualTypeArguments();
		this.clazz = (Class<T>) types[0];
	}

	/**
	 * 获取单个对象的通用方法
	 * @param sql
	 * @param connection
	 * @param args
	 * @return
	 */
	public T getInstance(String sql, Connection connection, Object... args) {
		//需要封装的类型
		ResultSetHandler<T> rsh = new BeanHandler<>(clazz);
		T t = null;
		try {
			//调用工具类的查询方法
			t = runner.query(connection, sql, rsh, args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * 获取所有的实体类的方法，返回一个集合
	 * @param sql
	 * @param connection
	 * @param args
	 * @return list集合
	 */
	public List<T> getAllInstance(String sql, Connection connection, Object... args) {
		//需要封装的类型，是一个集合类型List<T>
		ResultSetHandler<List<T>> rsh = new BeanListHandler<>(clazz);
		List<T> list = null;
		try {
			//调用工具类中的查询方法
			list = runner.query(connection, sql, rsh, args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 更新数据操作，添加也是更新的一种，所以添加更新都要调用这个方法
	 * @param sql
	 * @param connection
	 * @param args
	 * @return
	 */
	public int updateData(String sql, Connection connection, Object... args) {
		int count = 0;
		try {
			//调用工具类的更新操作
			count = runner.update(connection, sql, args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		return count;
	}
	
}
