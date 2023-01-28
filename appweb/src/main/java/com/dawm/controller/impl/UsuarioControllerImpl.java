package com.dawm.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.controller.UsuarioController;
import com.dawm.model.dto.UsuarioDTO;
import com.dawm.service.CursoService;
import com.dawm.service.UsuarioService;

@Controller
public class UsuarioControllerImpl implements UsuarioController {

    public static final String MIS_CURSOS = "mis-cursos";

    public static final String USUARIO = "usuario";

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CursoService cursoService;

    @Override
    @GetMapping(path = {"/mis-cursos"})
    public ModelAndView getUsuarios(Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(MIS_CURSOS);

        // Usuario a la sesión
        if (session.getAttribute(USUARIO) == null) {
            session.setAttribute(USUARIO, 
                this.usuarioService.getUsuario(SecurityContextHolder.getContext().getAuthentication().getName()));
        }
        modelAndView.addObject(USUARIO, session.getAttribute(USUARIO));

        modelAndView.addObject("tablaMisCursos", 
            this.cursoService.getMisCursos(((UsuarioDTO) session.getAttribute(USUARIO))));

        return modelAndView;
    }

}
