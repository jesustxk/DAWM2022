package com.dawm.service;

import java.util.List;

import com.dawm.model.dto.CursoDTO;
import com.dawm.model.dto.UsuarioDTO;
import com.dawm.model.util.ListaCurso;

public interface CursoService {
    
    public String insertCurso(CursoDTO cursoDTO);

    public List<ListaCurso> getAllCursos();

    public List<ListaCurso> getCursosMatriculados(Long idUsuario);

    public List<ListaCurso> getCursosPropietario(UsuarioDTO usuarioDTO);

    public List<ListaCurso> getTopCursos();

}
