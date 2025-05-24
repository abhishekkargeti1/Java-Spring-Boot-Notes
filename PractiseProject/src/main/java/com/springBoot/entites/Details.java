package com.springBoot.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Details1")
public class Details {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "Name")
	@NotBlank(message = "Name should not be Blank")
	private String name;
	@Column(name = "Address")
	@NotBlank(message = "Address should not be Blank")
	private String address;
	@Column(name = "Status")
	@NotBlank(message = "Status should not be Blank")
	private String status;

	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Details( @NotBlank(message = "Name should not be Blank") String name,
			@NotBlank(message = "Address should not be Blank") String address,
			@NotBlank(message = "Status should not be Blank") String status) {
		super();
		
		this.name = name;
		this.address = address;
		this.status = status;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Details [id=" + id + ", name=" + name + ", address=" + address + ", status=" + status + "]";
	}

}
