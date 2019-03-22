package com.develop.services;

import com.develop.models.User;
import com.develop.models.response.LoginResponse;

public interface LoginService {
    LoginResponse login(String username, String password);
    User getUser(String id);
}
