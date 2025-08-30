package com.ashish.hospital.hospitalManagement.security.service;

import com.ashish.hospital.hospitalManagement.security.dto.RegisterRequest;
import com.ashish.hospital.hospitalManagement.security.entity.User;
import com.ashish.hospital.hospitalManagement.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        userRepository.save(user);
    }

    //// For simplicity, we just register/login via HTTP Basic (Spring Security handles auth)
    @Override
    public String login(String userName, String Password) {
        return "Login handled by Spring Security filters";
    }

}
