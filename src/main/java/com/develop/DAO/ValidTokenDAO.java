package com.develop.DAO;

import com.develop.models.ValidToken;

public interface ValidTokenDAO {
    ValidToken saveValidToken(ValidToken token);
    ValidToken getValidToken(String token);
}
