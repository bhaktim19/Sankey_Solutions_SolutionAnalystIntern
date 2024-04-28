package com.hotel.service;

import java.util.List;

import com.hotel.collection.User;

public interface UserService {

	String save(User user);

	List<User> getUserById(String userId);

	void deleteUser(String id);

}
