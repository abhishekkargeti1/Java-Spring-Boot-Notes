package com.springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.doa.DetailsDao;
import com.springBoot.entities.Details;
@Service
public class DetailsService {
	
	@Autowired
	private DetailsDao dao;
	
	
	public Details insertUserDetails(Details details) {
		return dao.save(details);
	}
	
}
