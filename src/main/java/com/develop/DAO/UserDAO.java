package com.develop.DAO;

import com.develop.models.User;

public interface UserDAO {
    User save(User user);
    User getUser(String username);
    User getUserByToken(String token);
}
