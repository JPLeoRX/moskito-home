package org.moskito.moskito_home.rest;

import org.moskito.moskito_home.dao.UserService;
import org.moskito.moskito_home.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/users/{username}")
public class UserRestController {
    private static final Logger log = LogManager.getLogger();

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public String getAppUrl(@PathVariable String username) {
        log.debug("USERNAME = " + username);

        User user = userService.validateUser(username);
        log.debug("USER = " + user);

        return user.getAppUrl();
    }
}