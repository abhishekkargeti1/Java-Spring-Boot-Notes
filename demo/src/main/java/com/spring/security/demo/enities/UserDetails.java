package com.spring.security.demo.enities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDetails {
        @Id
        int id;
        String description ;
        String email ;
    @Column(name = "first name") // Adjust to match the actual column name
        String firstName ;
    @Column(name = "last name") // Adjust to match the actual column name
        String lastName;
    @Column(name = "contact number") // Adjust to match the actual column name
        String contractNumber ;

}
