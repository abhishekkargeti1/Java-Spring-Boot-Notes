package com.springBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.dao.UserDao;
import com.springBoot.entites.UserDetails;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
		
	public UserDetails insertData(UserDetails details) {
		UserDetails save = dao.save(details);
		return save;
	}

}
