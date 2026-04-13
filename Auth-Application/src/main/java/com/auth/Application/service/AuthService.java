package com.auth.Application.service;

import org.springframework.security.core.Authentication;

import com.auth.Application.dto.UserCredential;
import com.auth.Application.dto.UserDetailsDTO;

public interface AuthService {
	
	
	
	public UserDetailsDTO loginUser(UserCredential credentails);
	public Authentication authenticateUser(UserCredential credentials);
}
