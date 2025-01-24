package com.example.instagram_clone.controller;

import com.example.instagram_clone.config.auth.PrincipalDetails;
import com.example.instagram_clone.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.instagram_clone.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/story")
    public String story(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        User user = userService.getUserByEmail(principalDetails.getUser().getEmail());
        model.addAttribute("user", user);
        return "/post/story";
    }
}
