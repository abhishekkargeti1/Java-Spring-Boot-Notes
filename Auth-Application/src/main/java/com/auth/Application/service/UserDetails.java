package com.auth.Application.service;

import java.util.List;

import com.auth.Application.dto.UserCredential;
import com.auth.Application.dto.UserDetailsDTO;

public interface UserDetails {

	public UserDetailsDTO getUserRegister(UserDetailsDTO dto);
	
	public List<UserDetailsDTO> getALLUsers();
	
	public UserDetailsDTO getUserByEmailAndPassword(UserCredential credentails);
	
}
