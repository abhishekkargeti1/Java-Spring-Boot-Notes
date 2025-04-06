package com.springBoot.entities;

public class PaymentDetails {

	private int id;
	private String bankName;
	private int amount;
	private String amountInWords;
	private String senderName;
	private String reciverName;
	
	public PaymentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentDetails(int id, String bankName, int amount, String amountInWords, String senderName,
			String reciverName) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.amount = amount;
		this.amountInWords = amountInWords;
		this.senderName = senderName;
		this.reciverName = reciverName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
