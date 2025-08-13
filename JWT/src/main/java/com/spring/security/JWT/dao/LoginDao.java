package com.spring.security.JWT.dao;

import com.spring.security.JWT.entites.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginDao extends CrudRepository<User,Integer> {

    public List<User> findByEmailAndPassword(String email,String password);
}
