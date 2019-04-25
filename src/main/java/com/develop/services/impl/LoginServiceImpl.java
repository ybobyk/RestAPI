package com.develop.services.impl;

import com.develop.DAO.UserDAO;
import com.develop.DAO.ValidTokenDAO;
import com.develop.models.User;
import com.develop.models.ValidToken;
import com.develop.models.response.LoginResponse;
import com.develop.services.LoginService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    public UserDAO userDAO;

    @Autowired
    public ValidTokenDAO validTokenDAO;

    @Override
    @Transactional
    public LoginResponse login(String username, String password) {
        LoginResponse loginResponse = new LoginResponse();

        User userFromDB = getUser(username);
        if (userFromDB != null) {
            if (checkPassword(userFromDB, password)) {
                String token = generateToken(userFromDB);
                userFromDB.setToken(token);
                userDAO.update(userFromDB);
                loginResponse.setMessage("User has been logged successful");
                loginResponse.setUser(userFromDB);
            } else {
                loginResponse.setMessage("Wrong password");
            }
        } else {
            loginResponse.setMessage("User is not exist");
        }

        return loginResponse;
    }

    private User getUser(String username) {
        return userDAO.getUser(username);
    }

    private boolean checkPassword(User userFromDB, String password) {
        String passwordUserFromDB = userFromDB.getPassword();
        return passwordUserFromDB.equals(password);
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
