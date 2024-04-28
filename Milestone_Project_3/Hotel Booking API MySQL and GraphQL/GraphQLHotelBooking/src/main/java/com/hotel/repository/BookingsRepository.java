package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entities.Bookings;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Integer>{

}
