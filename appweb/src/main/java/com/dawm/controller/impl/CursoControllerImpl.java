package com.dawm.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.controller.CursoController;

@Controller
public class CursoControllerImpl implements CursoController {

    public static final String CURSOS = "cursos";
    
    @Override
    @GetMapping(path = {"/cursos"})
    public ModelAndView getCursos(Model model, HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView(CURSOS);

        return modelAndView;
    }

}
