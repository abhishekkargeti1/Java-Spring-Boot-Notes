package com.spring.security.JWT.service;

import java.util.List;

import com.spring.security.JWT.entites.User;
import com.spring.security.JWT.entites.xyz;

public interface LoginService {
    public List<User> getUserLogin(String email , String password);
    public Iterable<xyz> getDetails();
}
