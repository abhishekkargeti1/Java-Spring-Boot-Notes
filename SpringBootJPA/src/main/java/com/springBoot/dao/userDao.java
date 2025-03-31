package com.springBoot.dao;

import org.springframework.data.repository.CrudRepository;

import com.springBoot.entities.User;

public interface userDao extends CrudRepository<User, Integer> {

}
