package com.develop.services.impl;

import com.develop.DAO.UserDAO;
import com.develop.models.User;
import com.develop.models.response.LoginResponse;
import com.develop.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    public UserDAO userDAO;

    @Override
    @Transactional
    public LoginResponse login(String username, String password) {
        LoginResponse loginResponse = new LoginResponse();
        if (checkUserExist(username)) {
            User user = getUser(username);
            if (checkPassword(user.getPassword(), password)) {
                loginResponse.setUser(user);
                loginResponse.setMessage("User has been logged successful");
            } else {
                loginResponse.setMessage("Wrong password");
            }
        } else {
            loginResponse.setMessage("User is not exist");
        }
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        userDAO.save(user);

        return loginResponse;
    }

    private boolean checkUserExist(String username) {
        return getUser(username) != null;
    }

    private boolean checkPassword(String passwordFromDB, String passwordFromClient) {
        return passwordFromDB.equals(passwordFromClient);
    }

    @Override
    public User getUser(String username) {
        return userDAO.getUser(username);
    }
}
