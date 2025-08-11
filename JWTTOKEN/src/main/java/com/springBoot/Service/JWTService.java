package com.springBoot.Service;

import com.springBoot.entities.UserDetails;

public interface JWTService {

	public boolean insertDetailsData(UserDetails details);
	
	public boolean checkEmailExist(String email);
}
