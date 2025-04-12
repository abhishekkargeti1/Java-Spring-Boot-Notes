package com.springBoot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String street;
	private String state;
	private String pinCode;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int id, String street, String state, String pinCode) {
		super();
		this.id = id;
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
		return "Address [id=" + id + ", street=" + street + ", state=" + state + ", pinCode=" + pinCode + "]";
	}
	
	
	
	
}
