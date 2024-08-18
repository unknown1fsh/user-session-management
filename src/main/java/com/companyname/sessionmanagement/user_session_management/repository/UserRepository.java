package com.companyname.sessionmanagement.user_session_management.repository;

import com.companyname.sessionmanagement.user_session_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
