package com.ashish.hospital.hospitalManagement;

import com.ashish.hospital.hospitalManagement.security.dto.RegisterRequest;
import com.ashish.hospital.hospitalManagement.security.entity.User;
import com.ashish.hospital.hospitalManagement.security.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Mock
    private UserService userService;

    @Test
    void createUser(){
        RegisterRequest user = new RegisterRequest("Ashish21", "1234", "USER");
        userService.register(user);
    }
}
