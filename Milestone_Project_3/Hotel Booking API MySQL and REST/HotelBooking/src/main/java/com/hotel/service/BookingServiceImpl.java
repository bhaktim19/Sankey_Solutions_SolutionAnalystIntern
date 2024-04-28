package com.hotel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.Bookings;
import com.hotel.dao.Room;
import com.hotel.dao.User;
import com.hotel.error.GlobalExceptionHandling;
import com.hotel.repository.BookingsRepository;
import com.hotel.repository.RoomRepository;
import com.hotel.repository.UserRepository;
@Service
public class BookingServiceImpl implements BookingService {

	// inject the object of BookingsRepository
	
	@Autowired
	private BookingsRepository bookingsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoomRepository roomRepository;  
	
	@Override
	public Bookings saveBooking(Bookings bookings) {
		// TODO Auto-generated method stub
		return bookingsRepository.save(bookings);
	}

	@Override
	public Bookings getBookingById(Integer bookingId) throws GlobalExceptionHandling {
		
		Optional<Bookings> bob = bookingsRepository.findById(bookingId);
		
		if(bob.isPresent()) {
			return bookingsRepository.findById(bookingId).get();
		}
		
		throw new GlobalExceptionHandling("Booking with ID = "+bookingId+" not exists");
	}

	@Override
	public void deleteBookingByID(Integer bookingId) throws GlobalExceptionHandling {
		
		Optional<Bookings> bob = bookingsRepository.findById(bookingId);
		
		if(bob.isPresent()) {
			bookingsRepository.deleteById(bookingId);
		}
		else {
			throw new GlobalExceptionHandling("Booking with ID = "+bookingId+" not exists");
		}
		
	}

	@Override
	public Bookings assignBookingsToUser(Integer bookingId, Integer userId) {
		
		//get booking by id
		//get user by id
		
		Bookings booking = bookingsRepository.findById(bookingId).get();
		User user = userRepository.findById(userId).get();
		
		booking.assignBookingsToUser(user);
		
		return bookingsRepository.save(booking);
		
		
	}

	@Override
	public Bookings assignBookingsToRoom(Integer bookingId, Integer roomId) {
		//get booking by id
		//get room by id
		
		Bookings booking = bookingsRepository.findById(bookingId).get();
		Room room = roomRepository.findById(roomId).get();
		
		booking.assignBookingsToRoom(room);
		
		return bookingsRepository.save(booking);
		
	}


	
	


}
