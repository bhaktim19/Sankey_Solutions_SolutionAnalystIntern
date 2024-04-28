package com.hotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.collection.Bookings;
import com.hotel.collection.User;
import com.hotel.repository.BookingRepository;
import com.hotel.repository.UserRepository;


@Service
public class BookingserviceImpl implements BookingService{

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String save(Bookings booking) {
		// TODO Auto-generated method stub
		bookingRepository.save(booking);
		return "Booking details saved successfully";
	}

	@Override
	public List<Bookings> getBookingById(String bookingId) {
		// TODO Auto-generated method stub
		return bookingRepository.findByBookingId(bookingId);
	}

	@Override
	public void deleteBooking(String id) {
		// TODO Auto-generated method stub
		bookingRepository.deleteById(id);
		
	}


}
