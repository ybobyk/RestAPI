package com.develop.controllers;

import com.develop.models.User;
import com.develop.models.response.LoginResponse;
import com.develop.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    public LoginService loginService;

    @ResponseBody
    @GetMapping("/login")
    public LoginResponse login(@RequestHeader("username") String username,
                               @RequestHeader("password") String password) {
        return loginService.login(username, password);
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//
//        LoginResponse loginResponse = new LoginResponse();
//        loginResponse.setUser(user);
//        loginResponse.setMessage("bla");
//
//        return loginResponse;
    }

    @ResponseBody
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") String id) {
        return loginService.getUser(id);
    }
}
