package com.hotel.service;

import com.hotel.dao.Room;
import com.hotel.error.GlobalExceptionHandling;

public interface RoomService {
	
	public Room saveRoom(Room room);
	
	public Room getRoomById(Integer roomId) throws GlobalExceptionHandling;
	
	public void deleteRoomByID(Integer roomId) throws GlobalExceptionHandling;
	
	public Room assignRoomToHotel(Integer roomId, Integer hotelId); 
	

}
