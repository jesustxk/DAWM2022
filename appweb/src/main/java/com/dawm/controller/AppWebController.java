package com.dawm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.model.util.UserData;

public interface AppWebController {
    
    public ModelAndView getLogin(Model model, HttpSession session);

    public ModelAndView addUser(@ModelAttribute UserData userData, Model model, HttpSession session);
    
}
