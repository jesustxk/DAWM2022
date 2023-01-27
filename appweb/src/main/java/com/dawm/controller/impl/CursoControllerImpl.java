package com.dawm.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.controller.CursoController;
import com.dawm.model.dto.CursoDTO;
import com.dawm.service.CursoService;
import com.dawm.service.UsuarioService;

@Controller
public class CursoControllerImpl implements CursoController {

    public static final String CURSOS = "cursos";

    public static final String REDIRECT_CURSOS = "redirect:/cursos";

    public static final String USUARIO = "usuario";

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CursoService cursoService;
    
    @Override
    @GetMapping(path = {"/cursos"})
    public ModelAndView getCursos(Model model, HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView(CURSOS);

        modelAndView.addObject("tablaCursos", this.cursoService.getAllCursos());
        modelAndView.addObject("curso", new CursoDTO());
        modelAndView.addObject("imagen", "");

        // Usuario a la sesión
        if (session.getAttribute(USUARIO) == null) {
            session.setAttribute(USUARIO, 
                this.usuarioService.getUsuario(SecurityContextHolder.getContext().getAuthentication().getName()));
        }
        modelAndView.addObject(USUARIO, session.getAttribute(USUARIO));

        return modelAndView;
    }

    @Override
    @PostMapping(path = {"/addCurso"})
    public ModelAndView addCurso(@ModelAttribute("curso") CursoDTO curso, Model model, HttpSession session) {
        
        ModelAndView modelAndView = new ModelAndView(REDIRECT_CURSOS);
        
        try {
            this.cursoService.addCurso(curso);
        } catch (Exception e) {
            return new ModelAndView(REDIRECT_CURSOS);
        }

        modelAndView.addObject("tablaCursos", this.cursoService.getAllCursos());
        modelAndView.addObject("curso", new CursoDTO());


        return modelAndView;
    }

}
