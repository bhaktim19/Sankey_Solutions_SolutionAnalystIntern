package com.hotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="firstName", length=50, nullable=false)
	@NotBlank(message="User's first name cannot be blank or null")
	private String firstName;
	
	@Column(name="lastName", length=50, nullable=false)
	@NotBlank(message="User's last name cannot be blank or null")
	private String lastName;
	
	@Column(name="email", length = 50, nullable = false, unique = true)
	@NotBlank(message="Email cannot be blank or null")
	//@Email (message="Enter valid email") //will check for @ and . symol
	@Email(message = "Enter valid Email", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	private String userEmail;
	
	@NotBlank(message="Phone number cannot be blank or null")
	@Pattern(message = "Invalid Phone Number", regexp = "^[1-9]\\d{9}$") //no starts from 1, no of digits should be 10
	private String phoneNo;
	
	//One user many bookings
	@OneToMany(mappedBy = "user")
	List<Bookings> bob = new ArrayList<Bookings>();
	
	//getter setter for booking list
	public List<Bookings> getBob() {
		return bob;
	}

	public void setBob(List<Bookings> bob) {
		this.bob = bob;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User(@NotBlank(message = "User's first name cannot be blank or null") String firstName,
			@NotBlank(message = "User's last name cannot be blank or null") String lastName,
			@NotBlank(message = "Email cannot be blank or null") @Email(message = "Enter valid Email", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}") String userEmail,
			@NotBlank(message = "Phone number cannot be blank or null") @Pattern(message = "Invalid Phone Number", regexp = "^[1-9]\\d{9}$") String phoneNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.phoneNo = phoneNo;
	}
	
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String email) {
		this.userEmail = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + userEmail
				+ ", phoneNo=" + phoneNo + "]";
	}
	
	

}
