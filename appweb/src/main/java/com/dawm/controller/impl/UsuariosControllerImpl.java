package com.dawm.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.controller.UsuariosController;
import com.dawm.service.CursoService;

@Controller
public class UsuariosControllerImpl implements UsuariosController {

    public static final String USUARIOS = "usuarios";

    @Autowired
    private CursoService cursoService;

    @Override
    @GetMapping(path = {"/usuarios"})
    public ModelAndView getUsuarios(Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(USUARIOS);

        modelAndView.addObject("tablaCursos", this.cursoService.getMisCursos());

        return modelAndView;
    }

}
