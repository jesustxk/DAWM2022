package com.dawm.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.controller.AppWebController;
import com.dawm.model.UserData;
import com.dawm.service.AuthoritiesService;
import com.dawm.service.UserService;

@Controller
public class AppWebControllerImpl implements AppWebController {

    public static final String LOGIN = "login";

    public static final String REDIRECT_LOGIN = "redirect:/login";

    @Autowired
    private AuthoritiesService authoritiesService;

    @Autowired
    private UserService userService;
    
    @Override
    @GetMapping(path = {"/login"})
    public ModelAndView getLogin(Model model, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView(LOGIN);

        modelAndView.addObject("userData", new UserData());

    	return modelAndView;
    }

    @Override
    @PostMapping(path = {"/addUser"})
    public ModelAndView addUser(@ModelAttribute("userData") UserData userData, Model model, HttpSession session){

        ModelAndView modelAndView = new ModelAndView(REDIRECT_LOGIN);

        try {
            this.userService.addUser(userData);
            this.authoritiesService.addAuthority(userData.getUsername());
        } catch (Exception e) {
            return new ModelAndView(REDIRECT_LOGIN);
        }

        return modelAndView;
    }

}
