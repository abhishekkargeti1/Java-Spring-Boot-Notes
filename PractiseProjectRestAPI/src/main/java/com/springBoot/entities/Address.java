package com.springBoot.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="newAddress")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@NotBlank(message="State can't be null")
	@Size(min=3,message="State can't be less than 3 letters")
	private String state;
	@NotBlank(message="City can't be null")
	@Size(min=3,message="City can't be less than 3 letters")
	private String city;
	@NotBlank(message="Street can't be null")
	@Size(min=3,message="Street can't be less than 3 letters")
	private String street;
	
	@OneToOne
	@JsonBackReference
	@JoinColumn(name = "details_id")
	private Details details;
	
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(
			@NotBlank(message = "State can't be null") @Size(min = 3, message = "State can't be less than 3 letters") String state,
			@NotBlank(message = "City can't be null") @Size(min = 3, message = "City can't be less than 3 letters") String city,
			@NotBlank(message = "Street can't be null") @Size(min = 3, message = "Street can't be less than 3 letters") String street) {
		super();
		this.state = state;
		this.city = city;
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", street=" + street + "]";
	}
	
	
	
}
