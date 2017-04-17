package com.ticket.service;

import java.util.List;

import com.ticket.entites.User;

public interface UserService {

	public List<User> getAllUser(User user);

	public User getUserById(Integer userId);

	public void updateUser(User user);

	public void deleteUserById(Integer userId);

	public void addUser(User user);
}
