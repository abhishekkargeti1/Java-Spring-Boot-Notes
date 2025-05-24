package com.springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.doa.DetailsDao;
import com.springBoot.entites.Details;

@Service
public class DetailsService {

	@Autowired
	DetailsDao dao;
	
	public Details addUser (Details details) {
		Details d = dao.save(details);
		return d;
	}
}
