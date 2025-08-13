package com.spring.security.JWT.controller;

import com.spring.security.JWT.entites.User;
import com.spring.security.JWT.serviceImpl.LoginServiceImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class loginController {
    @Autowired
    LoginServiceImpl service;

    private final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private static final long EXPIRATION_TIME = 3600000;
    
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> getLogin(@RequestBody User details){



        //System.out.println("Hello Login Controller1");
        //System.out.println("Details in Controller "+details);
        String email= details.getEmail().trim();
        String password= details.getPassword().trim();


        List<User> users = service.getUserLogin(email, password);
        System.out.println("Details in Controller "+users);

        if(!users.isEmpty()){
            String token = Jwts.builder()
                    .setSubject(email)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SECRET_KEY)
                    .compact();

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            response.put("message", "Login Successfully");
            return ResponseEntity.ok(response);
        }else{
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }


    }


}
