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

import com.dawm.controller.PerfilController;
import com.dawm.model.dto.UsuarioDTO;
import com.dawm.service.UsuarioService;

@Controller
public class PerfilControllerImpl implements PerfilController {

    public static final String PERFIL = "perfil";

    public static final String REDIRECT_PERFIL = "redirect:/perfil";

    public static final String USUARIO = "usuario";

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @GetMapping(path = {"/perfil"})
    public ModelAndView getPerfil(Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(PERFIL);

        // Usuario a la sesión
        if (session.getAttribute(USUARIO) == null) {
            session.setAttribute(USUARIO,
                    this.usuarioService.getUsuario(SecurityContextHolder.getContext().getAuthentication().getName()));
        }
        modelAndView.addObject(USUARIO, session.getAttribute(USUARIO));

        return modelAndView;
    }

    @Override
    @PostMapping(path = {"/updatePerfil"})
    public ModelAndView updatePerfil(@ModelAttribute("usuario") UsuarioDTO usuario, Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(REDIRECT_PERFIL);
        this.usuarioService.updateUsuario(usuario);

        // Usuario a la sesión
        if (session.getAttribute(USUARIO) == null) {
            session.setAttribute(USUARIO,
                    this.usuarioService.getUsuario(SecurityContextHolder.getContext().getAuthentication().getName()));
        }
        modelAndView.addObject(USUARIO, session.getAttribute(USUARIO));

        return modelAndView;
    }

}
