package com.ashish.hospital.hospitalManagement.security.service;

import com.ashish.hospital.hospitalManagement.security.dto.RegisterRequest;
import com.ashish.hospital.hospitalManagement.security.entity.User;

public interface UserService {
    void register(RegisterRequest request);
    String login(String userName, String Password);
}
