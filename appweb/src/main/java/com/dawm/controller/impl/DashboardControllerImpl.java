package com.dawm.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.controller.DashboardController;
import com.dawm.service.CursoService;
import com.dawm.service.UsuarioService;

@Controller
public class DashboardControllerImpl implements DashboardController {

    public static final String DASHBOARD = "dashboard";

    public static final String USUARIO = "usuario";

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CursoService cursoService;

    @Override
    @GetMapping(path = {"/", "/dashboard"})
    public ModelAndView getDashboard(Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(DASHBOARD);

        // Usuario a la sesión
        if (session.getAttribute(USUARIO) == null) {
            session.setAttribute(USUARIO, 
                this.usuarioService.getUsuario(SecurityContextHolder.getContext().getAuthentication().getName()));
        }
        modelAndView.addObject(USUARIO, session.getAttribute(USUARIO));

        modelAndView.addObject("tablaCursos", this.cursoService.getTopCursos());

        return modelAndView;
    }
    
}
