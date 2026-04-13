package com.auth.Application.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.Application.dto.TokenResponse;
import com.auth.Application.dto.UserCredential;
import com.auth.Application.dto.UserDetailsDTO;
import com.auth.Application.entities.UserDetailsEntity;
import com.auth.Application.security.JWTService;
import com.auth.Application.service.AuthService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/auth")
@Slf4j
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private JWTService jwtService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@Valid @RequestBody UserCredential credentials, BindingResult errorMessage) {

		if (errorMessage.hasErrors()) {
			for (FieldError error : errorMessage.getFieldErrors()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getDefaultMessage());
			}
		}

		Authentication authenticateUser = authService.authenticateUser(credentials);
		log.info("AuthenticateUser {}", authenticateUser);

		UserDetailsEntity loginUserDetails = (UserDetailsEntity) authenticateUser.getPrincipal();
		log.info("AuthenticateUser Login Details {}", loginUserDetails);
		String accessToken = jwtService.generateToken(loginUserDetails);
		boolean accountStatus = loginUserDetails.isEnabled();
		if (accountStatus) {

			TokenResponse tokenResponse = TokenResponse.of(accessToken, null, jwtService.getAccessTtlSeconds(),
					modelMapper.map(loginUserDetails, UserDetailsDTO.class));
			return ResponseEntity.status(HttpStatus.OK).body(tokenResponse);
		} else {
			throw new DisabledException("User Account is Disable");
		}

	}

}
