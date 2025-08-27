package com.spring.security.JWT.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.JWT.entites.xyz;

@Repository
public interface UserDetails extends CrudRepository<xyz,Integer> {

}
