package com.develop.services.impl;

import com.develop.DAO.UserDAO;
import com.develop.DAO.ValidTokenDAO;
import com.develop.models.User;
import com.develop.models.ValidToken;
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

    @Autowired
    public ValidTokenDAO validTokenDAO;

    @Override
    @Transactional
    public LoginResponse login(String username, String password) {
        LoginResponse loginResponse = new LoginResponse();

        User userFromDB = getUser(username);
        if (userFromDB != null) {
            if (checkPassword(userFromDB, password)) {
                ValidToken token = generateToken(userFromDB);
                validTokenDAO.saveValidToken(token);
                loginResponse.setMessage("User has been logged successful");
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

    private ValidToken generateToken(User user) {
        ValidToken validToken = new ValidToken();
        validToken.setToken("123456");
        return validToken;
    }

}
