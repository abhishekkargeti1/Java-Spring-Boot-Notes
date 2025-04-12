package com.springBoot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.entites.UserDetails;

@Repository
public interface UserDao extends CrudRepository<UserDetails, Integer> {

}
