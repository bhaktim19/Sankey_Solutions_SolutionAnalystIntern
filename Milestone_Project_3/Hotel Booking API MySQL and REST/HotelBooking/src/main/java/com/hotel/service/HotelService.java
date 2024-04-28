package com.hotel.service;

import java.util.List;

import com.hotel.dao.Hotel;
import com.hotel.error.GlobalExceptionHandling;

public interface HotelService {
	
	public Hotel saveHotel(Hotel hotel);
	
	public List<Hotel> getAllHotels();

	public void deleteHotelById(Integer hotelId) throws GlobalExceptionHandling;
	
	public Hotel updateHotelById(Integer hotelId, Hotel hotel)throws GlobalExceptionHandling;
	
	public Hotel getHotelByName(String name);
}
