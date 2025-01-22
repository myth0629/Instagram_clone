package com.example.instagram_clone.service;
import com.example.instagram_clone.domain.User;

import com.example.instagram_clone.domain.UserRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRespository userRespository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User signup(User user){
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);

        return userRespository.save(user);
    }

    @Transactional
    public User userUpdate(User user){
        return userRespository.save(user);
    }
}