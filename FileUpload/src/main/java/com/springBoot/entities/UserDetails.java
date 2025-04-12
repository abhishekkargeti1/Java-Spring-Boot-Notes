package com.springBoot.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private String status;
	private String empId;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetails(int id, String name, String email, String password, String status, String empId,
			Address address) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
		this.empId = empId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", status="
				+ status + ", empId=" + empId + ", address=" + address + "]";
	}
	
	
	
	
}
