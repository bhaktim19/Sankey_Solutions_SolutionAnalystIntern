package com.hotel.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.collection.Bookings;

@Repository
public interface BookingRepository extends MongoRepository<Bookings, String> {

	List<Bookings> findByBookingId(String bookingId);

}
