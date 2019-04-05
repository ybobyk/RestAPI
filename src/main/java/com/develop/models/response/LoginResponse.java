package com.develop.models.response;

import com.develop.models.User;

public class LoginResponse {

    private String message;
    private User user;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
