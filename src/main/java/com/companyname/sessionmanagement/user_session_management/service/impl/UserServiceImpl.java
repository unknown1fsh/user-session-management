package com.companyname.sessionmanagement.user_session_management.service.impl;

import com.companyname.sessionmanagement.user_session_management.dto.LoginResponse;
import com.companyname.sessionmanagement.user_session_management.entity.User;
import com.companyname.sessionmanagement.user_session_management.repository.UserRepository;
import com.companyname.sessionmanagement.user_session_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Override
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public LoginResponse loginUser(String email, String password) {
        return userRepository.findByEmail(email)
            .filter(user -> passwordEncoder.matches(password, user.getPassword()))
            .map(user -> {
                // Oturum verisini Redis'e kaydetme ve 2 dakika sonra sona ermesi için TTL ayarlama
                String sessionId = "session:" + user.getId();
                redisTemplate.opsForValue().set(sessionId, user, 2, TimeUnit.MINUTES);
                return new LoginResponse("Login Success");
            })
            .orElse(new LoginResponse("Login Failed: Wrong username or password"));
    }

    @Override
    public LoginResponse logoutUser(Long userId) {
        String sessionId = "session:" + userId;
        redisTemplate.delete(sessionId);
        return new LoginResponse("Logout Success");
    }
}
