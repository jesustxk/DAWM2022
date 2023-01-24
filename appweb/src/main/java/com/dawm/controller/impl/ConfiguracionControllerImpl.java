package com.dawm.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.controller.ConfiguracionController;

@Controller
public class ConfiguracionControllerImpl implements ConfiguracionController {

    public static final String CONFIGURATION = "configuration";

    @Override
    @GetMapping(path = {"/configuration"})
    public ModelAndView getConfiguration(Model model, HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView(CONFIGURATION);

        return modelAndView;
    }
    
}
