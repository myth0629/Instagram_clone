package com.example.instagram_clone.service;

import com.example.instagram_clone.config.auth.PrincipalDetails;
import com.example.instagram_clone.domain.User;
import com.example.instagram_clone.domain.UserRespository;
import com.example.instagram_clone.dto.UserUpdateDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRespository userRespository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public void update(UserUpdateDTO userUpdateDTO, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        User user = userRespository.findByEmail(principalDetails.getUser().getEmail());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.update(
                passwordEncoder.encode(userUpdateDTO.getPassword()),
                userUpdateDTO.getPhone(),
                userUpdateDTO.getName(),
                userUpdateDTO.getTitle(),
                userUpdateDTO.getWebsite(),
                userUpdateDTO.getProfileImageUrl()
        );
    }

    public User getUserByEmail(String email) {
        User user = userRespository.findByEmail(email);
        return user;
    }
}
