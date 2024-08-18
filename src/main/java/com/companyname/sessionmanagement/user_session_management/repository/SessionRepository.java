package com.companyname.sessionmanagement.user_session_management.repository;

import com.companyname.sessionmanagement.user_session_management.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
