package com.springBoot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@NotBlank(message="Please Enter Your First Name")
	@Size(min = 2, message ="First Name Should be more than of 2 letter")
	@Column(name="First Name")
	String firstName;
	@NotBlank(message="Please Enter Your Last Name")
	@Size(min = 2, message ="Last Name Should be more than of 2 letter")
	@Column(name="Last Name")
	String lastName;
	@NotBlank(message="Please Enter Your Email")
	@Email
	@Column(name="Email",unique = true)
	String email;
	@NotBlank(message="Please Enter Your Contact Number")
	@Size(max = 10, message ="Phone Number should be of 10 Digits")
	@Column(name="Contact Number")
	String phoneNumber;
	@NotBlank(message="Please Select Your Gender")
	@Column(name="Gender")
	String gender;
	@Column(name="Description")
	String description;
	
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetails(int id, String firstName, String lastName, String email, String phoneNumber, String gender,
			String description) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", description=" + description + "]";
	}
	
	
	
	
}
