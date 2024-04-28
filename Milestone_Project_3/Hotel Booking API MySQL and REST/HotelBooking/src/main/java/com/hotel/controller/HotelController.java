package com.hotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.dao.Hotel;
import com.hotel.error.GlobalExceptionHandling;
import com.hotel.repository.HotelRepository;
import com.hotel.service.HotelService;

@RestController
public class HotelController {
	
	//inject an object reference HotelService interface
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	//insert record
	// http://localhost:8080/saveHotel
	
	@PostMapping("/saveHotel")
	public Hotel saveHotel(@Valid @RequestBody Hotel hotel) {
		
		return hotelService.saveHotel(hotel);
		
	}
	
	//get all hotels
	// select * from hotel;
	// http://localhost:8080/getAllHotels
	@GetMapping("/getAllHotels")
	public List<Hotel> getAllHotels(){
		return hotelService.getAllHotels();
	}
	
	//delete hotel by id
	// http://localhost:8080/deleteHotelById/1
	
	@DeleteMapping("/deleteHotelById/{hid}")
	public String deleteHotelById(@PathVariable("hid") Integer hotelId) throws GlobalExceptionHandling{
		
		hotelService.deleteHotelById(hotelId);
		return "Hotel with ID = "+hotelId+" is deleted.....";
	}
	
	//update record by id
	// http://localhost:8080/updateHotelById/1
	
	@PutMapping("/updateHotelById/{hid}")
	public Hotel updateHotelById(@PathVariable("hid") Integer hotelId, @RequestBody Hotel hotel) throws GlobalExceptionHandling{
		return hotelService.updateHotelById(hotelId, hotel);
	}
	
	
	//based on name
	// http://localhost:8080/getHotelByName/name
	
	@GetMapping("/getHotelByName/{name}")
	public Hotel getHotelByName(@PathVariable("name") String name) {
		
		return hotelService.getHotelByName(name);
		
	}
	
	
	
	
	
	
	

}
