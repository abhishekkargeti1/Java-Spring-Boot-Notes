package com.spring.security.JWT.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.JWT.entites.User;

@Repository
public interface LoginDao extends CrudRepository<User,Integer> {

    public List<User> findByEmailAndPassword(String email,String password);
    
    
   
    
}
