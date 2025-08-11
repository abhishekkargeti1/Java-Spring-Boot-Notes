package com.spring.security.demo.dao;

import com.spring.security.demo.enities.UserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsDao extends CrudRepository<UserDetails,Integer> {
}
