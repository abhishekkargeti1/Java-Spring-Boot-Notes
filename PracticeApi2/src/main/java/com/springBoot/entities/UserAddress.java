package com.springBoot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String city;
	private String street;
	private String state;
	private String pinCode;
	
	public UserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAddress(int id, String city, String street, String state, String pinCode) {
		super();
		this.id = id;
		this.city = city;
		this.street = street;
		this.state = state;
		this.pinCode = pinCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", city=" + city + ", street=" + street + ", state=" + state + ", pinCode="
				+ pinCode + "]";
	}

	
	
}
