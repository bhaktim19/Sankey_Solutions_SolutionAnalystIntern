package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hotelId;
	
	@Column(name="hotelName", length=50, nullable=false)
	@NotBlank(message="Hotel name cannot be blank or null")
	private String hotelName;
	
	@Column(name="city", length=50, nullable=false)
	@NotBlank(message="City cannot be blank or null")
	private String city;
	
	@Min(1)
	@Max(value=5, message="Maximum rating is 5")
	private Integer rating;
	
	//One hotel many rooms
	@OneToMany(mappedBy = "hotel")
	List<Room> rob = new ArrayList<Room>();

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Hotel(@NotBlank(message = "Hotel name cannot be blank or null") String hotelName,
			@NotBlank(message = "City cannot be blank or null") String city,
			@Min(1) @Max(value = 5, message = "Maximum rating is 5") Integer rating) {
		super();
		this.hotelName = hotelName;
		this.city = city;
		this.rating = rating;
	}

	

	public Integer getHotelId() {
		return hotelId;
	}



	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}



	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", city=" + city + ", rating=" + rating + "]";
	}

	//Generate setter and getter method for Room list
	public List<Room> getRob() {
		return rob;
	}

	public void setRob(List<Room> rob) {
		this.rob = rob;
	}	
	
	

}
