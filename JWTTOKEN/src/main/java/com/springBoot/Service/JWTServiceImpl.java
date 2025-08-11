package com.springBoot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.Dao.JWTDao;
import com.springBoot.entities.UserDetails;

@Service
public class JWTServiceImpl implements JWTService {

	@Autowired
	JWTDao dao;
	
	@Override
	public boolean insertDetailsData(UserDetails details) {
		UserDetails status = dao.save(details);
		if(status !=null) {
			return true;			
		}
		return false;			
	}

	@Override
	public boolean checkEmailExist(String email) {
		 boolean status = dao.existsByEmail(email);
		 System.out.println("Status is "+status);
		return status;
	}
	
	
}
