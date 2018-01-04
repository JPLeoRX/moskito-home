package org.moskito.moskito_home.dao;

import org.moskito.moskito_home.model.Login;
import org.moskito.moskito_home.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Transactional
    public void register(User user) {
        userDao.register(user);
    }

    @Transactional
    public User validateUser(Login login) {
        return userDao.validateUser(login);
    }
}