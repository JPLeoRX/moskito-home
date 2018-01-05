package org.moskito.moskito_home.rest;

import org.moskito.moskito_home.dao.UserService;
import org.moskito.moskito_home.model.User;
import org.moskito.moskito_home.rest.alexa_authorization.TokenDecoder;
import org.moskito.moskito_home.rest.responses.JsonAppUrlResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/users/{accessToken}")
public class UserRestController {
    private static final Logger log = LogManager.getLogger();

    @Autowired
    private UserService userService;

    // http://localhost:8080/api/users/eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJsZW8ifQ.dhN4lO2A-Mq2yZ1pN-euRn86RS1kxjHoXXKVM2x21ew/app
    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public @ResponseBody
    JsonAppUrlResponse getAppUrl(@PathVariable String accessToken) {
        log.debug("accessToken = " + accessToken);

        // Decode the token
        String username = TokenDecoder.getIssuer(accessToken);
        log.debug("username = " + username);

        // Get the user
        User user = userService.validateUser(username);
        log.debug("user = " + user);

        // Get the URL of user's app
        String appUrl = user.getAppUrl();
        log.debug("appUrl = " + appUrl);

        // Return new response
        return new JsonAppUrlResponse(appUrl);
    }
}