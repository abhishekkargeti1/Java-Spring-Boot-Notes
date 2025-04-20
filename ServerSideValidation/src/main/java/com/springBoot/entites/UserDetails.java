package com.springBoot.entites;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDetails {

	@NotBlank(message="User name can not be empty ")
	@Size(min=3, max=12,message="User name must be between 3 - 12  characters !!")
	private String username;
	@NotBlank(message="Email should contain @ ")
	private String email;
	
	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetails(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDetails [username=" + username + ", email=" + email + "]";
	}
	
	
	
}
