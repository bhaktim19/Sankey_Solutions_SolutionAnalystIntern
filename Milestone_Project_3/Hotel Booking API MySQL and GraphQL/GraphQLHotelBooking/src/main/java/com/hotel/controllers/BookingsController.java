package com.hotel.controllers;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.hotel.entities.Bookings;
import com.hotel.entities.User;
import com.hotel.services.BookingsService;
import com.hotel.services.UserService;

@Controller
public class BookingsController {
	
	private UserService userService;
	private BookingsService bookingsService;
	
	public BookingsController(UserService userService, BookingsService bookingsService) {
		this.userService = userService;
		this.bookingsService = bookingsService;
	}
	
	// create booking
	@MutationMapping
	public Bookings createBooking(
		@Argument	String hotelName,
		@Argument	String address,
		@Argument	int price,
		@Argument	int userId) {
		
		User user = userService.getUser(userId);
		
		Bookings book = new Bookings();
		book.setHotelName(hotelName);
		book.setAddress(address);
		book.setPrice(price);
		book.setUser(user);;
		
		Bookings book1 =  bookingsService.createBooking(book);
		return book1;
	}
	
	// get bookings
	@QueryMapping
	public List<Bookings> getBookings(){
		return bookingsService.getAllBookings();
	}
	
	//get booking
	@QueryMapping
	public Bookings getBooking(@Argument int bookingId) {
		return bookingsService.getBooking(bookingId);
	}
	
	//delete booking
	@MutationMapping 
	public String deleteBooking(@Argument int bookingId) {
		return bookingsService.deleteBooking(bookingId);
	}
}
