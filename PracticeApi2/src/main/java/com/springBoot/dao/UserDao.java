package com.springBoot.dao;

import org.springframework.data.repository.CrudRepository;

import com.springBoot.entities.UserDetails;

public interface UserDao extends CrudRepository<UserDetails, Integer> {

}
