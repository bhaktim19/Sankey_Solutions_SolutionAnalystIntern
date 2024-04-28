package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.collection.User;
import com.hotel.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/save")
	public String save(@RequestBody User user) {
		return userService.save(user);
	}
	
	@GetMapping
	public List<User> getUserById(@RequestParam("userId") String userId){
		return userService.getUserById(userId);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser( @PathVariable String id) {
		userService.deleteUser(id);
		return "User deleted successfully...";
	}
}
