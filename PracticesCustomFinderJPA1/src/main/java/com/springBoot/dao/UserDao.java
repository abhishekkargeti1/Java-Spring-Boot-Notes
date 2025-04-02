package com.springBoot.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springBoot.entities.UserDetails;

public interface UserDao extends CrudRepository<UserDetails, Integer> {

	public List<UserDetails> findByName(String name);
}
