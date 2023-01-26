package com.dawm.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.controller.PerfilController;
import com.dawm.service.UsuarioService;

@Controller
public class PerfilControllerImpl implements PerfilController {
    
    public static final String PERFIL = "perfil";

    @Autowired
    private UsuarioService usuarioService;
    
    @Override
    @GetMapping(path = {"/perfil"})
    public ModelAndView getPerfil(Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(PERFIL);

        modelAndView.addObject("usuario", 
            usuarioService.getUsuario(SecurityContextHolder.getContext().getAuthentication().getName()));

        return modelAndView;
    }

}
