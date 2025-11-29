package com.companyname.sessionmanagement.user_session_management.dto;

import jakarta.validation.constraints.NotNull;

public class LogoutRequest {
    
    @NotNull(message = "User ID is required")
    private Long userId;

    public LogoutRequest() {
    }

    public LogoutRequest(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

