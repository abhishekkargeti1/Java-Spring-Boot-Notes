package com.springBoot.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.springBoot.entities.UserDetails1;

public interface userDao extends CrudRepository<UserDetails1, Integer> {
	
	public List<UserDetails1> findByName(String name);
	public List<UserDetails1> findByEmailAndPassword(String email,String Password);
	public List<UserDetails1> findByPhoneNumber(String phoneNumber);
	public List<UserDetails1> findByStatusEquals(String status);

}
