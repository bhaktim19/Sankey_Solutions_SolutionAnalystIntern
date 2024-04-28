package com.hotel.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hotel.dao.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUserEmail(String email);

}
