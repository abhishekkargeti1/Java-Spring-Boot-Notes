package com.springBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.entities.PaymentDetails;
import com.springBoot.service.ServiceImpl;

@RestController
public class PaymentController {
	
	@Autowired
	private ServiceImpl service;
	
	
	@GetMapping("/paymentDetails")
	public ResponseEntity<List<PaymentDetails>> getAllDetails(){
		
		List<PaymentDetails> allDetailsRecived = service.getAllDetails();
		if(allDetailsRecived.size()<=0) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(allDetailsRecived);
	}
	
	@GetMapping("/paymentDetails/{id}")
	public ResponseEntity<PaymentDetails> getPayamentDetailsById(@PathVariable("id") int id){
		PaymentDetails detailsRecived = service.getDetailsRecordById(id);
		if(detailsRecived==null) {		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
			return ResponseEntity.status(HttpStatus.OK).body(detailsRecived);
	} 
	
	
	
	@DeleteMapping("/paymentDetails/{id}")
	public ResponseEntity<PaymentDetails> getPaymentDetailsDeleteById(@PathVariable("id") int id){
		boolean result = service.getDeletePaymentDetailsById(id);
			if(result) {
				return ResponseEntity.status(HttpStatus.OK).build();
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	
	}
	
	@PostMapping("/paymentDetails")
	public ResponseEntity<PaymentDetails> getPaymentDetailsAdded(@RequestBody PaymentDetails details){
		PaymentDetails newDetailsRecived = service.getAddNewDetails(details);
		if(newDetailsRecived ==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(newDetailsRecived);
	}
	
			
}
