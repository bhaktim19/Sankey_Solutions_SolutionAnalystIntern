package com.hotel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.entities.User;
import com.hotel.helper.ExceptionHelper;
import com.hotel.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
		
	}
	
	// creating user
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	// getting all users
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	// getting single user
	public User getUser(int userId) {
		User user = userRepository.findById(userId).orElseThrow(ExceptionHelper :: throwResourceNotFoundException);
		return user;
	}
	
	// updating user
	// deleting user
	public String deleteUser(int userId) {
		User user = userRepository.findById(userId).orElseThrow(ExceptionHelper :: throwResourceNotFoundException);
		userRepository.delete(user);
		return "User with id = "+userId+" is deleted...";
	}
	
	

}
