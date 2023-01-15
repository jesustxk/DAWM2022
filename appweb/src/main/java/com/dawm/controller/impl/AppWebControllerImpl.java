package com.dawm.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.controller.AppWebController;

@Controller
public class AppWebControllerImpl implements AppWebController {

    public static final String LOGIN = "login";
    
    @GetMapping(path = {"/login"})
    public ModelAndView principal(Model model, HttpSession session) {
    	
    	ModelAndView modelAndView = new ModelAndView(LOGIN);
    	
        return modelAndView;
    }

}
