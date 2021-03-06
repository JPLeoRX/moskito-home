package org.moskito.moskito_home.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.moskito.moskito_home.dao.UserService;
import org.moskito.moskito_home.model.User;
import org.moskito.moskito_home.rest.alexa_authorization.TokenDecoder;
import org.moskito.moskito_home.rest.responses.JsonTokenVerificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Use this REST controller to verify if the current token is still active
 *
 * If the token is not valid you should ask your user to perform login again
 *
 * @author Leo Ertuna
 */
@RestController
@RequestMapping("/api/token/{accessToken}")
public class TokenVerificationRestController {
    private static final Logger log = LogManager.getLogger();

    @Autowired
    private UserService userService;

    @RequestMapping("/verify")
    public @ResponseBody JsonTokenVerificationResponse verify(@PathVariable String accessToken) {
        log.debug("accessToken = " + accessToken);

        // Decode the token
        String username = TokenDecoder.getIssuer(accessToken);
        log.debug("username = " + username);

        // If token was invalid
        if (username == null)
            // False response
            return new JsonTokenVerificationResponse(false);

        // Get the user
        User user = userService.validateUser(username);
        log.debug("user = " + user);

        // If no user was found
        if (user == null)
            // False response
            return new JsonTokenVerificationResponse(false);

        // If everything worked fine - true response
        return new JsonTokenVerificationResponse(true);
    }
}
