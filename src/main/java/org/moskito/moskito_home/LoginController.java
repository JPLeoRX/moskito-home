package org.moskito.moskito_home;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.moskito.moskito_home.dao.UserService;
import org.moskito.moskito_home.model.Login;
import org.moskito.moskito_home.model.User;
import org.moskito.moskito_home.rest.alexa_authorization.AlexaResponse;
import org.moskito.moskito_home.rest.alexa_authorization.AlexaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RestController
public class LoginController {
    private static final Logger log = LogManager.getLogger();

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        // Create new MAV
        ModelAndView mav = new ModelAndView("login");

        // Add new Login model
        mav.addObject("login", new Login());

        // Return MAV
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("login") Login login) {
        // Validate user login
        User user = userService.validateUser(login);

        // If user successfully logged in
        if (user != null) {
            // Create new MAV redirecting to welcome page
            return new ModelAndView("welcome");
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