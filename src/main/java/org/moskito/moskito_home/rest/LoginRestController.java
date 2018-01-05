package org.moskito.moskito_home.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.moskito.moskito_home.dao.UserService;
import org.moskito.moskito_home.model.Login;
import org.moskito.moskito_home.model.User;
import org.moskito.moskito_home.rest.alexa_authorization.AlexaRequest;
import org.moskito.moskito_home.rest.alexa_authorization.AlexaResponse;
import org.moskito.moskito_home.rest.alexa_authorization.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RestController
@SessionAttributes("alexaRequest")
public class LoginRestController {
    private static final Logger log = LogManager.getLogger();

    @Autowired
    private UserService userService;

    // http://localhost:8080/api/login?state=abc&client_id=alexa-skill&scope=order_car%20basic_profile&response_type=token&redirect_uri=https%3A%2F%2Fpitangui.amazon.com%2Fspa%2Fskill%2Faccount-linking-status.html%3FvendorId%3DAAAAAAAAAAAAAA
    @RequestMapping(value = "/api/login")
    public ModelAndView alexaLogin(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam String state,
                                   @RequestParam String client_id,
                                   @RequestParam String response_type,
                                   @RequestParam(required = false) List<String> scope,
                                   @RequestParam String redirect_uri
    ) {
        // Create alexa's request
        AlexaRequest alexaRequest = new AlexaRequest(state, client_id, response_type, scope, redirect_uri);
        log.debug(alexaRequest);

        // Create new MAV
        ModelAndView mav = new ModelAndView("login");

        // Add Login and ALexa Request
        mav.addObject("login", new Login());
        mav.addObject("alexaRequest", alexaRequest);

        // Return mav
        return mav;
    }

    @RequestMapping(value = "/api/loginProcess", method = RequestMethod.POST)
    public ModelAndView alexaLoginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login, @ModelAttribute("alexaRequest") AlexaRequest alexaRequest) {
        // See if we obtained correct data
        log.debug(alexaRequest);

        // Validate user login
        User user = userService.validateUser(login);

        // If user successfully logged in
        if (user != null) {
            // Create new response for Alexa
            AlexaResponse alexaResponse = new AlexaResponse(alexaRequest.getRedirectUrl(), alexaRequest.getState(), new TokenManager(user.getUsername()).getAccessToken(), "Bearer");
            log.debug(alexaResponse);

            // Return new redirect MAV
            return new ModelAndView("redirect:" + alexaResponse.toUrl());
        }

        // If not
        else {
            // Create new MAV redirecting to the same login page
            ModelAndView mav = new ModelAndView("login");

            // Add new message model
            mav.addObject("message", "Username or password is incorrect!");

            // Return MAV
            return mav;
        }
    }
}