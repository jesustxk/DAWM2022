package com.dawm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface CursoController {

    public ModelAndView getCursos(Model model, HttpSession session);
    
}
