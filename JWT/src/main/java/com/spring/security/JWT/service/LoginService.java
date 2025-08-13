package com.spring.security.JWT.service;

import com.spring.security.JWT.entites.User;

import java.util.List;

public interface LoginService {
    public List<User> getUserLogin(String email , String password);

}
