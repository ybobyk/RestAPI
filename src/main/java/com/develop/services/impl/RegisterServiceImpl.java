package com.develop.services.impl;

import com.develop.DAO.UserDAO;
import com.develop.models.User;
import com.develop.models.response.RegisterResponse;
import com.develop.services.RegisterService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    public UserDAO userDAO;

    @Override
    public RegisterResponse register(User user) {
        RegisterResponse registerResponse = new RegisterResponse();

        User userFromDB = userDAO.getUser(user.getUsername());
        if (userFromDB == null) {
            String token = generateToken(user);
            user.setToken(token);
            userDAO.save(user);
            registerResponse.setMessage("User has been register successful");
        } else {
            registerResponse.setMessage("User is already exist");
        }

        return registerResponse;
    }

    private String generateToken(User user) {
        String jwt = "null";
        try {
            jwt = Jwts.builder()
                    .claim("name", user.getFirstName())
                    .claim("username", user.getUsername())
                    .claim("time", new Date().getTime())
                    .claim("admin", false)
                    .signWith(
                            SignatureAlgorithm.HS256,
                            "secret".getBytes("UTF-8")
                    )
                    .compact();
        } catch (Exception e) {

        }

        return jwt;
    }
}
