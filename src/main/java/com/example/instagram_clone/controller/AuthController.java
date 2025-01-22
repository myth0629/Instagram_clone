package com.example.instagram_clone.controller;

import com.example.instagram_clone.domain.User;
import com.example.instagram_clone.dto.UserLoginDTO;
import com.example.instagram_clone.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller

public class AuthController {
    private final AuthService authService;

    @GetMapping({"/login", "/"})
    public String loginForm() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String Signup(UserLoginDTO userLoginDTO){
        User user = userLoginDTO.toEntity();
        try{
            authService.signup(user);
            return "redirect:/login";
        } catch (Exception e) {
            return "redirect:/signup";
        }
    }
}
