package com.spring.security.demo.service;

import com.spring.security.demo.enities.UserDetails;

import java.util.List;

public interface DetailsService {
    public Iterable<UserDetails> getDetails();
}
