package com.example.instagram_clone.dto;

import com.example.instagram_clone.domain.User;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Table(name="users")
public class UserLoginDTO {
    private String username;
    private String password;
    private String phone;
    private String email;

    public User toEntity(){
        return User.builder()
                .email(email)
                .phone(phone)
                .username(username)
                .password(password)
                .build();
    }
}

// Controller에서 User의 정보를 전달하기위한 DTO