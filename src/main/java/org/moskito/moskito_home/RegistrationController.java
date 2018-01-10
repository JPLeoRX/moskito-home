package org.moskito.moskito_home;

import org.moskito.moskito_home.dao.UserService;
import org.moskito.moskito_home.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        // Create new MAV
        ModelAndView modelAndView = new ModelAndView("register");

        // Add new User model
        modelAndView.addObject("user", new User());

        // Return MAV
        return modelAndView;
    }

    @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
        // Perform user registration
        userService.register(user);

        // Return new Welcome MAV
        return new ModelAndView("welcome");
    }
}