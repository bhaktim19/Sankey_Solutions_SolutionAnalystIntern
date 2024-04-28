package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.collection.User;
import com.hotel.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String save(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		return "User details saved successfully";
	}

	@Override
	public List<User> getUserById(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findByUserId(userId);
	}

	@Override
	public void deleteUser(String id) {
		
		userRepository.deleteById(id); 
		
	}

}
