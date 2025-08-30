package com.ashish.hospital.hospitalManagement.security.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
