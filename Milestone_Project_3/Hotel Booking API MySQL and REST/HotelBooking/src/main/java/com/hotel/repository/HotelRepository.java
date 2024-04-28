package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hotel.dao.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{
	
	public Hotel findByHotelName(String hname);

}
