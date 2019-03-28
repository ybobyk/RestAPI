package com.develop.services;

import com.develop.models.User;
import com.develop.models.response.RegisterResponse;

public interface RegisterService {
    RegisterResponse register(User user);
}
