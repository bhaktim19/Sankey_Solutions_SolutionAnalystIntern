package com.hotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dao.User;
import com.hotel.error.GlobalExceptionHandling;
import com.hotel.repository.UserRepository;
import com.hotel.service.UserService;

@RestController
public class UserController {
	
	//inject an object reference UserService interface
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	/*
	   http://localhost:8080/saveUser
	 */
	
	//insert record
	
	@PostMapping("/saveUser")
	public User saveUser(@Valid @RequestBody User user) {
		
		return userService.saveUser(user);
		
	}
	
	//getAllUSer
	// select * from user;
	// http://localhost:8080/getAllUser
	@GetMapping("/getAllUser")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	//getUserById
	// select * from user where userid = 1;
	// http://localhost:8080/getUserById/1
	
	@GetMapping("/getUserById/{uid}")
	public User getUserById(@PathVariable("uid") Integer userId)throws GlobalExceptionHandling{
		
		return userService.getUserById(userId);
		
	}
	
	//delete record by id
	// http://localhost:8080/deleteUserById/1
	@DeleteMapping("/deleteUserById/{uid}")
	public String deleteUserById(@PathVariable("uid") Integer userID) throws GlobalExceptionHandling{
		
		userService.deleteUserById(userID);
		return "User with ID = "+userID+" is deleted...";
		
	}
	
	//update record by id
	// http://localhost:8080/updateUserByID/1
	@PutMapping("/updateUserByID/{uid}")
	public User updateUserById(@PathVariable("uid") Integer userId,@RequestBody User user)throws GlobalExceptionHandling{
		return userService.updateUserById(userId, user);
	}
	
	//based on email ID
	// http://localhost:8080/getUserByEmail/emailid
	@GetMapping("/getUserByEmail/{email}")
	public User getUserByEmail(@PathVariable("email")String email) {
		return userService.getUserByEmail(email);
	}
	

}
