package com.dawm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.model.dto.UsuarioDTO;

public interface PerfilController {
    
    public ModelAndView getPerfil(Model model, HttpSession session);

    public ModelAndView updatePerfil(@ModelAttribute("usuario") UsuarioDTO usuario, Model model, HttpSession session);

}
