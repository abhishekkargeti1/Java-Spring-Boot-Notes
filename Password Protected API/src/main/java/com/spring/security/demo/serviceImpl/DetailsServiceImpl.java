package com.spring.security.demo.serviceImpl;

import com.spring.security.demo.dao.DetailsDao;
import com.spring.security.demo.enities.UserDetails;
import com.spring.security.demo.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailsServiceImpl implements DetailsService {

    @Autowired
    DetailsDao dao;


    @Override
    public Iterable<UserDetails> getDetails() {
        return dao.findAll();
    }
}
