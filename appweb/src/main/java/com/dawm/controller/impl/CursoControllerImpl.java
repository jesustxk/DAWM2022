package com.dawm.controller.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dawm.controller.CursoController;
import com.dawm.model.dto.CursoDTO;
import com.dawm.model.dto.UsuarioDTO;
import com.dawm.service.CursoService;
import com.dawm.service.CursoUsuarioService;
import com.dawm.service.UsuarioService;

@Controller
public class CursoControllerImpl implements CursoController {

    public static final String CURSOS = "cursos";

    public static final String REDIRECT_CURSOS = "redirect:/cursos";

    public static final String USUARIO = "usuario";

    public static final String REDIRECT_MIS_CURSOS = "redirect:/mis-cursos";

    public static final String TABLA_CURSOS = "tablaCursos";

    public static final String MIS_CURSOS = "mis-cursos";

    @Autowired
    private CursoUsuarioService cursoUsuarioService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CursoService cursoService;

    @Override
    @GetMapping(path = { "/cursos" })
    public ModelAndView getCursos(@RequestParam("idUsuario") Long idUsuario, Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(CURSOS);

        modelAndView.addObject(TABLA_CURSOS, this.cursoService.getCursosNoMatriculadosNoPropietario(idUsuario));
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
    @GetMapping(path = {"/mis-cursos"})
    public ModelAndView getMisCursos(Model model, HttpSession session) {

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

    @Override
    @PostMapping(path = { "/addCurso" })
    public ModelAndView addCurso(@ModelAttribute("curso") CursoDTO curso, Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(REDIRECT_CURSOS);

        curso.setUsuario(((UsuarioDTO) session.getAttribute(USUARIO)));

        try {
            this.cursoService.addCurso(curso);
        } catch (Exception e) {
            return new ModelAndView(REDIRECT_CURSOS);
        }

        modelAndView.addObject(TABLA_CURSOS, this.cursoService
                .getCursosNoMatriculadosNoPropietario(((UsuarioDTO) session.getAttribute(USUARIO)).getIdUsuario()));
        modelAndView.addObject("curso", new CursoDTO());

        return modelAndView;
    }

    @Override
    @PostMapping(path = { "/editarCurso" })
    public ModelAndView editarCurso(@ModelAttribute("curso") CursoDTO curso, Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(REDIRECT_MIS_CURSOS);

        try {
            this.cursoService.editarCurso(curso);
        } catch (Exception e) {
            return new ModelAndView(REDIRECT_MIS_CURSOS);
        }

        modelAndView.addObject(TABLA_CURSOS,
                this.cursoService.getCursosMatriculados(((UsuarioDTO) session.getAttribute(USUARIO)).getIdUsuario()));

        return modelAndView;
    }

    @Override
    @PostMapping(path = { "/borrarCurso" })
    public ModelAndView borrarCurso(@ModelAttribute("curso") CursoDTO curso, Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(REDIRECT_MIS_CURSOS);

        try {
            this.cursoService.borrarCurso(curso);
        } catch (Exception e) {
            return new ModelAndView(REDIRECT_MIS_CURSOS);
        }

        modelAndView.addObject(TABLA_CURSOS,
                this.cursoService.getCursosMatriculados(((UsuarioDTO) session.getAttribute(USUARIO)).getIdUsuario()));

        return modelAndView;
    }

    @Override
    @PostMapping(path = { "/inscribirse" })
    public ModelAndView inscribirse(@RequestParam("idCurso") Long idCurso, Model model, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView(REDIRECT_MIS_CURSOS);

        try {
            this.cursoUsuarioService.inscribirse(((UsuarioDTO) session.getAttribute(USUARIO)).getIdUsuario(), idCurso);
        } catch (Exception e) {
            return new ModelAndView(REDIRECT_CURSOS);
        }

        modelAndView.addObject(TABLA_CURSOS,
                this.cursoService.getCursosMatriculados(((UsuarioDTO) session.getAttribute(USUARIO)).getIdUsuario()));

        return modelAndView;
    }

}
