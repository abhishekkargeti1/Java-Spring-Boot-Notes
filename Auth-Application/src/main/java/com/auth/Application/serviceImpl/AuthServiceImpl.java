package com.auth.Application.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.auth.Application.dto.UserCredential;
import com.auth.Application.dto.UserDetailsDTO;
import com.auth.Application.service.AuthService;
import com.auth.Application.service.UserDetails;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserDetails userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public Authentication authenticateUser(UserCredential credentials) {
		try {
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword()));
		} catch (DisabledException e) {
			throw new DisabledException("User Account is Disabled");
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Invalid Email or Password");
		}
	}

	@Override
	public UserDetailsDTO loginUser(UserCredential credentails) {
		UserDetailsDTO userDTO = userService.getUserByEmailAndPassword(credentails);
		return userDTO;
	}

}
