package com.springBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springBoot.entities.PaymentDetails;

@Service
public class ServiceImpl {
	private static List<PaymentDetails> details = new ArrayList<>();
	
	static {
		details.add(new PaymentDetails(1,"SBI Bank",10000,"Ten Thousand","Abhishek","Vishal"));
		details.add(new PaymentDetails(2,"ICIC Bank",20000,"Twenty Thousand","Aditya","Abhishek"));
		details.add(new PaymentDetails(3,"ICIC Bank",30000,"Thirty Thousand","Shubham","Abhay"));
	}
	
	
	public List<PaymentDetails> getAllDetails(){
		return details;
	}	
	
	public PaymentDetails getDetailsRecordById(int id) {
		PaymentDetails detailsRecived = null;	
		for(PaymentDetails d :details) {
				if(d.getId()==id) {
					detailsRecived = d;
					return detailsRecived;
				}
			}
			return detailsRecived;
	}
	
	public boolean getDeletePaymentDetailsById(int id) {
		boolean status = details.removeIf(payment -> payment.getId()== id); 			
		return status;
	}
	
	public PaymentDetails getAddNewDetails(PaymentDetails d) {
		details.add(d);
		return d;
	}
	

}
