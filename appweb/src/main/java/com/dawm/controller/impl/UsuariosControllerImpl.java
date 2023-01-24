package com.dawm.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.controller.UsuariosController;

public class UsuariosControllerImpl implements UsuariosController {

    public static final String USUARIOS = "usuarios";

    @Override
    @GetMapping(path = {"/usuarios"})
    public ModelAndView getUsuarios(Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(USUARIOS);

        return modelAndView;
    }

}
