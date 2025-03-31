package com.springBoot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userdetails")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private String phoneNumber;

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetails(int id, String name, String email, String password, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "userDetails [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
