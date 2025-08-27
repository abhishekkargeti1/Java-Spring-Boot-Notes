package com.spring.security.JWT.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="xyz")
public class xyz {

	@Id
	int customer_id;
	String customer;
	String mode;
	String amount;
	
	public xyz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public xyz(int customer_id, String customer, String mode, String amount) {
		super();
		this.customer_id = customer_id;
		this.customer = customer;
		this.mode = mode;
		this.amount = amount;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "xyz [customer_id=" + customer_id + ", customer=" + customer + ", mode=" + mode + ", amount=" + amount
				+ "]";
	}
	
	
	
	
	
}
