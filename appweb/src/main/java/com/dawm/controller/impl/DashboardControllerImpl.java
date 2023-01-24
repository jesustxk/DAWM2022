package com.dawm.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.controller.DashboardController;

public class DashboardControllerImpl implements DashboardController {

    public static final String REDIRECT_LOGIN = "redirect:/login";

    public static final String DASHBOARD = "dashboard";

    @Override
    @GetMapping(path = {"/dashboard"})
    public ModelAndView getDashboard(Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(REDIRECT_LOGIN);

        return new ModelAndView(DASHBOARD);
    }
    
}
