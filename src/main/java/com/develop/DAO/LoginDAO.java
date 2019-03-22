package com.develop.DAO;

import com.develop.models.User;

public interface LoginDAO {
    User getUser(String username);
}
