package com.springBoot.Dao;

import org.springframework.data.repository.CrudRepository;

import com.springBoot.entities.UserDetails;

public interface JWTDao extends CrudRepository<UserDetails, Integer> {
		
	boolean existsByEmail(String email);
}
