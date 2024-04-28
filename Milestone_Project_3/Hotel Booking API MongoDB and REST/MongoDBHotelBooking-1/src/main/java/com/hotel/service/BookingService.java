package com.hotel.service;

import java.util.List;

import com.hotel.collection.Bookings;

public interface BookingService {

	String save(Bookings booking);

	List<Bookings> getBookingById(String bookingId);

	void deleteBooking(String id);

	

	

}
