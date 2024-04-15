package com.demo.controller;

import com.demo.cache.UserCache;
import com.demo.model.UserInfo;
import com.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.TableView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@SessionAttributes("name")
public class LoginController {
    @Autowired
    LoginService service;

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String showHomePage(ModelMap model){
        return "home";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password){

        String user = service.validateUser(username, password);

        if (Objects.isNull(user)) {
            model.put("errorMessage", "Access Denied , User Not Found");
            return "login";
        }

        model.put("name", user);
        model.put("username", username);

        return "welcome";
    }

    /*@RequestMapping(value="/listAll", method = RequestMethod.GET)
    public String listAllUser(Model model) {
        List<UserInfo> userList = service.getUserInfoList();
        model.addAttribute("user",userList);
        return "listAll";
    }*/

    @RequestMapping(value="/listAll", method=RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<UserInfo> getAllUsers() {
        List<UserInfo> userList = service.getUserInfoList();
        System.out.println(userList);
        return userList;
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String showLogoutPage(ModelMap model){
        return "login";
    }
}
