package com.hotel.service;

import java.util.List;

import com.hotel.dao.User;
import com.hotel.error.GlobalExceptionHandling;

public interface UserService {
	
	public User saveUser (User user);
	
	public List<User> getAllUser();
	
	public User getUserById(Integer userId)throws GlobalExceptionHandling;
	
	public void deleteUserById(Integer userId)throws GlobalExceptionHandling;
	
	public User updateUserById(Integer userId, User user) throws GlobalExceptionHandling;
	
	public User getUserByEmail(String email);
	
}
