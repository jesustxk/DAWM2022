package com.dawm.service;

import java.util.List;

import com.dawm.model.dto.CursoDTO;
import com.dawm.model.dto.UsuarioDTO;
import com.dawm.model.util.ListaCurso;

public interface CursoService {

    public List<ListaCurso> getAllCursos();

    public List<ListaCurso> getCursosMatriculados(Long idUsuario);

    public List<ListaCurso> getMisCursos(UsuarioDTO usuarioDTO);

    public List<ListaCurso> getTopCursos();

    public void addCurso(CursoDTO curso);

    public void editarCurso(CursoDTO curso);

    public void borrarCurso(CursoDTO curso);

}
