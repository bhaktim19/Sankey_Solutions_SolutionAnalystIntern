package com.hotel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.entities.Bookings;
import com.hotel.helper.ExceptionHelper;
import com.hotel.repository.BookingsRepository;

@Service
public class BookingsService {
	
	private BookingsRepository bookingsRepository;

	public BookingsService(BookingsRepository bookingsRepository) {
		this.bookingsRepository = bookingsRepository;
	}
	
	// create booking
	public Bookings createBooking(Bookings book) {
		return bookingsRepository.save(book);
	}
	
	// get all bookings
	public List<Bookings> getAllBookings(){
		return bookingsRepository.findAll();
	}
	
	// get single
	public Bookings getBooking(int bookingId) {
		Bookings book = bookingsRepository.findById(bookingId).orElseThrow(ExceptionHelper :: throwResourceNotFoundException);
		return book;
	}
	
	//delete booking
	public String deleteBooking(int bookingId) {
		Bookings book = bookingsRepository.findById(bookingId).orElseThrow(ExceptionHelper :: throwResourceNotFoundException);
		bookingsRepository.delete(book);
		return "Booking with ID = "+bookingId+" is deleted...";
	}
	
}
