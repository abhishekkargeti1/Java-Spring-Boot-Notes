package com.springBoot.dao;

import org.springframework.data.repository.CrudRepository;

import com.springBoot.entities.UserDetails;

public interface userDao extends CrudRepository<UserDetails, Integer> {

}
