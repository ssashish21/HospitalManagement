package com.ashish.hospital.hospitalManagement.security.controller;

import com.ashish.hospital.hospitalManagement.security.dto.LoginRequest;
import com.ashish.hospital.hospitalManagement.security.dto.RegisterRequest;
import com.ashish.hospital.hospitalManagement.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public void register( @RequestBody RegisterRequest user){
        userService.register(user);
    }

    // For simplicity, we just register/login via HTTP Basic (Spring Security handles auth)
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return "Login handled by Spring Security filters";
    }
}
