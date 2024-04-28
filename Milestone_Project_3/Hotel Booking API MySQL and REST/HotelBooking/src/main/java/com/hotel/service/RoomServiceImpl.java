package com.hotel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.Hotel;
import com.hotel.dao.Room;
import com.hotel.error.GlobalExceptionHandling;
import com.hotel.repository.HotelRepository;
import com.hotel.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	//inject the object of RoomRepository
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Room saveRoom(Room room) {
		// TODO Auto-generated method stub
		return roomRepository.save(room);
	}

	@Override
	public Room getRoomById(Integer roomId) throws GlobalExceptionHandling {
		Optional<Room> rob = roomRepository.findById(roomId);
		
		if(rob.isPresent()) {
			return roomRepository.findById(roomId).get();
		}
		
		throw new GlobalExceptionHandling("Room with ID = "+roomId+" not exists");
	}

	@Override
	public void deleteRoomByID(Integer roomId) throws GlobalExceptionHandling {
		
		Optional<Room> rob = roomRepository.findById(roomId);
		
		if(rob.isPresent()) {
			roomRepository.deleteById(roomId);
		}
		else {
			throw new GlobalExceptionHandling("Room with ID = "+roomId+" not exists");
		}
		
	}

	@Override
	public Room assignRoomToHotel(Integer roomId, Integer hotelId) {
		
		//get room by id
		//get hotel by id
		
		Room room = roomRepository.findById(roomId).get();
		Hotel hotel = hotelRepository.findById(hotelId).get();
		
		room.assignRoomToHotel(hotel);
		
		return roomRepository.save(room);
		
	}

}
