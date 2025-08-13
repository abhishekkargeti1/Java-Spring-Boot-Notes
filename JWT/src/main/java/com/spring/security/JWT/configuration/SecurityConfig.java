package com.spring.security.JWT.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("myuser")
                .password(encoder.encode("mypassword"))
                .roles("USER")
                .build();


        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("admin123"))
                .roles("Admin")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/vamps/**").authenticated()
                        .requestMatchers("/api/v1/**").permitAll()
                        .anyRequest().permitAll()
                )
                .httpBasic(httpBasic -> {}) // Enable Basic Auth
                .csrf(csrf -> csrf.disable()); // Disable CSRF for APIs

        return http.build();
    }
}