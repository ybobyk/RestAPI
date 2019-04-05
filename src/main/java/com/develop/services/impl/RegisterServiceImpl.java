package com.develop.services.impl;

import com.develop.DAO.UserDAO;
import com.develop.models.User;
import com.develop.models.response.RegisterResponse;
import com.develop.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    public UserDAO userDAO;

    @Override
    public RegisterResponse register(User user) {
        RegisterResponse registerResponse = new RegisterResponse();

        User userFromDB = userDAO.getUser(user.getUsername());
        if (userFromDB == null) {
            userDAO.save(user);
            registerResponse.setMessage("User has been register successful");
        } else {
            registerResponse.setMessage("User is already exist");
        }

        return registerResponse;
    }
}
