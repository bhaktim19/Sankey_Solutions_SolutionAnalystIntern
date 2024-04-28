package com.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.Hotel;
import com.hotel.error.GlobalExceptionHandling;
import com.hotel.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	//Inject the object of HotelRepositoty
	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel saveHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public void deleteHotelById(Integer hotelId) throws GlobalExceptionHandling {
		
		Optional<Hotel> hob = hotelRepository.findById(hotelId);
		
		if(hob.isPresent()) {
			hotelRepository.deleteById(hotelId);
		}
		else {
			throw new GlobalExceptionHandling("Hotel with ID = "+hotelId+" not exists");
		}
		
	}

	@Override
	public Hotel updateHotelById(Integer hotelId, Hotel hotel) throws GlobalExceptionHandling {
		
		Optional<Hotel> hexistobj = hotelRepository.findById(hotelId);
		Hotel hob = null;
		
		if(hexistobj.isPresent()) {
			hob = hotelRepository.findById(hotelId).get();
			hob.setHotelName(hotel.getHotelName());
			hob.setCity(hotel.getCity());
			hob.setRating(hotel.getRating());
			return hotelRepository.save(hob);
		}
		
		throw new GlobalExceptionHandling("Hotel with ID = "+hotelId+" not exist");
		
	}

	@Override
	public Hotel getHotelByName(String name) {
		// TODO Auto-generated method stub
		return hotelRepository.findByHotelName(name);
	}

}
