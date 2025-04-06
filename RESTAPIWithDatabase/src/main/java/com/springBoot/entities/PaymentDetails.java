package com.springBoot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Book Id")
	private Integer id;
	@Column(name="Bank Name")
	private String bankName;
	@Column(name="Amount")
	private int amount;
	@Column(name="Amount in Words")
	private String amountInWords;
	@Column(name="Sender Name")
	private String senderName;
	@Column(name="Reciver Name")
	private String reciverName;
	
	public PaymentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentDetails( String bankName, int amount, String amountInWords, String senderName,
			String reciverName) {
		super();
		this.bankName = bankName;
		this.amount = amount;
		this.amountInWords = amountInWords;
		this.senderName = senderName;
		this.reciverName = reciverName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getAmountInWords() {
		return amountInWords;
	}

	public void setAmountInWords(String amountInWords) {
		this.amountInWords = amountInWords;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReciverName() {
		return reciverName;
	}

	public void setReciverName(String reciverName) {
		this.reciverName = reciverName;
	}

	@Override
	public String toString() {
		return "PaymentDetails [id=" + id + ", bankName=" + bankName + ", amount=" + amount + ", amountInWords="
				+ amountInWords + ", senderName=" + senderName + ", reciverName=" + reciverName + "]";
	}
	
	
	
	
	
}
