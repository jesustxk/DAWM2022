package com.dawm.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.controller.PerfilController;

@Controller
public class PerfilControllerImpl implements PerfilController {
    
    public static final String PERFIL = "perfil";
    
    @Override
    @GetMapping(path = {"/perfil"})
    public ModelAndView getPerfil(Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(PERFIL);

        return modelAndView;
    }

}
