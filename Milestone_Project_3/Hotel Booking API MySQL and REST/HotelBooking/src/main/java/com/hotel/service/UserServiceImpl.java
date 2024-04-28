package com.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.User;
import com.hotel.error.GlobalExceptionHandling;
import com.hotel.repository.BookingsRepository;
import com.hotel.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	//Inject the object of UserRepositoty
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookingsRepository bookingsRepository;
	
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserById(Integer userId) throws GlobalExceptionHandling {
		Optional<User> uob = userRepository.findById(userId);
		
		if(uob.isPresent()) {
			return userRepository.findById(userId).get();
		}
		
		throw new GlobalExceptionHandling("User with ID = "+userId+" not exists");
		
		//return userRepository.findById(userId).get();
	}

	@Override
	public void deleteUserById(Integer userId) throws GlobalExceptionHandling {
		
		Optional<User> uob = userRepository.findById(userId);
		
		if(uob.isPresent()) {
			userRepository.deleteById(userId);
		}
		else {
			throw new GlobalExceptionHandling("User with ID = "+userId+" not exists");
		}
		
	}

	@Override
	public User updateUserById(Integer userId, User user) throws GlobalExceptionHandling {
		
		Optional<User> uexistobj = userRepository.findById(userId);
		User uob = null;
		
		if(uexistobj.isPresent()) {
			uob = userRepository.findById(userId).get();
			uob.setFirstName(user.getFirstName());
			uob.setLastName(user.getLastName());
			uob.setUserEmail(user.getUserEmail());
			uob.setPhoneNo(user.getPhoneNo());
			return userRepository.save(uob);
		}
		
		throw new GlobalExceptionHandling("User with ID = "+userId+" not exists");
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByUserEmail(email);
	}


	
	

}
