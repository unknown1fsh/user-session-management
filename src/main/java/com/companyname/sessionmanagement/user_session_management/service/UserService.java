package com.companyname.sessionmanagement.user_session_management.service;

import com.companyname.sessionmanagement.user_session_management.dto.LoginResponse;
import com.companyname.sessionmanagement.user_session_management.entity.User;

public interface UserService {
    User registerUser(User user);
    LoginResponse loginUser(String email, String password);
    LoginResponse logoutUser(Long userId);
}
