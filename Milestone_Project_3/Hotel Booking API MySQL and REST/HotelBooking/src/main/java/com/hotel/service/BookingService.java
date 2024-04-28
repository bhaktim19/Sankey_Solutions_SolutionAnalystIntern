package com.hotel.service;


import com.hotel.dao.Bookings;
import com.hotel.dao.User;
import com.hotel.error.GlobalExceptionHandling;

public interface BookingService {
	
	public Bookings saveBooking(Bookings bookings);
	
	public Bookings getBookingById(Integer bookingId) throws GlobalExceptionHandling;
	
	public void deleteBookingByID(Integer bookingId) throws GlobalExceptionHandling;
	
	public Bookings assignBookingsToUser(Integer bookingId, Integer userId);
	
	public Bookings assignBookingsToRoom(Integer bookingId, Integer roomId);
	
	
}
