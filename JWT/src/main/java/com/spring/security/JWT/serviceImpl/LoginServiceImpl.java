package com.spring.security.JWT.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.JWT.dao.LoginDao;
import com.spring.security.JWT.dao.UserDetails;
import com.spring.security.JWT.entites.User;
import com.spring.security.JWT.entites.xyz;
import com.spring.security.JWT.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDao dao;
    
    @Autowired
    UserDetails dao1;
    
    
    
    @Override
    public List<User> getUserLogin(String email , String password){
    	return  dao.findByEmailAndPassword(email, password);
          
    }

    public Iterable<xyz> getDetails(){
    	return dao1.findAll();
    }
    
    
}
