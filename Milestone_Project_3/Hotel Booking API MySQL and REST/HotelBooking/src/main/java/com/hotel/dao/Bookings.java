package com.hotel.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bookings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	@Column(name="bookingStatus", length=50, nullable=false)
	@NotBlank(message="Booking Status cannot be blank or null")
	private String bookingStatus;
	
	
	
	
	public Integer getBookingId() {
		return bookingId;
	}




	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}




	public String getBookingStatus() {
		return bookingStatus;
	}




	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}




	public Bookings(@NotBlank(message = "Booking Status cannot be blank or null") String bookingStatus) {
		super();
		this.bookingStatus = bookingStatus;
	}




	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}




	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId",referencedColumnName = "userId")
	User user;




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}
	
	public void assignUserToBooking(User user2) {
		this.user=user2;
		
	}
	
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "roomId",referencedColumnName = "roomId")
	Room room;




	public Room getRoom() {
		return room;
	}




	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	public void assignBookingsToRoom(Room room2) {
		this.room=room2;
		
	}
	
	public void assignBookingsToUser(User user2) {
		this.user=user2;
		
	}
	

}
