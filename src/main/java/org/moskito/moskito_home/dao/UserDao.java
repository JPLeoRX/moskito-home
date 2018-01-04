package org.moskito.moskito_home.dao;

import org.moskito.moskito_home.model.Login;
import org.moskito.moskito_home.model.User;
import org.springframework.stereotype.Service;

public interface UserDao {
    void register(User user);

    User validateUser(Login login);
}