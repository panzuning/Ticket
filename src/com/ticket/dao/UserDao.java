package com.ticket.dao;

import java.util.List;

import com.ticket.entites.User;

public interface UserDao {
	
	public List<User> getAllUser(User user);

	public User getUserById(Integer userId);

	public void updateUser(User user);

	public void deleteUserById(Integer userId);

	public void addUser(User user);

	public User getUserByName(String username);

}
