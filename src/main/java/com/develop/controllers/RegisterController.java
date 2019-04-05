package com.develop.controllers;

import com.develop.models.User;
import com.develop.models.response.RegisterResponse;
import com.develop.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    public RegisterService registerService;

    @PostMapping("/register")
    @ResponseBody
    public RegisterResponse register(@RequestHeader("password") String password,
                                    @RequestBody User user) {
        user.setPassword(password);
        return registerService.register(user);
    }
}
