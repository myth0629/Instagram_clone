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
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private String password;
    private String phone;
    private String username;
    private String title;
    private String website;
    private String profileImgUrl;

    public void update(String password,String phone, String username,String title,String website,String profileImgUrl){
        this.password = password;
        this.phone = phone;
        this.username = username;
        this.title = title;
        this.website = website;
        this.profileImgUrl = profileImgUrl;
    }
}
