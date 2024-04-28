package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roomId;
	
	private Integer occupancy;
	private float price;
	
	//Many rooms are under one hotel
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotelId",referencedColumnName = "hotelId")
	Hotel hotel;
	
	//One room many bookings
	@OneToMany(mappedBy = "room")
	List<Bookings> bob = new ArrayList<Bookings>();
	
	//getter setter for booking list
	public List<Bookings> getBob() {
		return bob;
	}

	public void setBob(List<Bookings> bob) {
		this.bob = bob;
	}

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Room(Integer occupancy, float price) {
		super();
		this.occupancy = occupancy;
		this.price = price;
	}
	
	

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(Integer occupancy) {
		this.occupancy = occupancy;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	// generate setter and getter method for hotel
	//when we want to create a reference
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", occupancy=" + occupancy + ", price=" + price + "]";
	}
	
	public void assignRoomToHotel(Hotel hotel2) {
		this.hotel=hotel2;
		
	}

}
