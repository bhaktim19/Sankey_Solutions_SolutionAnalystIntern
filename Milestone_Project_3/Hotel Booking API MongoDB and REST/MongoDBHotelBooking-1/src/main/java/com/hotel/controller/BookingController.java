package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.collection.Bookings;
import com.hotel.service.BookingService;


@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping
	public String save(@RequestBody Bookings booking) {
		return bookingService.save(booking);
	}
	
	@GetMapping
	public List<Bookings> getBookingById(@RequestParam("bookingId") String bookingId){
		return bookingService.getBookingById(bookingId);
	}
	
	@DeleteMapping("/{id}")
	public String deleteBooking(@PathVariable String id) {
		bookingService.deleteBooking(id);
		return "Booking deleted successfully...";
	}
	


}
