package com.springBoot.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="newDetails")
public class Details {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message="Name Can't be Null")
	@Column(name="Name")
	@Size(min=3,message="Name can't be less than 3 letter")
	private String name;
	@NotBlank(message="Age Can't be Null")
	@Column(name="Age")
	private String age;	
	
	@OneToOne(mappedBy = "details",cascade = CascadeType.ALL)
	@JsonManagedReference
	@Valid
	private Address address;

	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Details(int id,
			@NotBlank(message = "Name Can't be Null") @Size(min = 3, message = "Name can't be less than 3 letter") String name,
			@NotBlank(message = "Age Can't be Null") String age, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Details [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	
	
	
	
}
