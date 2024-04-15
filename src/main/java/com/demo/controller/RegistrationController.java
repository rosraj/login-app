package com.demo.controller;

import com.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    private RegisterService registerService;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "registration";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String showRegistrationPage(ModelMap model,
                                       @RequestParam String name,
                                       @RequestParam String username,
                                       @RequestParam String password,
                                       @RequestParam String email){
        boolean isRegistered = registerService.saveUser(name, username, password, email);
        if (!isRegistered) {
            model.put("errorMessage", "Registration Failed , User Already exist");
        }
        model.put("errorMessage", "Registration Completed Successfully , Please go to Login Screen");
        return "registration";
    }

}
