package com.auth.Application.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.Application.dto.UserCredential;
import com.auth.Application.dto.UserDetailsDTO;
import com.auth.Application.entities.UserDetailsEntity;
import com.auth.Application.repositories.UserDetailsRepository;
import com.auth.Application.service.UserDetails;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetails {

	@Autowired
	private UserDetailsRepository respository;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	@Transactional
	public UserDetailsDTO getUserRegister(UserDetailsDTO dto) {
		log.info("User Details in Service Layer {}", dto);

		if (respository.existsByEmail(dto.getEmail())) {
			throw new IllegalArgumentException("Email already Exists");

		}
		
		dto.setPassword(encoder.encode(dto.getPassword()));
		// UserDetailsEntity entity = UserDetailsMapper.toEntity(dto);
		UserDetailsEntity entity = mapper.map(dto, UserDetailsEntity.class);
		UserDetailsEntity savedDetails = respository.save(entity);

		UserDetailsDTO savedDetailsDto = mapper.map(savedDetails, UserDetailsDTO.class);

		return savedDetailsDto;

	}

	@Override
	public List<UserDetailsDTO> getALLUsers() {
		List<UserDetailsEntity> userDetails = respository.findAll();

		List<UserDetailsDTO> userDetailsDTO = userDetails.stream()
				.map(entity -> mapper.map(entity, UserDetailsDTO.class)).toList();

		return userDetailsDTO;
	}

	@Override
	public UserDetailsDTO getUserByEmailAndPassword(UserCredential credentails) {

		Optional<UserDetailsEntity> userDetailsByEmail = respository.findByEmail(credentails.getEmail());
		if (userDetailsByEmail.isPresent()) {
			UserDetailsEntity userDetailsEntity = userDetailsByEmail.get();

			if (encoder.matches(credentails.getPassword(), userDetailsEntity.getPassword())) {

				UserDetailsDTO userDetailsDTO = mapper.map(userDetailsEntity, UserDetailsDTO.class);

				return userDetailsDTO;
			} else {
				throw new IllegalArgumentException("Please Enter Valid Credetails");
			}
		} else {
			throw new IllegalArgumentException("Please Enter Valid Credetails");
		}
	}

}
