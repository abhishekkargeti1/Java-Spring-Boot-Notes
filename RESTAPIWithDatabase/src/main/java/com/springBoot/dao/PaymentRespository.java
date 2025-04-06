package com.springBoot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.entities.PaymentDetails;
@Repository
public interface PaymentRespository extends CrudRepository<PaymentDetails, Integer>{
	
	public PaymentDetails findById(int id);

}
