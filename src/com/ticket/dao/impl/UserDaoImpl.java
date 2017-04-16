package com.ticket.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import com.ticket.common.utils.JDBUtils;
import com.ticket.dao.DAO;
import com.ticket.dao.UserDao;
import com.ticket.entites.User;

public class UserDaoImpl extends DAO<User> implements UserDao {

	@Override
	public List<User> getAllUser() {
		String sql = "select * from t_user where data_statu = 0";
		List<User> users = null;
		Connection connection = null;
		try {
			connection = JDBUtils.getConnect();
			users = getAllInstance(sql, connection);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBUtils.closeConnect(connection);
		}
		return users;
	}

	@Override
	public User getUserById(Integer userId) {
		String sql = "select * from t_user where data_statu = 0 and user_id = ?";
		User user = null;
		Connection connection = null;
		try {
			connection = JDBUtils.getConnect();
			user = getInstance(sql, connection, userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBUtils.closeConnect(connection);
		}
		return user;
	}

	@Override
	public void updateUser(User user) {
		String sql = "update t_user set user_name = ?,user_pwd = ?,user_phone=?,user_email=?,user_address=?,admin_flag=? where user_id = ?";
		Connection connection = null;
		try {
			connection = JDBUtils.getConnect();
			updateData(sql, connection, user.getUser_name(),
					user.getUser_pwd(), user.getUser_phone(),
					user.getUser_email(), user.getUser_address(),
					user.getAdmin_flag(), user.getUser_id());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBUtils.closeConnect(connection);
		}
	}

	@Override
	public void deleteUserById(Integer userId) {
		String sql = "update t_user set data_statu = 1 and user_id = ?";
		Connection connection = null;
		try {
			connection = JDBUtils.getConnect();
			updateData(sql, connection, userId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBUtils.closeConnect(connection);
		}
	}

	@Override
	public void addUser(User user) {
		String sql = "insert into  t_user (user_name,user_pwd,user_phone,user_email,user_address,admin_flag,data_statu,create_time,update_time) values (?,?,?,?,?,?,?,?,?)";
		Connection connection = null;
		try {
			connection = JDBUtils.getConnect();
			updateData(sql, connection, user.getUser_name(),
					user.getUser_pwd(), user.getUser_phone(),
					user.getUser_email(), user.getUser_address(),
					user.getAdmin_flag(),0,new Date(),new Date());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBUtils.closeConnect(connection);
		}
	}

}
