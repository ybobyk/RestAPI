package com.develop.controllers;

import com.develop.models.User;
import com.develop.models.response.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @PostMapping("/register")
    @ResponseBody
    public RegisterResponse register(@RequestHeader("password") String password,
                                    @RequestBody User user) {
        user.setPassword(password);
        return null;
    }
}
