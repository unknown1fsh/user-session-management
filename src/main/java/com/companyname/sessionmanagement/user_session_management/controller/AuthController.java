package com.companyname.sessionmanagement.user_session_management.controller;

import com.companyname.sessionmanagement.user_session_management.dto.LoginResponse;
import com.companyname.sessionmanagement.user_session_management.entity.User;
import com.companyname.sessionmanagement.user_session_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody User user) {
        return userService.loginUser(user.getEmail(), user.getPassword());
    }

    @PostMapping("/logout")
    public LoginResponse logoutUser(@RequestBody User user) {
        return userService.logoutUser(user.getId());
    }
}
