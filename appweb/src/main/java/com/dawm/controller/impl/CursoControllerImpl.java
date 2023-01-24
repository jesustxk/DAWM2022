package com.dawm.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.controller.CursoController;
import com.dawm.service.CursoService;

@Controller
public class CursoControllerImpl implements CursoController {

    public static final String CURSOS = "cursos";

    @Autowired
    private CursoService cursoService;
    
    @Override
    @GetMapping(path = {"/cursos"})
    public ModelAndView getCursos(Model model, HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView(CURSOS);

        modelAndView.addObject("tablaCursos", this.cursoService.getListaCursosDTO());

        return modelAndView;
    }

}
