package com.hotel.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.collection.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	List<User> findByUserId(String userId);
}
