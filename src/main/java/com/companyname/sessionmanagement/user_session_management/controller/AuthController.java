package com.companyname.sessionmanagement.user_session_management.controller;

import com.companyname.sessionmanagement.user_session_management.dto.LoginRequest;
import com.companyname.sessionmanagement.user_session_management.dto.LoginResponse;
import com.companyname.sessionmanagement.user_session_management.dto.LogoutRequest;
import com.companyname.sessionmanagement.user_session_management.dto.RegisterRequest;
import com.companyname.sessionmanagement.user_session_management.entity.User;
import com.companyname.sessionmanagement.user_session_management.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@Valid @RequestBody LoginRequest request) {
        return userService.loginUser(request.getEmail(), request.getPassword());
    }

    @PostMapping("/logout")
    public LoginResponse logoutUser(@Valid @RequestBody LogoutRequest request) {
        return userService.logoutUser(request.getUserId());
    }
}
