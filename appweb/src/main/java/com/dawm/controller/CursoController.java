package com.dawm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.model.dto.CursoDTO;

public interface CursoController {

    public ModelAndView getCursos(Model model, HttpSession session);

    public ModelAndView getMisCursos(Model model, HttpSession session);

    public ModelAndView addCurso(@ModelAttribute("curso") CursoDTO curso, Model model, HttpSession session);

    public ModelAndView borrarCurso(@ModelAttribute("curso") CursoDTO curso, Model model, HttpSession session);

    public ModelAndView editarCurso(@ModelAttribute("curso") CursoDTO curso, Model model, HttpSession session);

    public ModelAndView inscribirse(@RequestParam("idCurso") Long idCurso, Model model, HttpSession session);
    
}
