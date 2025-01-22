package com.example.instagram_clone.domain;

import jakarta.persistence.*;
import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter

public class  User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    private String username;
    private String password;
    private String phone;
    private String email;
}
