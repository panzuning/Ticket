package com.ticket.service.impl;

import java.util.List;

import com.ticket.dao.UserDao;
import com.ticket.dao.impl.UserDaoImpl;
import com.ticket.entites.User;
import com.ticket.service.UserService;

/**
 * 
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService{

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public List<User> getAllUser(User user) {
		return userDao.getAllUser(user);
	}

	@Override
	public User getUserById(Integer userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUserById(Integer userId) {
		userDao.deleteUserById(userId);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
		
	}

}
