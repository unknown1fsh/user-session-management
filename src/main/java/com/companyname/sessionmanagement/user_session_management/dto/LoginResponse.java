package com.companyname.sessionmanagement.user_session_management.dto;

public class LoginResponse {
    private String message;
    private String sessionId;
    private Long userId;

    public LoginResponse() {
    }

    public LoginResponse(String message) {
        this.message = message;
    }

    public LoginResponse(String message, String sessionId, Long userId) {
        this.message = message;
        this.sessionId = sessionId;
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
