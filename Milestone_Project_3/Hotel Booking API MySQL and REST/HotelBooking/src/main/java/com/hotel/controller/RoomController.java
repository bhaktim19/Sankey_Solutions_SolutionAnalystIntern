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

import com.hotel.dao.Room;
import com.hotel.error.GlobalExceptionHandling;
import com.hotel.service.RoomService;

@RestController
public class RoomController {
	
	//inject the object ref of RoomService interface
	
	@Autowired
	private RoomService roomService;

	//insert record
	// http://localhost:8080/saveRoom
	
	@PostMapping("/saveRoom")
	public Room saveRoom(@Valid @RequestBody Room room) {
		
		return roomService.saveRoom(room);
		
	}
	
	//getRoomById
	// http://localhost:8080/getRoomById/1
	
	@GetMapping("/getRoomById/{rid}")
	public Room getRoomById(@PathVariable("rid") Integer roomId)throws GlobalExceptionHandling{
		
		return roomService.getRoomById(roomId);
		
	}
	
	//delete record by ID
	// http://localhost:8080/deleteRoomById/1
	
	@DeleteMapping("/deleteRoomById/{rid}")
	public String deleteRoomById(@PathVariable("rid") Integer roomId) throws GlobalExceptionHandling{
		
		roomService.deleteRoomByID(roomId);
		return "Room with ID = "+roomId+" is deleted...";
	}
	
	// http://localhost:8080/assignRoom/1/hotel/2
	@PutMapping("/assignRoom/{rid}/hotel/{hid}")
	public Room assignRoomToHotel(@PathVariable("rid") Integer roomId, @PathVariable("hid") Integer hotelId ) {
		return roomService.assignRoomToHotel(roomId, hotelId);
	}
}
