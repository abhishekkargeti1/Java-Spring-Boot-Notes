package com.spring.security.JWT.serviceImpl;

import com.spring.security.JWT.dao.LoginDao;
import com.spring.security.JWT.entites.User;
import com.spring.security.JWT.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDao dao;
    @Override
    public List<User> getUserLogin(String email , String password){
    	return  dao.findByEmailAndPassword(email, password);
         
          
    }

}
