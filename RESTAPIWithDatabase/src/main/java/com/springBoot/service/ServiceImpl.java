package com.springBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.dao.PaymentRespository;
import com.springBoot.entities.PaymentDetails;

@Service
public class ServiceImpl {
	@Autowired
	private PaymentRespository paymentDao;
	
	public List<PaymentDetails> getAllDetails(){
		List<PaymentDetails> details = (List<PaymentDetails>)paymentDao.findAll();
		return details;
	}	
	
	public PaymentDetails getDetailsRecordById(int id) {
			
		PaymentDetails detailsRecived = paymentDao.findById(id);
		
			return detailsRecived;
	}
	
	public void getDeletePaymentDetailsById(int id) {
		paymentDao.deleteById(id); 			
	}
	
	public PaymentDetails getAddNewDetails(PaymentDetails d) {
		PaymentDetails result = paymentDao.save(d);
		return result;
	}
	
	public PaymentDetails getUpdateDetails(PaymentDetails details,int id) {
		
		PaymentDetails detailsById = paymentDao.findById(id);
		detailsById.setBankName(details.getBankName());
		detailsById.setSenderName(details.getSenderName());
		PaymentDetails updatedDetails = paymentDao.save(detailsById);
		return  updatedDetails;
	}

}
