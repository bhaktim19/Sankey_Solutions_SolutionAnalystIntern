package com.hotel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dao.Bookings;
import com.hotel.dao.User;
import com.hotel.error.GlobalExceptionHandling;
import com.hotel.service.BookingService;

@RestController
public class BookingsController {

	//inject an object reference BookingsService interface
	
	@Autowired
	private BookingService bookingService;
	
	// http://localhost:8080/saveBooking
	//insert record
	
	@PostMapping("/saveBooking")
	public Bookings saveBooking(@Valid @RequestBody Bookings bookings) {
		return bookingService.saveBooking(bookings);
	}
	
	//get booking by ID
	// http://localhost:8080/getBookingById
	@GetMapping("/getBookingById/{bid}")
	public Bookings getBookingById(@PathVariable("bid") Integer bookingId) throws GlobalExceptionHandling{
		return bookingService.getBookingById(bookingId);
	}
	
	//delete record by id
	// http://localhost:8080/deleteBookingById/3
	@DeleteMapping("/deleteBookingById/{bid}")
	public String deleteBookingById(@PathVariable("bid") Integer bookingId) throws GlobalExceptionHandling{
		bookingService.deleteBookingByID(bookingId);
		return "Booking with ID = "+bookingId+" not exists";
	}
	
	
	//assign booking to particular user
	
	// http://localhost:8080/assignBooking/1/user/2
	
	@PutMapping("/assignBooking/{bid}/user/{uid}")
	public Bookings assignBookingsToUser(@PathVariable("bid") Integer bookingId, @PathVariable("uid") Integer userId) {
		
		return bookingService.assignBookingsToUser(bookingId, userId);
		
	}
	
	//assign booking to particular room
	// http://localhost:8080/assignBooking/1/room/2
	
	@PutMapping("/assignBooking/{bid}/room/{rid}")
	public Bookings assignBookingsToRoom(@PathVariable("bid") Integer bookingId, @PathVariable("rid") Integer roomId) {
		
		return bookingService.assignBookingsToRoom(bookingId, roomId);
		
	}
	

}
